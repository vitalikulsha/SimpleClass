package SimpleClass_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class Simple_10 {
    Airline[] airlines;

    public Simple_10(Airline[] airlines) {
        this.airlines = airlines;
    }

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Airline[] airlines = new Airline[5];
        airlines[0] = new Airline("Лондон", "LN-101", "Airbus A320", "12:30", new String[]{"Четверг", "Воскресенье"});
        airlines[1] = new Airline("Париж", "PR-202", "Airbus A330", "10:20", new String[]{"Вторник", "Пятница"});
        airlines[2] = new Airline("Москва", "MS-303", "Boeing-747", "16:40", new String[]{"Понедельник"});
        airlines[3] = new Airline("Берлин", "BR-404", "Boeing-777", "22:15", new String[]{"Вторник", "Четверг", "Суббота"});
        airlines[4] = new Airline("Лондон", "LN-505", "Ту-134", "08:10", new String[]{"Вторник", "Пятница"});
        System.out.println("Список рейсов для заданного пункта назначения:");
        searchDestination(reader, airlines);
        System.out.println("\nСписок рейсов для заданного дня недели:");
        ArrayList<Airline> airlinesArray = searchDayWeek(reader, airlines);
        if (airlinesArray.size() != 0) {
            for (Airline al : airlinesArray) {
                System.out.println(al.toString());
            }
        }
        System.out.println("\nСписок рейсов для заданного дня недели, время вылета для которых больше заданного:");
        searchDayWeekTimeDeparture(reader, airlines);
    }

    //список рейсов для заданного пункта назначения;
    public static void searchDestination(BufferedReader reader, Airline[] airlines) throws IOException {
        System.out.print("Введите пункт назначения: ");
        String destination = reader.readLine();
        int count = 0;
        for (int i = 0; i < airlines.length; i++) {
            if (airlines[i].getDestination().equalsIgnoreCase(destination)) {
                System.out.println(airlines[i].toString());
            } else {
                count++;
            }
        }
        if (count == airlines.length) {
            System.out.println("Рейс с пунктом назначения '" + destination + "' не найден.");
        }
    }

    //список рейсов для заданного дня недели;
    public static ArrayList<Airline> searchDayWeek(BufferedReader reader, Airline[] airlines) throws IOException {
        System.out.print("Введите день недели: ");
        ArrayList<Airline> airlinesArray = new ArrayList<>();
        SimpleDateFormat formatDayWeek = new SimpleDateFormat("E");
        try {
            Date dayWeek = formatDayWeek.parse(reader.readLine());
            for (int i = 0; i < airlines.length; i++) {
                for (int j = 0; j < airlines[i].getDayWeek().length; j++) {
                    if (airlines[i].getDayWeek()[j].equals(dayWeek)) {
                        airlinesArray.add(airlines[i]);
                    }
                }
            }
            if (airlinesArray.size() == 0) {
                System.out.println("В заданный день недели - '" + formatDayWeek.format(dayWeek) + "', рейсы отсутствуют.");
            }
        } catch (ParseException e) {
            System.out.println("День недели введен не верно: " + e);
        }
        return airlinesArray;
    }

    //список рейсов для заданного дня недели, время вылета для которых больше заданного.
    public static void searchDayWeekTimeDeparture(BufferedReader reader, Airline[] airlines) throws IOException {
        ArrayList<Airline> airlinesArray = searchDayWeek(reader, airlines);
        SimpleDateFormat formatTimeDeparture = new SimpleDateFormat("HH:mm");
        try {
            if (airlinesArray.size() != 0) {
                System.out.print("Введите время вылета в формате 'HH:mm': ");
                Date timeDeparture = formatTimeDeparture.parse(reader.readLine());
                int count = 0;
                for (int i = 0; i < airlinesArray.size(); i++) {
                    if (airlinesArray.get(i).getTimeDeparture().compareTo(timeDeparture) > 0) {
                        System.out.println(airlinesArray.get(i).toString());
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Рейсы после " + formatTimeDeparture.format(timeDeparture) + " отсутствуют.");
                }
            }
        } catch (ParseException e) {
            System.out.println("Время вылета введено не верно" + e);
        }
    }
}
