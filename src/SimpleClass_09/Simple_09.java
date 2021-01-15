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
        BookHolder bookHolder = new BookHolder();
        bookHolder.setBook(new Book[5]);
        bookHolder.getBook()[0] = new Book(1, "Идиот", "Достоевский Ф.М.", "Азбука", 2012, 640, 9.44, "твёрдый");
        bookHolder.getBook()[1] = new Book(2, "Преступление и наказание", "Достоевский Ф.М.", "Азбука", 2019, 608, 9.35, "твердый");
        bookHolder.getBook()[2] = new Book(3, "Война и мир", "Толстой Л.Н.", "Азбука", 2014, 1408, 15.81, "твёрдый");
        bookHolder.getBook()[3] = new Book(4, "12 стульев", "Ильф И.А., Петров Е.П.", "АСТ", 2016, 448, 9.60, "мягкий");
        bookHolder.getBook()[4] = new Book(5, "Братья Карамазовы", "Достоевский Ф.М.", "АСТ", 2018, 896, 15.54, "твердый");
        System.out.print("Список книга заданного автора: ");
        String author = reader.readLine();
        bookHolder.searchAuthor(author);
        System.out.print("Список книг заданного издательства: ");
        String publishingHouse = reader.readLine();
        bookHolder.searchPublishingHouse(publishingHouse);
        System.out.print("Список книг, выпущенных после заданного года: ");
        int publicationYear = Integer.parseInt(reader.readLine());
        bookHolder.searchPublicationYear(publicationYear);
        reader.close();
    }
}
