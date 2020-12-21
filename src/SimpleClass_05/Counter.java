package SimpleClass_05;

/* Task 05
5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать
свое значение на единицу в заданном диапазоне.
Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями.
Счетчик имеет методы увеличения и уменьшения состояния,
и метод позволяющее получить его текущее состояние.
Написать код, демонстрирующий все возможности класса.
 */

import static java.lang.Math.*;

public class Counter {
    int count;
    int beginCount;
    int endCount;

    public Counter() {
    }

    public Counter(int beginCount, int endCount) {
        this.beginCount = beginCount;
        this.endCount = endCount;
        this.count = (int) (random() * ((endCount - beginCount) + 1)) + beginCount;
    }

    public Counter(int count, int beginCount, int endCount) {
        this.count = count;
        this.beginCount = beginCount;
        this.endCount = endCount;
    }

    int reduceCount() {
        if (count == beginCount) {
            //System.out.println("Счетчик имеет значение, равное началу диапазона count = " + count +
            //        ". Значение не изменилось.");
            return count;
        } else if (count > beginCount && count <= endCount) {
            //System.out.println("Счетчик уменьшился на единицу count = " + --count + ".");
            return --count;
        } else {
            //System.out.println("Значение счетчика count = " + count + " выходит за пределы диапазона ["
            //        + beginCount + ", " + endCount + "].");
            return count;
        }
    }

    int increaseCount() {
        if (count == endCount) {
            //System.out.println("Счетчик имеет значение, равное концу диапазона count = " + count +
            //        ". Значение не изменилось.");
            return count;
        } else if (count < endCount && count >= beginCount) {
            //System.out.println("Счетчик увеличился на единицу count = " + ++count + ".");
            return ++count;
        } else {
            //System.out.println("Значение счетчика count = " + count + " выходит за пределы диапазона ["
            //        + beginCount + ", " + endCount + "].");
            return count;
        }
    }

    int currentValueCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Счетчик:" +
                " исходное значение счетчика count = " + count +
                ", начало диапазона beginCount = " + beginCount +
                ", конец диапазона endCount = " + endCount + ".";
    }
}
