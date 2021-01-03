package SimpleClass_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
public class Simple_09 {
    Book[] books;

    public Simple_09(Book[] books) {
        this.books = books;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Book[] books = new Book[5];
        books[0] = new Book(1, "Идиот", "Достоевский Ф.М.", "Азбука", 2012, 640, 9.44, "твёрдый");
        books[1] = new Book(2, "Преступление и наказание", "Достоевский Ф.М.", "Азбука", 2019, 608, 9.35, "твердый");
        books[2] = new Book(3, "Война и мир", "Толстой Л.Н.", "Азбука", 2014, 1408, 15.81, "твёрдый");
        books[3] = new Book(4, "12 стульев", "Ильф И.А., Петров Е.П.", "АСТ", 2016, 448, 9.60, "мягкий");
        books[4] = new Book(5, "Братья Карамазовы", "Достоевский Ф.М.", "АСТ", 2018, 896, 15.54, "твердый");
        System.out.println("Список книга заданного автора:");
        searchAuthor(reader, books);
        System.out.println("Список книг заданного издательства:");
        searchPublishingHouse(reader, books);
        System.out.println("Список книг, выпущенных после заданного года:");
        searchYearPublication(reader, books);
        reader.close();
    }

    //список книг заданного автора
    public static void searchAuthor(BufferedReader reader, Book[] books) throws IOException {
        System.out.print("Введите фамилию автора: ");
        String author = reader.readLine();
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getAuthor().toLowerCase().contains(author.toLowerCase())) {
                System.out.println(books[i].toString());
            } else {
                count++;
            }
        }
        if (count == books.length) {
            System.out.println("Книги автора '" + author + "' не найдены.");
        }
    }

    //список книг, выпущенных заданным издательством
    public static void searchPublishingHouse(BufferedReader reader, Book[] books) throws IOException {
        System.out.print("Введите название издательсвта: ");
        String publishingHouse = reader.readLine();
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (publishingHouse.equals(books[i].getPublishingHouse())) {
                System.out.println(books[i].toString());
            } else {
                count++;
            }
        }
        if (count == books.length) {
            System.out.println("Книги издательства '" + publishingHouse + "' не найдены.");
        }
    }

    //список книг, выпущенных после заданного года.
    public static void searchYearPublication(BufferedReader reader, Book[] books) throws IOException {
        System.out.print("Введите год издания книги: ");
        int yearPublication = Integer.parseInt(reader.readLine());
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getYearPublication() >= yearPublication) {
                System.out.println(books[i].toString());
            } else {
                count++;
            }
        }
        if (count == books.length) {
            System.out.println("Книги, выпущенные после " + yearPublication + " года, не найдены.");
        }
    }
}
