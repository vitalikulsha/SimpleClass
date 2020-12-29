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

    public String getNameDestination() {
        return nameDestination;
    }

    public int getNumberTrain() {
        return numberTrain;
    }

    public Date getTimeDeparture() {
        return timeDeparture;
    }

    public Train readTrain(BufferedReader reader) throws IOException, ParseException {
        System.out.print("Введите пункт назначения: ");
        this.nameDestination = reader.readLine();
        System.out.print("Введите номер поезда: ");
        try {
            this.numberTrain = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Номер поезда введен неверно: " + e +
                    ".\nНомер поезда установлен по умолчанию '0'.");
            this.numberTrain = 0;
        }
        System.out.print("Введите время отправления поезда в формате 'HH-mm': ");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm");
        try {
            this.timeDeparture = simpleDateFormat.parse(reader.readLine());
        } catch (ParseException e) {
            System.out.println("Время отправления поезда введено неверно: " + e +
                    ".\nВремя отправления поезда установлено по умолчанию '00-00'.");
            this.timeDeparture = simpleDateFormat.parse("00-00");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Train(nameDestination, numberTrain, timeDeparture);
    }

    //добавьте возможность сортировки элементов массива по номерам поездов.
    public static Comparator<Train> NumberTrainComparator = new Comparator<Train>() {
        @Override
        public int compare(Train tr1, Train tr2) {
            return tr1.getNumberTrain() - tr2.getNumberTrain();
        }
    };

    //Добавьте возможность сортировки массив по пункту назначения,
    //причем поезда с одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
    public static Comparator<Train> NameAndTimeComparator = new Comparator<Train>() {
        @Override
        public int compare(Train tr1, Train tr2) {
            int flag = tr1.getNameDestination().compareTo(tr2.getNameDestination());
            if (flag == 0) {
                flag = tr1.getTimeDeparture().compareTo(tr2.getTimeDeparture());
            }
            return flag;
        }
    };

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm");
        return "Поезд: " +
                "пункт назначения - '" + nameDestination + '\'' +
                ", номер поезда - " + numberTrain +
                ", время отправления - '" + simpleDateFormat.format(timeDeparture) + '\'';
    }
}