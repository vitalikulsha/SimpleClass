package SimpleClass_04;

/* Task 04
4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массив из пяти элементов типа Train,
добавьте возможность сортировки элементов массива по номерам поездов.
Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
Добавьте возможность сортировки массив по пункту назначения,
причем поезда с одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Simple_04 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Train[] trains = new Train[5];
        for (int i = 0; i < trains.length; i++) {
            trains[i] = new Train().readTrain(reader);
        }
        System.out.println("\nСписок поездов:");
        for (Train train : trains) {
            System.out.println(train.toString());
        }
        Train[] sortNumberTrainArray = new Train().sortNumberTrain(trains);
        System.out.println("\nСписок поездов, отсортированых по номерам:");
        for (Train train : sortNumberTrainArray) {
            System.out.println(train.toString());
        }
        System.out.println("\n" + new Train().searchNumberTrain(reader, trains));
        Train[] sortTimeDepartureArray = new Train().sortNameDestination(trains);
        System.out.println("\nСписок поездов, отсортированных по пунктам назначени: ");
        for (Train train : sortTimeDepartureArray) {
            System.out.println(train.toString());
        }
        reader.close();
    }
}
