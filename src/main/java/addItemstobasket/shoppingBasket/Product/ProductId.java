package addItemstobasket.shoppingBasket.Product;

import java.util.Objects;

public class ProductId {
    private int productId;

    public ProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductId)) return false;
        ProductId productId1 = (ProductId) o;
        return productId == productId1.productId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId);
    }

    public int value() {
        return productId;
    }
}
