package SimpleClass_08;
/* Task 08
8. Создать класс Customer, спецификация которого приведена ниже.
Определить конструкторы, set- и get- методы и метод  toString().
Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и методами.
Задать критерии выбора данных и вывести эти данные на консоль.
Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
Найти и вывести:
a) список покупателей в алфавитном порядке;
b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Simple_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomerHolder customerHolder = new CustomerHolder();
        customerHolder.setQuantityCustomers(9);
        customerHolder.setCustomer(new Customer[customerHolder.getQuantityCustomers()]);
        for (int i = 0; i < customerHolder.getCustomer().length; i++) {
            customerHolder.getCustomer()[i] = new Customer((i + 1), randomLastName(), randomFirstName(), randomPatronymic(),
                    randomAddress(), (i + 101), ((i + 101) * 100));
        }
        System.out.println("Исходный список покупателей:\n" + customerHolder.toString());
        System.out.println("Список покупателей в алфавитном порядке:");
        customerHolder.sortCustomerAlphabet();
        System.out.println("\nСписок покупателей, у которых номер кредитной карточки находится в заданном интервале:");
        int[] interval = readInterval(reader);
        customerHolder.searchCreditCardNumber(interval[0], interval[1]);
        reader.close();
    }

    //Ввод и проверка интервала для поиска номеров кредитных карточек
    private static int[] readInterval(BufferedReader reader) throws IOException {
        System.out.print("Введите начало интервала: ");
        int begin = Integer.parseInt(reader.readLine());
        System.out.print("Введите конец интервала: ");
        int end = Integer.parseInt(reader.readLine());
        while (begin > end) {
            System.out.print("Конец интервала введен не верно!\nВведите конец интервала:");
            end = Integer.parseInt(reader.readLine());
        }
        return new int[]{begin, end};
    }

    private static String[] lastNameArr = {"Иванов", "Петров", "Семенов", "Сергеев", "Алешин"};
    private static String[] firstNameArr = {"Иван", "Петр", "Семен", "Сергей", "Алексей"};
    private static String[] patronymicArr = {"Иванович", "Петрович", "Семенович", "Сергеевич", "Алексеевич"};
    private static String[] addressArr = {"Жодино", "Борисов", "Минск", "Логойск", "Смолевичи"};

    private static String randomLastName() {
        return lastNameArr[new Random().nextInt(lastNameArr.length)];
    }

    private static String randomFirstName() {
        return firstNameArr[new Random().nextInt(firstNameArr.length)];
    }

    private static String randomPatronymic() {
        return patronymicArr[new Random().nextInt(patronymicArr.length)];
    }

    private static String randomAddress() {
        return addressArr[new Random().nextInt(addressArr.length)];
    }
}
