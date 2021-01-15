package SimpleClass_10;

import java.util.ArrayList;
import java.util.Date;

/* Task 10
10. Создать класс Airline, спецификация которого приведена ниже.
Определить конструкторы, set- и get- методы и метод  toString().
Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами.
Задать критерии выбора данных и вывести эти данные на консоль.
Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
Найти и вывести:
a) список рейсов для заданного пункта назначения;
b) список рейсов для заданного дня недели;
c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */
public class AirlineHolder {
    private Airline[] airline;

    public AirlineHolder() {
    }

    public AirlineHolder(Airline[] airline) {
        this.airline = airline;
    }

    public Airline[] getAirline() {
        return airline;
    }

    public void setAirline(Airline[] airline) {
        this.airline = airline;
    }

    //список рейсов для заданного пункта назначения;
    public void searchDestination(String destination) {
        boolean test = true;
        for (Airline al : airline) {
            if (al.getDestination().equals(destination)) {
                test = false;
                System.out.println(al.toString());
            }
        }
        if (test) {
            System.out.println("Рейс с пунктом назначения '" + destination + "' не найден.");
        }
    }

    //список рейсов для заданного дня недели;
    public ArrayList<Airline> searchDayWeek(Date dayWeek) {
        boolean test = true;
        ArrayList<Airline> list = new ArrayList<>();
        for (Airline al : airline) {
            for (Date dw : al.getDayWeek()) {
                if (dw.equals(dayWeek)) {
                    test = false;
                    list.add(al);
                }
            }
        }
        if (test) {
            System.out.println("В заданный день недели - '" + new Airline().getFormatDayWeek().format(dayWeek) +
                    "', рейсы отсутствуют.");
        }
        return list;
    }

    public void searchDayWeekTimeDeparture(Date dayWeek, Date timeDeparture) {
        boolean test = true;
        ArrayList<Airline> list = searchDayWeek(dayWeek);
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getTimeDeparture().compareTo(timeDeparture) > 0) {
                    System.out.println(list.get(i).toString());
                    test = false;
                }
            }
            if (test) {
                System.out.println("В заданный день недели - '" + new Airline().getFormatDayWeek().format(dayWeek) +
                        "', рейсы после " + new Airline().getFormatTimeDeparture().format(timeDeparture) + " отсутствуют.");
            }
        }
    }
}
