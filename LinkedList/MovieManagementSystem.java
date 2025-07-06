import java.util.Scanner;

public class MovieManagementSystem {
    static class Node {
        String title;
        String director;
        int year;
        double rating;
        Node next;
        Node prev;

        public Node(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }
    }

    static class MovieLinkedList {
        Node head;
        Node tail;
        public MovieLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addAtBeginning(String title, String director, int year, double rating) {
            Node newNode = new Node(title, director, year, rating);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }

            System.out.println("Movie added at the beginning successfully.");
        }

        public void addAtEnd(String title, String director, int year, double rating) {
            Node newNode = new Node(title, director, year, rating);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }

            System.out.println("Movie added at the end successfully.");
        }

        public void addAtPosition(int position, String title, String director, int year, double rating) {
            if (position == 1) {
                addAtBeginning(title, director, year, rating);
                return;
            }

            Node newNode = new Node(title, director, year, rating);
            Node current = head;
            int count = 1;

            while (current != null && count < position - 1) {
                current = current.next;
                count++;
            }

            if (current == null) {
                System.out.println("Position is beyond the length of the list.");
                return;
            }

            if (current == tail) {
                addAtEnd(title, director, year, rating);
                return;
            }

            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;

            System.out.println("Movie added at position " + position + " successfully.");
        }

        public void removeByTitle(String title) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            if (head.title.equalsIgnoreCase(title)) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null;
                }
                System.out.println("Movie with title '" + title + "' removed successfully.");
                return;
            }

            Node current = head;

            while (current != null && !current.title.equalsIgnoreCase(title)) {
                current = current.next;
            }

            if (current == null) {
                System.out.println("Movie with title '" + title + "' not found.");
                return;
            }

            if (current == tail) {
                tail = tail.prev;
                tail.next = null;
                System.out.println("Movie with title '" + title + "' removed successfully.");
                return;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;

            System.out.println("Movie with title '" + title + "' removed successfully.");
        }

        public void searchByDirector(String director) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            Node current = head;
            boolean found = false;

            System.out.println("\nMovies directed by '" + director + "':");
            while (current != null) {
                if (current.director.equalsIgnoreCase(director)) {
                    displayMovie(current);
                    found = true;
                }
                current = current.next;
            }

            if (!found) {
                System.out.println("No movies found with director '" + director + "'.");
            }
        }

        public void searchByRating(double rating) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            Node current = head;
            boolean found = false;

            System.out.println("\nMovies with rating " + rating + ":");
            while (current != null) {
                if (current.rating == rating) {
                    displayMovie(current);
                    found = true;
                }
                current = current.next;
            }

            if (!found) {
                System.out.println("No movies found with rating " + rating + ".");
            }
        }

        public void displayForward() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            Node current = head;
            System.out.println("\nMovies (Forward Order):");
            while (current != null) {
                displayMovie(current);
                current = current.next;
            }
        }

        public void displayReverse() {
            if (tail == null) {
                System.out.println("List is empty.");
                return;
            }

            Node current = tail;
            System.out.println("\nMovies (Reverse Order):");
            while (current != null) {
                displayMovie(current);
                current = current.prev;
            }
        }

        public void updateRating(String title, double newRating) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            Node current = head;
            boolean found = false;

            while (current != null) {
                if (current.title.equalsIgnoreCase(title)) {
                    current.rating = newRating;
                    System.out.println("Rating updated successfully for movie with title '" + title + "'.");
                    found = true;
                    break;
                }
                current = current.next;
            }

            if (!found) {
                System.out.println("Movie with title '" + title + "' not found.");
            }
        }

        private void displayMovie(Node movie) {
            System.out.println("Title: " + movie.title);
            System.out.println("Director: " + movie.director);
            System.out.println("Year: " + movie.year);
            System.out.println("Rating: " + movie.rating);
            System.out.println("-------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieLinkedList movieList = new MovieLinkedList();
        int choice, year, position;
        String title, director;
        double rating;

        do {
            System.out.println("\nMovie Management System");
            System.out.println("1. Add a movie at the beginning");
            System.out.println("2. Add a movie at the end");
            System.out.println("3. Add a movie at a specific position");
            System.out.println("4. Remove a movie by title");
            System.out.println("5. Search for a movie by director");
            System.out.println("6. Search for a movie by rating");
            System.out.println("7. Display all movies in forward order");
            System.out.println("8. Display all movies in reverse order");
            System.out.println("9. Update a movie's rating");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter director: ");
                    director = scanner.nextLine();
                    System.out.print("Enter year of release: ");
                    year = scanner.nextInt();
                    System.out.print("Enter rating (0.0-10.0): ");
                    rating = scanner.nextDouble();
                    movieList.addAtBeginning(title, director, year, rating);
                    break;

                case 2:
                    System.out.print("Enter movie title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter director: ");
                    director = scanner.nextLine();
                    System.out.print("Enter year of release: ");
                    year = scanner.nextInt();
                    System.out.print("Enter rating (0.0-10.0): ");
                    rating = scanner.nextDouble();
                    movieList.addAtEnd(title, director, year, rating);
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    position = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter movie title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter director: ");
                    director = scanner.nextLine();
                    System.out.print("Enter year of release: ");
                    year = scanner.nextInt();
                    System.out.print("Enter rating (0.0-10.0): ");
                    rating = scanner.nextDouble();
                    movieList.addAtPosition(position, title, director, year, rating);
                    break;

                case 4:
                    System.out.print("Enter movie title to remove: ");
                    title = scanner.nextLine();
                    movieList.removeByTitle(title);
                    break;

                case 5:
                    System.out.print("Enter director name to search: ");
                    director = scanner.nextLine();
                    movieList.searchByDirector(director);
                    break;

                case 6:
                    System.out.print("Enter rating to search: ");
                    rating = scanner.nextDouble();
                    movieList.searchByRating(rating);
                    break;

                case 7:
                    movieList.displayForward();
                    break;

                case 8:
                    movieList.displayReverse();
                    break;

                case 9:
                    System.out.print("Enter movie title to update rating: ");
                    title = scanner.nextLine();
                    System.out.print("Enter new rating (0.0-10.0): ");
                    rating = scanner.nextDouble();
                    movieList.updateRating(title, rating);
                    break;

                case 10:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 10);
    }
}