package shoppingcart;

import javax.naming.ldap.UnsolicitedNotification;

public class Basket {
    private int customerId;

    public Basket(int customerId) {
        this.customerId = customerId;
    }

    public void add(int quantity, String title) {
        throw new UnsupportedOperationException();
    }
}
