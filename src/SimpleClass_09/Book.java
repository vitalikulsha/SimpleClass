package SimpleClass_09;

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
public class Book {
    private int id;
    private String title;
    private String author;
    private String publishingHouse;
    private int yearPublication;
    private int numberPages;
    private double price;
    private String typeBinding;

    public Book() {
    }

    public Book(int id, String title, String author, String publishingHouse, int yearPublication, int numberPages, double price, String typeBinding) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.yearPublication = yearPublication;
        this.numberPages = numberPages;
        this.price = price;
        this.typeBinding = typeBinding;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTypeBinding() {
        return typeBinding;
    }

    public void setTypeBinding(String typeBinding) {
        this.typeBinding = typeBinding;
    }

    @Override
    public String toString() {
        return "Книга: " +
                "id - " + id +
                ", название - '" + title + '\'' +
                ", автор(ы) - '" + author + '\'' +
                ", издательство - '" + publishingHouse + '\'' +
                ", год издания - " + yearPublication +
                ", количество страниц - " + numberPages +
                ", цена - " + price +
                ", тип переплета - '" + typeBinding + '\'' +
                '.';
    }
}
