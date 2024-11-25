import java.util.ArrayList;

public class Library {
    private String name;
    private String address;
    private ArrayList<Book> books;

    // Constructor
    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
    }

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully: " + book.getTitle());
    }

    // Search by Author
    public void searchByAuthor(String author) {
        System.out.println("Books by " + author + ":");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book.getDetails());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by this author.");
        }
    }

    // Show Available Books
    public void showAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isIssued()) {
                System.out.println(book.getDetails());
            }
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    
}
