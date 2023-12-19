// Concrete implementation of Product interface
class ConcreteProduct implements Product {
    private String name;
    private double price;

    public ConcreteProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Quantity: " + price;
    }
}