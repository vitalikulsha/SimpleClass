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
            Train tr = new Train();
            tr.readTrain(reader);
            trains[i] = tr;
        }
        System.out.println("\nСписок поездов:");
        for (Train train : trains) {
            System.out.println(train.toString());
        }
        Train[] sortNumberTrainArray = sortNumberTrain(trains);
        System.out.println("\nСписок поездов, отсортированых по номерам:");
        for (Train train : sortNumberTrainArray) {
            System.out.println(train.toString());
        }
        System.out.println("\n" + searchNumberTrain(reader, trains));
        Train[] sortTimeDepartureArray = new Train().sortNameDestination(trains);
        System.out.println("\nСписок поездов, отсортированных по пунктам назначени: ");
        for (Train train : sortTimeDepartureArray) {
            System.out.println(train.toString());
        }
        reader.close();
    }

    //добавьте возможность сортировки элементов массива по номерам поездов.
    public static Train[] sortNumberTrain(Train[] trains) {
        for (int step = trains.length / 2; step > 0; step /= 2) {
            for (int i = step; i < trains.length; i++) {
                for (int j = i - step; j >= 0 && trains[j].numberTrain > trains[j + step].numberTrain; j -= step) {
                    Train temp = trains[j];
                    trains[j] = trains[j + step];
                    trains[j + step] = temp;
                }
            }
        }
        return trains;
    }

    //Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
    public static String searchNumberTrain(BufferedReader reader, Train[] trains) throws IOException {
        System.out.print("Для поиска введите номер поезда: ");
        int readNumberTrain = Integer.parseInt(reader.readLine());
        int count = 0;
        Train tempTrain = new Train();
        for (int i = 0; i < trains.length; i++) {
            if (trains[i].numberTrain == readNumberTrain) {
                tempTrain = trains[i];
            } else {
                count++;
            }
        }
        return count != trains.length ? tempTrain.toString() : "Поезд с номером " + readNumberTrain + " не найден";
    }
}
