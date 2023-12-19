// Interface for managing products
interface ProductManagement<T extends Product> {
    void addProduct(T product);

    void deleteProduct(String productName);

    void displayProducts();
}