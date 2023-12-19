import java.util.Scanner;

public class WarehouseControlService {
    public static void main(String[] args) {
        Warehouse<ConcreteProduct> warehouse = new Warehouse<>();

        // Adding initial products
        warehouse.addProduct(new ConcreteProduct("Product1", 20.0));
        warehouse.addProduct(new ConcreteProduct("Product2", 30.0));
        warehouse.addProduct(new ConcreteProduct("Product3", 25.0));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Welcome To Warehouse Control Service ====");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Display Products");
            System.out.println("4. Buy Product");
            System.out.println("5. Sell Product");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product quantity: ");
                    double productPrice = scanner.nextDouble();
                    warehouse.addProduct(new ConcreteProduct(productName, productPrice));
                    break;
                case 2:
                    System.out.print("Enter product name to delete: ");
                    String productToDelete = scanner.nextLine();
                    warehouse.deleteProduct(productToDelete);
                    break;
                case 3:
                    warehouse.displayProducts();
                    break;
                case 4:
                case 5:
                    System.out.print("Enter product name: ");
                    String transProductName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int transQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    ConcreteProduct transProduct = warehouse.products.stream()
                            .filter(p -> p.getName().equals(transProductName))
                            .findFirst()
                            .orElse(null);

                    if (transProduct != null) {
                        Transaction.processTransaction(transProduct, transQuantity, choice == 4);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                case 6:
                    System.out.println("Exiting Warehouse Control Service. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
