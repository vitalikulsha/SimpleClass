package SimpleClass_06;

/* Task 06
6. Составьте описание класса для представления времени.
Предусмотрте возможности установки времени и изменения его отдельных полей
(час, минута, секунда) с проверкой допустимости вводимых значений.
В случае недопустимых значений полей поле устанавливается в значение 0.
Создать методы изменения времени на заданное количество часов, минут и секунд.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Simple_06_MyTime {
    public static void main(String[] args) throws IOException {
        MyTime myTime = new MyTime();
        myTime.setDefaultTime();
        System.out.println(myTime.toString());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        myTime.readTime(reader);
        System.out.println(myTime.toString());
        myTime.changeHours(reader);
        System.out.println(myTime.toString());
        myTime.changeMinutes(reader);
        System.out.println(myTime.toString());
        myTime.changeSeconds(reader);
        System.out.println(myTime.toString());
        System.out.println("hours = " + myTime.hours + ", minutes = " + myTime.minutes + ", seconds = " + myTime.seconds);
        reader.close();
    }
}

