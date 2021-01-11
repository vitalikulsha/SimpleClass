package SimpleClass_08new;

import java.util.Comparator;

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
public class Customer {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private int creditCardNumber;
    private int bankAccountNumber;

    public Customer() {
    }

    public Customer(int id, String lastName, String firstName, String patronymic, String address, int creditCardNumber, int bankAccountNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    // сортировка покупателей в алфавитном порядке: фамилия -> имя -> отчество
    public static Comparator<Customer> SortAlphabet = new Comparator<Customer>() {
        @Override
        public int compare(Customer cust1, Customer cust2) {
            int flag = cust1.getLastName().compareTo(cust2.getLastName());
            if (flag == 0) {
                flag = cust1.getFirstName().compareTo(cust2.getFirstName());
                if (flag == 0) {
                    flag = cust1.getPatronymic().compareTo(cust2.getPatronymic());
                }
            }
            return flag;
        }
    };

    @Override
    public String toString() {
        return "Покупатель: " +
                "id - " + id +
                ", фамилия - '" + lastName + '\'' +
                ", имя - '" + firstName + '\'' +
                ", отчество - '" + patronymic + '\'' +
                ", адрес - '" + address + '\'' +
                ", номер кредитной карты - " + creditCardNumber +
                ", номер банковского счета - " + bankAccountNumber +
                '.';
    }
}
