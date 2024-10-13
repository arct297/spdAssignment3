import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map<String, Integer> virtualDatabase;
    private Map<Integer, Float> productsPrices;
    public ProductCatalog() {
        virtualDatabase = new HashMap<>();
        virtualDatabase.put("Laptop", 101);
        virtualDatabase.put("Smartphone", 102);
        virtualDatabase.put("Tablet", 103);
        virtualDatabase.put("Headphones", 104);

        productsPrices = new HashMap<>();
        productsPrices.put(101, 5000.00F);
        productsPrices.put(102, 6500.00F);
        productsPrices.put(103, 4300.00F);
        productsPrices.put(104, 2000.00F);
    }

    public Integer findProduct(String description) {
        if (!isProduct(description)) {
            return null;
        }
        return getProductId(description);
    }

    private boolean isProduct(String description) {
        return virtualDatabase.containsKey(description);
    }

    private Integer getProductId(String description) {
        return virtualDatabase.get(description);
    }

    public Float getProductPrice(Integer productId) {
        return productsPrices.get(productId);
    }
}
