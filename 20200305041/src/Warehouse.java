import java.util.ArrayList;
import java.util.List;

// Add this import statement for the Product interface
import java.util.stream.Collectors;

// Class implementing ProductManagement interface with a generic collection (List)
class Warehouse<T extends Product> implements ProductManagement<T> {
    List<T> products = new ArrayList<>();

    public Warehouse() {
    }

    @Override
    public void addProduct(T product) {
        products.add(product);
    }

    @Override
    public void deleteProduct(String productName) {
        products.removeIf(product -> product.getName().equals(productName));
    }

    @Override
    public void displayProducts() {
        System.out.println("Current Products:");
        products.forEach(product -> System.out.println(product));
    }
}
