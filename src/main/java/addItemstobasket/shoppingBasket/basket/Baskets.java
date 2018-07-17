package addItemstobasket.shoppingBasket.basket;

import java.util.Optional;

import addItemstobasket.shoppingBasket.Customer.CustomerId;

public interface Baskets {
        Optional<Basket> basketFor(CustomerId customerId);
        void add(Basket basket);
}
