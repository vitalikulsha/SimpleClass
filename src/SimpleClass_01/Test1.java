package SimpleClass_01;

/* Task 01
1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих переменных.
Добавьте метод, который находит сумму значений этих переменных, и метод,
который находит наибольшее значение из этих двух переменных.
 */

import java.io.BufferedReader;
import java.io.IOException;

import static java.lang.Math.*;

public class Test1 {
    int variableFirst = 50;
    int variableSecond = 20;

    void print() {
        System.out.println("Первая переменная variableFirst = " + this.variableFirst +
                "\nВторая переменная variableSecond = " + this.variableSecond);
    }

    int sumVariables() {
        return this.variableFirst + this.variableSecond;
    }

    int maxVariable() {
        return variableFirst > variableSecond ? variableFirst : variableSecond;
    }

    int readVariable(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
