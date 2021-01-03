package SimpleClass_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
public class Simple_08 {
    Customer[] customer;

    public Simple_08(Customer[] customer) {
        this.customer = customer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Customer[] customers = new Customer[5];
        customers[0] = new Customer(1, "Иванов", "Иван", "Иванович", "Жодино", 101, 10100);
        customers[1] = new Customer(2, "Иванов", "Иван", "Александрович", "Минск", 102, 10200);
        customers[2] = new Customer(3, "Иванов", "Александр", "Иванович", "Борисов", 103, 10300);
        customers[3] = new Customer(4, "Алешин", "Алексей", "Алексеевич", "Смолевичи", 104, 10400);
        customers[4] = new Customer(5, "Сергеев", "Сергей", "Сергеевич", "Логойск", 105, 10500);
        System.out.println("Список покупателей в алфовитном порядке:");
        sortCustomerAlphabet(customers);
        System.out.println("Список покупателей, у которых номер кредитной карточки находится в заданном интервале:");
        searchCreditCardNumber(reader, customers);
        reader.close();
    }

    //вывод списка покупателей по алфовиту
    public static void sortCustomerAlphabet(Customer[] customers) {
        Arrays.sort(customers, Customer.SortAlphabet);
        for (Customer cust : customers) {
            System.out.println(cust.toString());
        }
    }

    //вывод списка покупателей, у которых номер кредитной карточки находится в заданном интервале
    public static void searchCreditCardNumber(BufferedReader reader, Customer[] customers) throws IOException {
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
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getCreditCardNumber() >= begin && customers[i].getCreditCardNumber() <= end) {
                System.out.println(customers[i].toString());
            } else {
                count++;
            }
        }
        if (count == customers.length) {
            System.out.println("Покупатели с кредитными картами в интервале [" + begin + ", " + end + "] не найдены.");
        }
    }

}
