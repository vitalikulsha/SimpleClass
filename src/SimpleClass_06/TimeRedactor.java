package SimpleClass_06;

/* Task 06
6. Составьте описание класса для представления времени.
Предусмотрте возможности установки времени и изменения его отдельных полей
(час, минута, секунда) с проверкой допустимости вводимых значений.
В случае недопустимых значений полей поле устанавливается в значение 0.
Создать методы изменения времени на заданное количество часов, минут и секунд.
 */

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;

public class TimeRedactor {
    Date time;

    public Date setDefaultTime() {
        time = new Date();
        return time;
    }

    public Date readTime(BufferedReader reader) {
        System.out.print("Введите время в формате 'HH:mm:ss': ");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            time = timeFormat.parse(reader.readLine());
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println("Время введено неверно: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return time;
    }

    public Date changeHours(BufferedReader reader) {
        System.out.print("Изменить текущее значение часов на HH = ");
        try {
            int hours = Integer.parseInt(reader.readLine());
            if (hours >= 0 && hours <= 23) {
                time.setHours(hours);
            } else {
                System.out.println("Значение часов введено не верно. Текущее значение часов установлено на '0'.");
                time.setHours(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return time;
    }

    public Date changeMinutes(BufferedReader reader) {
        System.out.print("Изменить текущее значение минут на mm = ");
        try {
            int minutes = Integer.parseInt(reader.readLine());
            if (minutes >= 0 && minutes <= 59) {
                time.setMinutes(minutes);
            } else {
                System.out.println("Значение минут введено не верно. Текущее значение минут установлено на '0'.");
                time.setMinutes(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return time;
    }

    public Date changeSeconds(BufferedReader reader) {
        System.out.print("Изменить текущее значение секунд на ss = ");
        try {
            int seconds = Integer.parseInt(reader.readLine());
            if (seconds >= 0 && seconds <= 59) {
                time.setSeconds(seconds);
            } else {
                System.out.println("Значение секунд введено не верно. Текущее значение секунд установлено на '0'.");
                time.setSeconds(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return time;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return "Текущее значение времени time = " + simpleDateFormat.format(time);
    }
}
