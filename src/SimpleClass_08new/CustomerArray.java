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

public class CustomerArray {
    private int quantityCustomers;
    private Customer[] customerArray;

    public int getQuantityCustomers() {
        return quantityCustomers;
    }

    public void setQuantityCustomers(int quantityCustomers) {
        this.quantityCustomers = quantityCustomers;
    }

    public Customer[] getCustomerArray() {
        return customerArray;
    }

    public void setCustomerArray(Customer[] customerArray) {
        this.customerArray = customerArray;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Customer value : customerArray) {
            str.append(value.toString() + "\n");
        }
        return str.toString();
    }
}
