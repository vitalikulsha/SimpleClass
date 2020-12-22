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

public class Simple_06 {
    public static void main(String[] args) throws IOException {
        TimeRedactor timeRedactor = new TimeRedactor();
        timeRedactor.setDefaultTime();
        System.out.println(timeRedactor.toString());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        timeRedactor.readTime(reader);
        System.out.println(timeRedactor.toString());
        timeRedactor.changeHours(reader);
        System.out.println(timeRedactor.toString());
        timeRedactor.changeMinutes(reader);
        System.out.println(timeRedactor.toString());
        timeRedactor.changeSeconds(reader);
        System.out.println(timeRedactor.toString());
        reader.close();
    }
}
