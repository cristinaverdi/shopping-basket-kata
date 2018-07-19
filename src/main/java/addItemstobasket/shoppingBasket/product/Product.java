package addItemstobasket.shoppingBasket.product;

import java.util.Objects;

public class Product {
    private ProductId productId;
    private Title title;
    private Price price;

    public Product(ProductId productId, Title title, Price price) {
        this.title = title;
        this.price = price;
        this.productId = productId;
    }

    public int getProductId() {
        return productId.value();
    }

    public String getTitle() {
        return title.value();
    }

    public int getPrice() {
        return price.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getProductId(), product.getProductId()) && Objects.equals(getTitle(), product.getTitle()) && Objects.equals(getPrice(), product.getPrice());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getProductId(), getTitle(), getPrice());
    }
}
