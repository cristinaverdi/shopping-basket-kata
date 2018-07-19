package addItemstobasket.shoppingBasket.basket;

import addItemstobasket.shoppingBasket.product.Product;
import addItemstobasket.shoppingBasket.customer.CustomerId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Basket {
    private List<Product> content;
    private CustomerId customerId;
    private Date creationDate;

    public Basket(CustomerId customerId) {
        this.customerId = customerId;
        this.content = new ArrayList<>();
        this.creationDate = new Date();
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

    public void addItem(Product product, int quantity) {
        for(int i = 0; i < quantity; i++) {
            content.add(product);
        }
    }

    public List<Product> content() {
        return this.content;
    }

    public String creationDateAsString() {
        return this.creationDate.toString();
    }

    public List<Product> products() {
        throw new UnsupportedOperationException();
    }
}
