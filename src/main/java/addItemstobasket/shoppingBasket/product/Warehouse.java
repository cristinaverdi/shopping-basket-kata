package addItemstobasket.shoppingBasket.product;

import java.util.List;
import java.util.Optional;

public interface Warehouse {
    boolean isProductAvailable(ProductId productId);
    Optional<Product> findProductById(ProductId productId);
    List<Product> init();
}
