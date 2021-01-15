package SimpleClass_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
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
        AirlineHolder airlineHolder = new AirlineHolder(new Airline[5]);
        airlineHolder.getAirline()[0] = new Airline("Лондон", "LN-101", "Airbus A320", "12:30", new String[]{"Четверг", "Воскресенье"});
        airlineHolder.getAirline()[1] = new Airline("Париж", "PR-202", "Airbus A330", "10:20", new String[]{"Вторник", "Пятница"});
        airlineHolder.getAirline()[2] = new Airline("Москва", "MS-303", "Boeing-747", "16:40", new String[]{"Понедельник"});
        airlineHolder.getAirline()[3] = new Airline("Берлин", "BR-404", "Boeing-777", "22:15", new String[]{"Вторник", "Четверг", "Суббота"});
        airlineHolder.getAirline()[4] = new Airline("Лондон", "LN-505", "Ту-134", "08:10", new String[]{"Вторник", "Пятница"});

        System.out.print("Список рейсов для заданного пункта назначения: ");
        String destination = reader.readLine();
        airlineHolder.searchDestination(destination);

        System.out.println("\nСписок рейсов для заданного дня недели:");
        printAirlineList(airlineHolder.searchDayWeek(readDayWeek(reader)));

        System.out.println("\nСписок рейсов для заданного дня недели, время вылета для которых больше заданного:");
        airlineHolder.searchDayWeekTimeDeparture(readDayWeek(reader), readTimeDeparture(reader));
    }

    private static Date readDayWeek(BufferedReader reader) throws IOException {
        boolean test = true;
        Date dayWeek = null;
        while (test) {
            System.out.print("Введите день недели: ");
            try {
                test = false;
                dayWeek = new Airline().getFormatDayWeek().parse(reader.readLine());
            } catch (ParseException e) {
                test = true;
                System.out.println("День недели введен не верно: " + e);
            }
        }
        return dayWeek;
    }

    private static Date readTimeDeparture(BufferedReader reader) throws IOException {
        boolean test = true;
        Date timeDeparture = null;
        while (test) {
            System.out.print("Введите время вылета в формате 'HH:mm': ");
            try {
                test = false;
                timeDeparture = new Airline().getFormatTimeDeparture().parse(reader.readLine());
            } catch (ParseException e) {
                test = true;
                System.out.println("Время вылета введено не верно: " + e);
            }
        }
        return timeDeparture;
    }

    private static void printAirlineList(ArrayList<Airline> list) {
        for (Airline al : list) {
            System.out.println(al.toString());
        }
    }
}
