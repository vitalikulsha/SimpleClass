package SimpleClass_09;

import SimpleClass_08.Customer;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Locale;

/* Task 09
9. Создать класс Book, спецификация которого приведена ниже.
Определить конструкторы, set- и get- методы и метод  toString().
Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами.
Задать критерии выбора данных и вывести эти данные на консоль.
Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
Найти и вывести:
a) список книг заданного автора;
b) список книг, выпущенных заданным издательством;
c) список книг, выпущенных после заданного года.
 */
public class BookHolder {
    private Book[] book;

    public BookHolder() {
    }

    public BookHolder(Book[] book) {
        this.book = book;
    }

    //список книг заданного автора;
    public void searchAuthor(String author) {
        boolean test = true;
        for (Book b : this.book) {
            if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                test = false;
                System.out.println(b.toString());
            }
        }
        if (test) {
            System.out.println("Книги автора '" + author + "' не найдены.");
        }
    }

    //список книг, выпущенных заданным издательством
    public void searchPublishingHouse(String publishingHouse) {
        boolean test = true;
        for (Book b : this.book) {
            if (publishingHouse.equals(b.getPublishingHouse())) {
                test = false;
                System.out.println(b.toString());
            }
        }
        if (test) {
            System.out.println("Книги издательства '" + publishingHouse + "' не найдены.");
        }
    }

    //список книг, выпущенных после заданного года.
    public void searchPublicationYear(int publicationYear) {
        boolean test = true;
        for (Book b : this.book) {
            if (publicationYear <= b.getPublicationYear()) {
                test = false;
                System.out.println(b.toString());
            }
        }
        if (test) {
            System.out.println("Книги, выпущенные после " + publicationYear + " года, не найдены.");
        }
    }

    public Book[] getBook() {
        return book;
    }

    public void setBook(Book[] book) {
        this.book = book;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Book value : book) {
            str.append(value.toString() + "\n");
        }
        return str.toString();
    }
}
