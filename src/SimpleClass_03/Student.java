package SimpleClass_03;

/* Task 03
3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы,
успеваемость (массив из пяти элементов). Создайте массив из десяти элементов такого типа.
Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Student {
    String fullName;
    String groupNumber; //т.к. номер группы может содержать буквы
    int[] assessment = new int[5];

    public Student() {
    }

    public Student(String fullName, String groupNumber, int[] assessment) {
        this.fullName = fullName;
        this.groupNumber = groupNumber;
        this.assessment = assessment;
    }

    Student readStudent(BufferedReader reader) throws IOException {
        System.out.print("Введите фамилию и инициалы студента: ");
        fullName = reader.readLine();
        System.out.print("Введите номер группы студента: ");
        groupNumber = reader.readLine();
        for (int i = 0; i < assessment.length; i++) {
            System.out.print("Введите " + (i + 1) + "-ую оценку студента: ");
            assessment[i] = Integer.parseInt(reader.readLine());
            while (assessment[i] < 0 || assessment[i] > 10) {
                System.out.print("Оценка введена неверно, введите " + (i + 1) + "-ую оценку студента:");
                assessment[i] = Integer.parseInt(reader.readLine());
            }
        }
        return new Student(fullName, groupNumber, assessment);
    }

    //Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
    void printExcellentStudent(Student student) {
        int count = 0;
        for (int i = 0; i < student.assessment.length; i++) {
            if (student.assessment[i] >= 9 && student.assessment[i] <= 10) {
                count++;
            } else {
                break;
            }
        }
        if (count == 5) {
            System.out.println("Фамилия и инициалы - '" + student.fullName + '\'' +
                    ", номер группы - '" + groupNumber + '\'');
        }
    }

    @Override
    public String toString() {
        return "Студент: " +
                "фамилия и инициалы - '" + fullName + '\'' +
                ", номер группы - '" + groupNumber + '\'' +
                ", успеваемость: " + Arrays.toString(assessment);
    }
}
