public class ShoppingFacade {
    private ProductCatalog productCatalog;
    private PaymentProcessor paymentProcessor;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;

    public ShoppingFacade() {
        this.productCatalog = new ProductCatalog();
        this.paymentProcessor = new PaymentProcessor();
        this.inventoryManager = new InventoryManager();
        this.shippingService = new ShippingService();
    }

    public void placeOrder(String productDescription, String cardNumber, String cvv, String expirationDate, String address) {
        Integer productId = productCatalog.findProduct(productDescription);
        if (productId == null) {
            System.out.println("Product \"" + productDescription + "\" does not exist. Sorry, order is invalid." );
            return;
        }
        System.out.println("Product \"" + productDescription + "\" is found." );

        if (!inventoryManager.isProductAvailable(productId)) {
            System.out.println("Product \"" + productDescription + "\" is not available. We have no this product in stock. Sorry!" );
            return;
        };

        float productPrice = productCatalog.getProductPrice(productId);
        System.out.println("Product price is " + productPrice + "$.");

        float shippingPrice = shippingService.calculateShippingPrice(productId, address);
        System.out.println("Price of shipping to address \"" + address + "\" is " + shippingPrice + "$.");

        float totalPrice = productPrice + shippingPrice;
        System.out.println("Total price is " + totalPrice + "$.");

        boolean paymentProcessing = paymentProcessor.processPayment(cardNumber, cvv, expirationDate, totalPrice);
        if (paymentProcessing) {
            System.out.println("Payment for order is successfully operated!");
        } else {
            System.out.println("Payment for order is not operated. Payment data is invalid. Please, try again, using actual card data.");
            return;
        }

        shippingService.shipOrder(productId, address);
        System.out.println("Request to start shipping is sent. Wait!");
    }
}
