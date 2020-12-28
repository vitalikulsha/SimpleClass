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
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Train {
    String nameDestination;
    int numberTrain;
    Date timeDeparture;

    public Train() {
    }

    public Train(String nameDestination, int numberTrain, Date timeDeparture) {
        this.nameDestination = nameDestination;
        this.numberTrain = numberTrain;
        this.timeDeparture = timeDeparture;
    }

    Train readTrain(BufferedReader reader) throws IOException, ParseException {
        System.out.print("Введите пункт назначения: ");
        nameDestination = reader.readLine();
        System.out.print("Введите номер поезда: ");
        numberTrain = Integer.parseInt(reader.readLine());
        System.out.print("Введите время отправления поезда в формате 'HH-mm': ");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm");
        timeDeparture = simpleDateFormat.parse(reader.readLine());
        return new Train(nameDestination, numberTrain, timeDeparture);
    }

    //Добавьте возможность сортировки массив по пункту назначения,
    //причем поезда с одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
    Train[] sortNameDestination(Train[] trains) {
        boolean sorted = true;
        while (sorted) {
            sorted = false;
            for (int i = 0; i < trains.length - 1; i++) {
                if (trains[i].nameDestination.compareTo(trains[i + 1].nameDestination) >= 0) {
                    if (trains[i].nameDestination.compareTo(trains[i + 1].nameDestination) > 0) {
                        Train temp = trains[i];
                        trains[i] = trains[i + 1];
                        trains[i + 1] = temp;
                        sorted = true;
                    } else {
                        if (trains[i].timeDeparture.compareTo(trains[i + 1].timeDeparture) > 0) {
                            Train temp = trains[i];
                            trains[i] = trains[i + 1];
                            trains[i + 1] = temp;
                            sorted = true;
                        }
                    }
                }
            }
        }
        return trains;
    }



    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm");
        return "Поезд: " +
                "пункт назначения - '" + nameDestination + '\'' +
                ", номер поезда - " + numberTrain +
                ", время отправления - '" + simpleDateFormat.format(timeDeparture) + '\'';
    }
}