package addItemstobasket.shoppingBasket.basket;

import addItemstobasket.shoppingBasket.Customer.CustomerId;

import java.util.Optional;

public interface Baskets {
        Optional<Basket> basketFor(CustomerId customerId);
        void add(Basket basket);
}
