public class Main {
    public static void main(String[] args) {
        ShoppingFacade shoppingFacade = new ShoppingFacade();

        // Attempt to place order number 1 (with correct data)
        System.out.println("-------------------------ATTEMPT 1-------------------------");
        String productDescription = "Laptop";
        String cardNumber = "1234567812345678";
        String cvv = "123";
        String expirationDate = "12/25";
        String address = "123 Main St, Cityville";

        System.out.println("Placing order for product: " + productDescription);
        shoppingFacade.placeOrder(productDescription, cardNumber, cvv, expirationDate, address);

        // Attempt to place order number 2 (with incorrect data)
        System.out.println("-------------------------ATTEMPT 2-------------------------");
        productDescription = "Smartphone";
        cardNumber = "1234567812345678";
        cvv = "123";
        expirationDate = "12/23";
        address = "123 Main St, Cityville";

        System.out.println("Placing order for product: " + productDescription);
        shoppingFacade.placeOrder(productDescription, cardNumber, cvv, expirationDate, address);
    }
}

