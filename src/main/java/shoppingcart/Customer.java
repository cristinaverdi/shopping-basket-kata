package shoppingcart;

public class Customer {
    private final CustomerId customerId;

    public Customer(CustomerId customerId) {
        this.customerId = customerId;
    }

    public void addItemToBasket(int quantity, String title) {
        throw new UnsupportedOperationException();
    }

    public String checkBasketContent() {
        throw new UnsupportedOperationException();
    }
}
