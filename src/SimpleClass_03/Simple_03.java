package SimpleClass_03;

/* Task 03
3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы,
успеваемость (массив из пяти элементов). Создайте массив из десяти элементов такого типа.
Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simple_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Student[] students = new Student[10];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student().readStudent(reader);
        }
        for (Student student : students) {
            System.out.println(student.toString());
        }
        System.out.println("Список студентов, имеющих оценки, равные только 9 или 10:");
        for (int i = 0; i < students.length; i++) {
            students[i].printExcellentStudent(students[i]);
        }
    }
}
