package addItemstobasket.shoppingBasket.basket;

import addItemstobasket.shoppingBasket.product.Product;
import addItemstobasket.shoppingBasket.customer.CustomerId;

import java.util.List;
import java.util.ArrayList;

public class Basket {
    private String creationDate;
    private List<Product> content;
    private CustomerId customerId;
    private Clock clock;

    public Basket(CustomerId customerId, Clock clock) {
        this.customerId = customerId;
        this.clock = clock;
        this.content = new ArrayList<>();
        this.creationDate = clock.todayAsString();
    }

    public CustomerId owner() {
        return customerId;
    }

    public Basket create(CustomerId customerId) {
        return new Basket(customerId, clock);
    }

    public void addItem(Product product, int quantity) {
        for(int i = 0; i < quantity; i++) {
            content.add(product);
        }
    }

    public String creationDateAsString() {
        return this.creationDate;
    }

    public List<Product> products() {
        return this.content;
    }
}
