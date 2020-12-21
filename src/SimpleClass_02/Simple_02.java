package SimpleClass_02;

/* Task 02
2. Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами.
Добавьте конструктор, инициализирующий члены класса по умолчанию.
Добавьте set- и get- методы для полей экземпляра класса.
 */

public class Simple_02 {
    public static void main(String[] args) {
        Test2 test = new Test2();
        Test2 testParametr = new Test2(2, 3);
        System.out.println(test.toString());
        System.out.println(testParametr.toString());
    }
}
