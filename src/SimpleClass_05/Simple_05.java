package SimpleClass_05;

/* Task 05
5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать
свое значение на единицу в заданном диапазоне.
Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями.
Счетчик имеет методы увеличения и уменьшения состояния,
и метод позволяющее получить его текущее состояние.
Написать код, демонстрирующий все возможности класса.
 */
public class Simple_05 {
    public static void main(String[] args) {
        Counter count1 = new Counter();
        Counter countRandom = new Counter(0, 10);
        Counter count2 = new Counter(5, 0, 10);
        System.out.println(count1.toString());
        System.out.println(countRandom.toString());
        System.out.println(count2.toString());
        Counter countError = new Counter(-5, 0, 5);
        Counter count3 = new Counter(2, 0, 20);
        countError.reduceCount();
        count1.reduceCount();
        countRandom.reduceCount();
        count3.reduceCount();
        count3.reduceCount();
        count3.reduceCount();
        count3.increaseCount();
        count3.increaseCount();
        System.out.println("Текущее значение счетчика count = " + count3.currentValueCount());
    }
}
