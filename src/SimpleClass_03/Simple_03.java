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
        Student[] students = new Student[5];
        for (int i = 0; i < students.length; i++) {
            Student st = new Student();
            st.readStudent(reader);
            students[i] = st;
        }
        for (Student student : students) {
            System.out.println(student.toString());
        }
        System.out.println("Список студентов, имеющих оценки, равные только 9 или 10:");
        printExcellentStudent(students);
    }

    public static void printExcellentStudent(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            int count = 0;
            for (int j = 0; j < students[i].assessment.length; j++) {
                if (students[i].assessment[j] == 9 || students[i].assessment[j] == 10) {
                    if (j == (students[i].assessment.length - 1)) {
                        System.out.println("Фамилия и инициалы - '" + students[i].fullName + '\'' +
                                ", номер группы - '" + students[i].groupNumber + '\'');
                    }
                    continue;
                } else {
                    break;
                }
            }
        }
    }
}