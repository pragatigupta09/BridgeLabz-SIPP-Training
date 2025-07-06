class Book {
    String title, author, genre, bookID;
    boolean isAvailable;
    Book prev, next;

    public Book(String title, String author, String genre, String bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.prev = null;
        this.next = null;
    }
}

class Library {
    Book head = null, tail = null;

    void addBookAtEnd(String title, String author, String genre, String bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    void addBookAtBeginning(String title, String author, String genre, String bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    void removeBookByID(String bookID) {
        Book current = head;
        while (current != null) {
            if (current.bookID.equals(bookID)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    void searchBookByTitleOrAuthor(String query) {
        Book current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(query) || current.author.equalsIgnoreCase(query)) {
                System.out.println("Book Found: " + current.title + ", " + current.author + ", " + current.genre + ", " + current.bookID + ", " + (current.isAvailable ? "Available" : "Not Available"));
            }
            current = current.next;
        }
    }

    void updateAvailability(String bookID, boolean status) {
        Book current = head;
        while (current != null) {
            if (current.bookID.equals(bookID)) {
                current.isAvailable = status;
                return;
            }
            current = current.next;
        }
    }

    void displayForward() {
        Book current = head;
        while (current != null) {
            System.out.println(current.title + " | " + current.author + " | " + current.genre + " | " + current.bookID + " | " + (current.isAvailable ? "Available" : "Not Available"));
            current = current.next;
        }
    }

    void displayReverse() {
        Book current = tail;
        while (current != null) {
            System.out.println(current.title + " | " + current.author + " | " + current.genre + " | " + current.bookID + " | " + (current.isAvailable ? "Available" : "Not Available"));
            current = current.prev;
        }
    }

    int countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBookAtEnd("Atomic Habits", "James Clear", "Self-help", "B101", true);
        library.addBookAtBeginning("The Alchemist", "Paulo Coelho", "Fiction", "B102", true);
        library.addBookAtEnd("Deep Work", "Cal Newport", "Productivity", "B103", false);

        System.out.println("Books in Forward Order:");
        library.displayForward();

        System.out.println("\nBooks in Reverse Order:");
        library.displayReverse();

        System.out.println("\nSearching for book by author:");
        library.searchBookByTitleOrAuthor("Paulo Coelho");

        System.out.println("\nUpdating availability of B103...");
        library.updateAvailability("B103", true);

        System.out.println("\nBooks after update:");
        library.displayForward();

        System.out.println("\nRemoving B102...");
        library.removeBookByID("B102");

        System.out.println("\nBooks after removal:");
        library.displayForward();

        System.out.println("\nTotal books in library: " + library.countBooks());
    }
}
