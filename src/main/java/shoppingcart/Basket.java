package shoppingcart;

import java.util.List;

public class Basket {
    private CustomerId customerId;

    public Basket(CustomerId customerId) {
        this.customerId = customerId;
    }

    public void add(int quantity, String title) {
        throw new UnsupportedOperationException();
    }

    public String format() {
        throw new UnsupportedOperationException();
    }

    public CustomerId owner() {
        throw new UnsupportedOperationException();
    }

    public void create() {
        throw new UnsupportedOperationException();
    }

    public void addItem(ProductId productId, int quantity) {
        throw new UnsupportedOperationException();
    }

    public List<ProductId> content() {
        throw new UnsupportedOperationException();
    }
}
