package addItemstobasket.shoppingBasket.Product;

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
}
