package addItemstobasket.infrastructure;

import addItemstobasket.shoppingBasket.basket.Basket;
import addItemstobasket.shoppingBasket.basket.Baskets;
import addItemstobasket.shoppingBasket.customer.CustomerId;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class BasketRepository implements Baskets {
    private List<Basket> contents;

    public BasketRepository() {
        this.contents = new ArrayList<>();
    }

    public Optional<Basket> basketFor(CustomerId customerId) {
        Optional<Basket> basket = this.contents
                        .stream()
                        .filter(b -> b.owner().equals(customerId))
                        .findFirst();
        return basket;
    }

    public void add(Basket basket) {
        contents.add(basket);
    }
}
