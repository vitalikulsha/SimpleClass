package SimpleClass_10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
public class Airline {
    private String destination;
    private String flightNumber;
    private String airplaneType;
    private Date timeDeparture;
    private Date[] dayWeek;

    public Airline() {
    }

    public Airline(String destination, String flightNumber, String airplaneType, String timeDeparture, String[] dayWeek) throws ParseException {
        SimpleDateFormat formatTimeDeparture = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatDayWeek = new SimpleDateFormat("E");
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.airplaneType = airplaneType;
        this.timeDeparture = formatTimeDeparture.parse(timeDeparture);
        this.dayWeek = new Date[dayWeek.length];
        for (int i = 0; i < dayWeek.length; i++) {
            this.dayWeek[i] = formatDayWeek.parse(dayWeek[i]);
        }
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public Date getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(Date timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public Date[] getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(Date[] dayWeek) {
        this.dayWeek = dayWeek;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatTimeDeparture = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatDayWeek = new SimpleDateFormat("E");
        StringBuilder stringBuilder = new StringBuilder("Авиалиния: " +
                "пункт назначения - '" + destination + '\'' +
                ", номер рейса - '" + flightNumber + '\'' +
                ", тип самолета - '" + airplaneType + '\'' +
                ", время вылета - " + formatTimeDeparture.format(timeDeparture) +
                ", дни недели - [");
        for (int i = 0; i < dayWeek.length; i++) {
            if (i != (dayWeek.length - 1)) {
                stringBuilder.append(formatDayWeek.format(dayWeek[i]) + ", ");
            } else {
                stringBuilder.append(formatDayWeek.format(dayWeek[i]) + "].");
            }
        }
        return stringBuilder.toString();
    }
}
