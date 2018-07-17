package addItemstobasket.shoppingBasket.basket;

import addItemstobasket.shoppingBasket.Customer.CustomerId;
import addItemstobasket.shoppingBasket.Product.Product;
import addItemstobasket.shoppingBasket.Product.ProductId;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<ProductId> content;
    private CustomerId customerId;

    public Basket(CustomerId customerId) {
        this.customerId = customerId;
        content = new ArrayList<>();
    }

    public String format() {
        throw new UnsupportedOperationException();
    }

    public CustomerId owner() {
        return customerId;
    }

    public Basket create(CustomerId customerId) {
        return new Basket(customerId);
    }

    public void addItem(ProductId productId, int quantity) {
        for(int i = 0; i < quantity; i++) {
            content.add(productId);
        }
    }

    public List<ProductId> content() {
        return this.content;
    }

    public String creationDate() {
        throw new UnsupportedOperationException();
    }

    public List<Product> products() {
        throw new UnsupportedOperationException();
    }
}
