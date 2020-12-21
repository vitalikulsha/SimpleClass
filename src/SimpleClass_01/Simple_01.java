package SimpleClass_01;

/* Task 01
1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих переменных.
Добавьте метод, который находит сумму значений этих переменных, и метод,
который находит наибольшее значение из этих двух переменных.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simple_01 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Test1 test = new Test1();
        test.print(test.variableFirst, test.variableSecond);
        System.out.print("Введите новое значение первой переменной variableFirst = ");
        test.variableFirst = test.readVariable(reader);
        //test.variableFirst = test.changVariable(test.variableFirst);
        System.out.print("Введите новое значение второй переменной variableSecond = ");
        test.variableSecond = test.readVariable(reader);
        //test.variableSecond = test.changVariable(test.variableSecond);
        System.out.println("Сумма переменных sum = " + test.sumVariables(test.variableFirst, test.variableSecond));
        System.out.println("Наибольшая переменная maxVariable = " + test.maxVariable(test.variableFirst, test.variableSecond));
        System.out.println("Новое значение первой переменной variableFirst = " + test.randomVariable(test.variableFirst));
        System.out.println("Новое значение первой переменной variableSecond = " + test.randomVariable(test.variableSecond));
        reader.close();
    }
}
