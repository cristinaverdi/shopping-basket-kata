package addItemstobasket.infrastructure;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

import addItemstobasket.shoppingBasket.product.*;

public class ProductRepository implements Warehouse {
    private List<Product> products;

    public ProductRepository() {
        products = init();
    }

    public boolean isProductAvailable(ProductId productId) {
       return products.stream()
                        .anyMatch(product -> product.getProductId() == productId.value());
    }

    @Override
    public Optional<Product> findProductById(ProductId productId) {
        return products.stream()
                        .filter(product -> product.getProductId() == productId.value())
                        .findFirst();
    }

    public List<Product> init() {
        return Arrays.asList(
                new Product(new ProductId(10002), new Title("The Hobbit"), new Price(5)),
                new Product(new ProductId(20010), new Title("Breaking Bad"), new Price(7)),
                new Product(new ProductId(20001), new Title("Game of Thrones"), new Price(9)),
                new Product(new ProductId(10001), new Title("Lord of the Rings"), new Price(10))
        );
    }
}
