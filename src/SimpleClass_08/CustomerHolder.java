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

import java.util.Arrays;

public class CustomerHolder {
    private int quantityCustomers;
    private Customer[] customer;

    public CustomerHolder() {
    }

    public CustomerHolder(Customer[] customer) {
        this.customer = customer;
    }

    //вывод списка покупателей по алфавиту
    public void sortCustomerAlphabet() {
        Arrays.sort(this.customer, ComparatorCustomer.SortAlphabet);
        for (Customer cust : this.customer) {
            System.out.println(cust.toString());
        }
    }

    //вывод списка покупателей, у которых номер кредитной карточки находится в заданном интервале
    public void searchCreditCardNumber(int begin, int end) {
        boolean test = true;
        for (Customer cust : this.customer) {
            if (cust.getCreditCardNumber() >= begin && cust.getCreditCardNumber() <= end) {
                test = false;
                System.out.println(cust.toString());
            }
        }
        if (test) {
            System.out.println("Покупатели с кредитными картами в интервале [" + begin + ", " + end + "] не найдены.");
        }
    }

    public int getQuantityCustomers() {
        return quantityCustomers;
    }

    public void setQuantityCustomers(int quantityCustomers) {
        this.quantityCustomers = quantityCustomers;
    }

    public Customer[] getCustomer() {
        return customer;
    }

    public void setCustomer(Customer[] customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Customer value : customer) {
            str.append(value.toString() + "\n");
        }
        return str.toString();
    }
}
