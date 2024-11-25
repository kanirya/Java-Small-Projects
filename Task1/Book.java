public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private boolean isIssued;
    private static int totalBooks = 0;

    // Default Constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.isbn = "000-0000";
        this.price = 0.0;
        this.isIssued = false;
        totalBooks++;
    }

    // Parameterized Constructor
    public Book(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.isIssued = false;
        totalBooks++;
    }

    // Methods
    public void issueBook() {
        this.isIssued = true;
    }

    public void returnBook() {
        this.isIssued = false;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public String getDetails() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn +
               ", Price: Rs " + price ;
    }
}
