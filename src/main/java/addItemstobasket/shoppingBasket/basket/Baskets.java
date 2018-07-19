package addItemstobasket.shoppingBasket.basket;

import java.util.Optional;

import addItemstobasket.shoppingBasket.customer.CustomerId;

public interface Baskets {
        Optional<Basket> basketFor(CustomerId customerId);
        void add(Basket basket);
}
