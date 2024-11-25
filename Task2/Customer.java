public class Customer {
    private String customerId;
    private String customerName;
    private double totalPurchases;

    // Constructor
    public Customer(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.totalPurchases = 0.0;
    }

    // Purchase a product
    public void purchase(Product product, int quantity) {
    
        if (product.isAvailable(quantity)) {
            double cost = product.getDisPrice() * quantity;
            product.sell(quantity);
            this.totalPurchases += cost;
            System.out.println(customerName + " purchased " + quantity + " units of " + product.getProductName() + ". Total cost: Rs" + cost);
        } else {
            System.out.println("Purchase failed: Insufficient stock!");
        }
    }

    // Getter and Setter Methods
    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPurchases() {
        return totalPurchases;
    }
}
