package addItemstobasket.shoppingBasket.basket;

import org.junit.Test;
import org.junit.Before;
import addItemstobasket.infrastructure.BasketRepository;
import addItemstobasket.shoppingBasket.customer.CustomerId;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BasketsTest {

    private Basket basket;

    private CustomerId customerId;
    private BasketRepository basketRepository;

    @Before public void
    set_up() {
        basketRepository = new BasketRepository();
        customerId = new CustomerId(1234);
        basket = new Basket(customerId);
    }

    @Test public void
    retrieve_basket_from_CustomerId() {
        basketRepository.add(basket);
        basketRepository.basketFor(customerId);
        assertThat(basketRepository.basketFor(customerId).get(), is(basket));
    }
}
