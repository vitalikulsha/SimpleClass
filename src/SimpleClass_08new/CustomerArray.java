package SimpleClass_08new;

import java.util.Arrays;

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
