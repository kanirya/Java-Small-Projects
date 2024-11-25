import java.util.Scanner;

public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library("City Library", "123 Main St");
        Scanner scanner = new Scanner(System.in);
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 499)); // Book 1
        library.addBook(new Book("1984 by George Orwell", "George Orwell", "9780451524935", 399)); // Book 2
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", 350)); // Book 3
        library.addBook(new Book("Moby Dick", "Herman Melville", "9781503280786", 550)); // Book 4
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "9781503290563", 450)); // Book 5
        library.addBook(new Book("War and Peace", "Leo Tolstoy", "9781853260629", 800)); // Book 6
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488", 400)); // Book 7
        library.addBook(new Book("Crime and Punishment", "Fyodor Dostoevsky", "9780140449136", 600)); // Book 8
        library.addBook(new Book("Brave New World", "Aldous Huxley", "9780060850524", 500)); // Book 9
        library.addBook(new Book("The Odyssey", "Homer", "9780140268867", 450)); // Book 10
        




        while (true) {
            System.out.println("\n=== Library Management Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search by Author");
            System.out.println("5. Show Available Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    library.addBook(new Book(title, author, isbn, price));
                    break;
                case 2:
                    System.out.print("Enter the title of the book to issue: ");
                    String issueTitle = scanner.nextLine();
                    for (Book book : library.getBooks()) {
                        if (book.getTitle().equalsIgnoreCase(issueTitle) && !book.isIssued()) {
                            book.issueBook();
                            System.out.println("Book issued successfully.");
                            break;
                        }
                                        
                    }
                    break;
                    case 3:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    for (Book book : library.getBooks()) { // Use the getter method
                        if (book != null && book.getTitle().equalsIgnoreCase(returnTitle) && book.isIssued()) {
                            book.returnBook();
                            System.out.println("Book returned successfully.");
                            break;
                        }
                    }
                    break;
                
                case 4:
                    System.out.print("Enter author name: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;
                case 5:
                    library.showAvailableBooks();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
