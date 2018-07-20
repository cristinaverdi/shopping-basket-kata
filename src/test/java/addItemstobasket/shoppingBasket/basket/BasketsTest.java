package addItemstobasket.shoppingBasket.basket;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.mockito.junit.MockitoJUnitRunner;

import addItemstobasket.infrastructure.BasketRepository;
import addItemstobasket.shoppingBasket.customer.CustomerId;

@RunWith(MockitoJUnitRunner.class)
public class BasketsTest {

    private Basket basket;
    @Mock private Clock clock;

    private CustomerId customerId;
    private BasketRepository basketRepository;

    @Before public void
    set_up() {
        basketRepository = new BasketRepository();
        customerId = new CustomerId(1234);
        basket = new Basket(customerId, clock);
    }

    @Test public void
    retrieve_basket_from_CustomerId() {
        basketRepository.add(basket);
        basketRepository.basketFor(customerId);
        assertThat(basketRepository.basketFor(customerId).get(), is(basket));
    }
}
