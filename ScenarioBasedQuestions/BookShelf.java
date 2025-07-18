package ScenarioBasedQuestions;
import java.util.*;
class Book {
    String title, author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return title + " by " + author;
    }

}

public class BookShelf {
    HashMap<String, LinkedList<Book>> genreMap = new HashMap<>();
    HashSet<String> bookSet = new HashSet<>(); 

    public void addBook(String genre, Book book) {
        if (bookSet.contains(book.title)) return;
        genreMap.putIfAbsent(genre, new LinkedList<>());
        genreMap.get(genre).add(book);
        bookSet.add(book.title);
    }

    public void borrowBook(String genre, String title) {
        LinkedList<Book> books = genreMap.get(genre);
        if (books != null) {
            books.removeIf(b -> b.title.equals(title));
            bookSet.remove(title);
        }
    }

    public void returnBook(String genre, Book book) {
        addBook(genre, book);
    }

    public void displayBooks() {
        for (String genre : genreMap.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book book : genreMap.get(genre)) {
                System.out.println("  " + book);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BookShelf book = new BookShelf();
        while (true) {
            System.out.println("\n--- BookShelf Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Catalog");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    book.addBook(genre, new Book(title, author));
                    break;

                case 2:
                    System.out.print("Enter genre: ");
                    genre = sc.nextLine();
                    System.out.print("Enter title to borrow: ");
                    title = sc.nextLine();
                    book.borrowBook(genre, title);
                    break;

                case 3:
                    System.out.print("Enter genre: ");
                    genre = sc.nextLine();
                    System.out.print("Enter title: ");
                    title = sc.nextLine();
                    System.out.print("Enter author: ");
                    author = sc.nextLine();
                    book.returnBook(genre, new Book(title, author));
                    break;

                case 4:
                    book.displayBooks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        
    }
}
