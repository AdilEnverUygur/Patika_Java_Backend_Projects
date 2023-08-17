package Book;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Book> bookSetByName = new TreeSet<>();
        bookSetByName.add(new Book("Harry Potter", 400, "J.K. Rowling", "2001-05-15"));
        bookSetByName.add(new Book("Lord of the Rings", 600, "J.R.R. Tolkien", "1987-10-01"));
        bookSetByName.add(new Book("The Great Gatsby", 250, "F. Scott Fitzgerald", "1925-04-10"));
        bookSetByName.add(new Book("To Kill a Mockingbird", 320, "Harper Lee", "1960-07-11"));
        bookSetByName.add(new Book("1984", 280, "George Orwell", "1949-06-08"));

        System.out.println("Books Sorted by Name:");
        for (Book book : bookSetByName) {
            System.out.println(book);
        }

        Set<Book> bookSetByPageCount = new TreeSet<>(Comparator.comparingInt(Book::getPageCount));
        bookSetByPageCount.addAll(bookSetByName);

        System.out.println("\nBooks Sorted by Page Count:");
        for (Book book : bookSetByPageCount) {
            System.out.println(book);
        }
    }
}
