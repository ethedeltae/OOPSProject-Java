import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int copies;

    public Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }
}

class Library {
    private ArrayList<Book> catalog = new ArrayList<>();

    public void addBook(Book book) {
        catalog.add(book);
    }

    public void displayCatalog() {
        for (Book book : catalog) {
            System.out.println("Title: " + book.title + ", Author: " + book.author + ", Copies: " + book.copies);
        }
    }

    public void borrowBook(String title) {
        for (Book book : catalog) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.copies > 0) {
                    book.copies--;
                    System.out.println("Book '" + title + "' has been borrowed.");
                } else {
                    System.out.println("No more copies of '" + title + "' available.");
                }
                return;
            }
        }
        System.out.println("Book '" + title + "' not found in the catalog.");
    }

    public void returnBook(String title) {
        for (Book book : catalog) {
            if (book.title.equalsIgnoreCase(title)) {
                book.copies++;
                System.out.println("Book '" + title + "' has been returned.");
                return;
            }
        }
        System.out.println("Book '" + title + "' not found in the catalog.");
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Library Management System Menu:");
                System.out.println("1. Add a Book");
                System.out.println("2. Display Catalog");
                System.out.println("3. Borrow a Book");
                System.out.println("4. Return a Book");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author name: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter number of copies: ");
                        int copies = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        Book newBook = new Book(title, author, copies);
                        library.addBook(newBook);
                        System.out.println("Book added to the catalog.");
                        break;

                    case 2:
                        System.out.println("Catalog Contents:");
                        library.displayCatalog();
                        break;

                    case 3:
                        System.out.print("Enter book title to borrow: ");
                        String borrowTitle = scanner.nextLine();
                        library.borrowBook(borrowTitle);
                        break;

                    case 4:
                        System.out.print("Enter book title to return: ");
                        String returnTitle = scanner.nextLine();
                        library.returnBook(returnTitle);
                        break;

                    case 5:
                        System.out.println("Exiting the Library Management System.");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                scanner.nextLine(); // Clear the input buffer.
            }
        }
    }
}
