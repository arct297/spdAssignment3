import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<Integer, Integer> productsInStock;

    public InventoryManager () {
        productsInStock = new HashMap<>();
        productsInStock.put(101, 5);
        productsInStock.put(102, 3);
        productsInStock.put(103, 10);
    }

    public boolean isProductAvailable(int productId) {
        return getAmountOfProductInStock(productId) > 0;
    }

    private int getAmountOfProductInStock(int productId) {
        if (!productsInStock.containsKey(productId)) {
            return 0;
        }
        return productsInStock.get(productId);
    }


}
