public class Product {
    private String productId; // Unique identifier for the product
    private String productName; // Name of the product
    private double price; // Original price of the product
    private int stockQuantity; // Available quantity in stock
    private static int totalProducts = 0; // Static variable to track total number of products created
    private double discountPercentage = 0; // Discount percentage applied to the product

    // Default Constructor
    // Initializes product with default values
    public Product() {
        this.productId = "Unknown"; // Default product ID
        this.productName = "Generic Product"; // Default product name
        this.price = 0.0; // Default price (0)
        this.stockQuantity = 0; // Default stock (0)
        totalProducts++; // Increment the total number of products
    }

    // Overloaded Constructor
    // Initializes product with provided values
    public Product(String productId, String productName, double price, int stockQuantity) {
        this.productId = productId; // Set product ID
        this.productName = productName; // Set product name
        this.price = price; // Set product price
        this.stockQuantity = stockQuantity; // Set product stock quantity
        totalProducts++; // Increment the total number of products
        this.discountPercentage = discountPercentage; // Set discount percentage (default 0)
    }

    // Apply a discount to the product
    // The discount is applied based on the provided percentage (between 0 and 100)
    public void applyDiscount(double percentage) {
        // Check if the discount percentage is valid
        if (percentage > 0 && percentage <= 100) {
            discountPercentage = percentage; // Set the discount percentage
            // Display the actual price and the new discounted price
            System.out.println("Discount applied successfully.\nActual Price: Rs" + this.price + " New price: Rs" + getDisPrice());
        } else {
            System.out.println("Invalid discount percentage!"); // Error message if percentage is invalid
        }
    }

    // Check if the product is available in the required quantity
    // Returns true if there is enough stock, otherwise false
    public boolean isAvailable(int quantity) {
        return this.stockQuantity >= quantity; // Compare the required quantity with available stock
    }

    // Sell the product (reduce stock quantity)
    // If there is enough stock, reduce the stock by the quantity sold
    public void sell(int quantity) {
        if (isAvailable(quantity)) {
            this.stockQuantity -= quantity; // Decrease the stock quantity by the sold quantity
            System.out.println("Sale successful! Remaining stock: " + this.stockQuantity); // Show remaining stock
        } else {
            System.out.println("Insufficient stock!"); // Error message if not enough stock
        }
    }

    // Getter and Setter Methods

    public String getProductId() {
        return productId; // Return the product ID
    }

    public String getProductName() {
        return productName; // Return the product name
    }

    public double getPrice() {
        return this.price; // Return the product price
    }

    // Get the discounted price
    // This method calculates the discounted price by subtracting the discount amount from the original price
    public double getDisPrice() {
        // Calculate the discounted price and return it
        return this.price - (this.price * (discountPercentage / 100)); // Discounted price = price - (price * discountPercentage)
    }

    public int getStockQuantity() {
        return stockQuantity; // Return the current stock quantity
    }

    public static int getTotalProducts() {
        return totalProducts; // Return the total number of products created
    }
}
