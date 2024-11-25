import java.util.ArrayList;
import java.util.Scanner;

public class ECommerceTest {
    public static void main(String[] args) {
        // Create scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Lists to hold products and customers
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        
        // Demo data of products
        products.add(new Product("001", "Nike Running Shoes", 4500, 100)); 
        products.add(new Product("002", "Samsung Galaxy Watch", 25000, 50)); 
        products.add(new Product("003", "Levi's Denim Jeans", 2500, 200)); 
        products.add(new Product("004", "Adidas Sports Shoes", 3500, 75)); 
        products.add(new Product("005", "Apple iPhone 14", 74999, 30)); 
        products.add(new Product("006", "Fossil Leather Wallet", 3500, 150)); 
        products.add(new Product("007", "Casio Analog Watch", 2000, 100)); 
        products.add(new Product("008", "Ray-Ban Sunglasses", 8000, 120)); 
        products.add(new Product("009", "Louis Vuitton Handbag", 50000, 40)); 
        products.add(new Product("010", "Canon DSLR Camera", 60000, 25)); 
    
       //demo data of customers
       customers.add(new Customer("001", "Danish"));
       customers.add(new Customer("002", "Mohsin"));
       customers.add(new Customer("003", "Baseer"));
       customers.add(new Customer("004", "Asjad"));
       customers.add(new Customer("005", "Abu Bakar"));
       
       
        boolean exit = false;
        
        // Main loop for the e-commerce system
        while (!exit) {
            // Display menu options for the user
            System.out.println("\n--- E-Commerce Platform ---");
            System.out.println("1. Add a Product");
            System.out.println("2. View All Products");
            System.out.println("3. Apply Discount to a Product");
            System.out.println("4. Add a Customer");
            System.out.println("5. Make a Purchase");
            System.out.println("6. View Customer Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();  // Get the user's choice
            scanner.nextLine();  // Consume newline after int input

            switch (choice) {
                case 1:
                    // Add a new product
                    System.out.print("Enter Product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Stock Quantity: ");
                    int stock = scanner.nextInt();
                    // Create new product and add to the list
                    products.add(new Product(productId, productName, price, stock));
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    // View all products in the system
                    System.out.println("\n--- Product List ---");
                    for (Product product : products) {
                        // Display product details including discounted price
                        System.out.println("ID: " + product.getProductId() + ", Name: " + product.getProductName() +
                                ", Actual Price: Rs" + product.getPrice() + ", Discounted Price: Rs" + product.getDisPrice() +
                                ", Stock: " + product.getStockQuantity());
                    }
                    break;

                case 3:
                    // Apply discount to a specific product
                    System.out.print("Enter Product ID to apply discount: ");
                    String discountId = scanner.nextLine();
                    for (Product product : products) {
                        if (product.getProductId().equals(discountId)) {
                            System.out.print("Enter Discount Percentage: ");
                            double discount = scanner.nextDouble();
                            // Apply discount to the selected product
                            product.applyDiscount(discount);
                        }
                    }
                    break;

                case 4:
                    // Add a new customer
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    // Create new customer and add to the list
                    customers.add(new Customer(customerId, customerName));
                    System.out.println("Customer added successfully!");
                    break;

                case 5:
                    // Make a purchase for a customer
                    System.out.print("Enter Customer ID: ");
                    String custId = scanner.nextLine();
                    Customer purchasingCustomer = null;
                    // Find the customer by their ID
                    for (Customer customer : customers) {
                        if (customer.getCustomerId().equals(custId)) {
                            purchasingCustomer = customer;
                            break;
                        }
                    }

                    if (purchasingCustomer != null) {
                        // Ask for the product to purchase
                        System.out.print("Enter Product ID to purchase: ");
                        String purchaseId = scanner.nextLine();
                        Product purchasingProduct = null;
                        // Find the product by its ID
                        for (Product product : products) {
                            if (product.getProductId().equals(purchaseId)) {
                                purchasingProduct = product;
                                break;
                            }
                        }

                        if (purchasingProduct != null) {
                            // Ask for quantity to purchase
                            System.out.print("Enter Quantity to purchase: ");
                            int quantity = scanner.nextInt();
                            // Complete the purchase for the customer
                            purchasingCustomer.purchase(purchasingProduct, quantity);
                        } else {
                            System.out.println("Product not found!"); // Error if product not found
                        }
                    } else {
                        System.out.println("Customer not found!"); // Error if customer not found
                    }
                    break;

                case 6:
                    // View all customers' details
                    System.out.println("\n--- Customer List ---");
                    for (Customer customer : customers) {
                        // Display customer details
                        System.out.println("ID: " + customer.getCustomerId() + ", Name: " + customer.getCustomerName() +
                                ", Total Purchases: Rs" + customer.getTotalPurchases());
                    }
                    break;

                case 7:
                    // Exit the system
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    // Handle invalid menu choices
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close(); // Close the scanner to avoid resource leaks
    }
}
