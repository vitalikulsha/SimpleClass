package SimpleClass_01;

/* Task 01
1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих переменных.
Добавьте метод, который находит сумму значений этих переменных, и метод,
который находит наибольшее значение из этих двух переменных.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

public class Test1 {
    int variableFirst = 50;
    int variableSecond = 20;

    void print(int variableFirst, int variableSecond) {
        System.out.println("Первая переменная variableFirst = " + variableFirst +
                "\nВторая переменная variableSecond = " + variableSecond);
    }

    int changVariable(int variable) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        variable = Integer.parseInt(reader.readLine());
        return variable;
    }

    int sumVariables(int variableFirst, int variableSecond) {
        return variableFirst + variableSecond;
    }

    int maxVariable(int variableFirst, int variableSecond) {
        return variableFirst > variableSecond ? variableFirst : variableSecond;
    }

    int readVariable(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    int randomVariable(int variable) {
        return variable = (int) (random() * ((100 - (-100)) + 1) + (-100));
    }
}
