// Class representing a transaction (buying or selling)
class Transaction {
    public static <T extends Product> void processTransaction(T product, int quantity, boolean isBuying) {
        double totalCost = product.getPrice() * quantity;
        String transactionType = isBuying ? "Bought" : "Sold";
        System.out.println(transactionType + " " + quantity + " units of " + product.getName() + " for a total " + (isBuying ? "cost" : "revenue") + " of $" + totalCost);
    }
}