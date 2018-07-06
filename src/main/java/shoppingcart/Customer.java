package shoppingcart;

public class Customer {
    private final int customerId;

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public void addItemToBasket(int quantity, String title) {
        throw new UnsupportedOperationException();
    }

    public String checkBasketContent() {
        throw new UnsupportedOperationException();
    }
}
