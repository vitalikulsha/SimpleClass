package SimpleClass_08new;
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
import java.util.Arrays;
import java.util.Random;

public class Simple_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomerArray customerArray = new CustomerArray();
        customerArray.setQuantityCustomers(9);
        customerArray.setCustomerArray(new Customer[customerArray.getQuantityCustomers()]);
        for (int i = 0; i < customerArray.getCustomerArray().length; i++) {
            customerArray.getCustomerArray()[i] = new Customer((i + 1), randomLastName(), randomFirstName(), randomPatronymic(),
                    randomAddress(), (i + 101), ((i + 101) * 100));
        }
        System.out.println("Исходный список покупателей:\n" + customerArray.toString());
        System.out.println("Список покупателей в алфавитном порядке:");
        sortCustomerAlphabet(customerArray.getCustomerArray());
        System.out.println("\nСписок покупателей, у которых номер кредитной карточки находится в заданном интервале:");
        searchCreditCardNumber(reader, customerArray.getCustomerArray());
        reader.close();
    }

    //вывод списка покупателей по алфавиту
    public static void sortCustomerAlphabet(Customer[] customer) {
        Arrays.sort(customer, Customer.SortAlphabet);
        for (Customer cust : customer) {
            System.out.println(cust.toString());
        }
    }

    //вывод списка покупателей, у которых номер кредитной карточки находится в заданном интервале
    public static void searchCreditCardNumber(BufferedReader reader, Customer[] customer) throws IOException {
        System.out.print("Введите начало интервала: ");
        int begin = Integer.parseInt(reader.readLine());
        System.out.print("Введите конец интервала: ");
        int end = Integer.parseInt(reader.readLine());
        if (begin > end) {
            int temp = begin;
            begin = end;
            end = temp;
        }
        int count = 0;
        for (int i = 0; i < customer.length; i++) {
            if (customer[i].getCreditCardNumber() >= begin && customer[i].getCreditCardNumber() <= end) {
                System.out.println(customer[i].toString());
            } else {
                count++;
            }
        }
        if (count == customer.length) {
            System.out.println("Покупатели с кредитными картами в интервале [" + begin + ", " + end + "] не найдены.");
        }
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
