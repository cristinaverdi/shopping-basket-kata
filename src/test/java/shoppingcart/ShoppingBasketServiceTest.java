package shoppingcart;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingBasketServiceTest {

    private ProductId productId;
    private CustomerId customerId;
    private ShoppingBasketService shoppingBasketService;

    @Mock
    private Basket basket;

    @Mock
    private BasketRepository basketRepository;

    @Before public void
    set_up() {
        shoppingBasketService = new ShoppingBasketService(basket, basketRepository);
        customerId = new CustomerId(1234);
        productId = new ProductId(10002);
    }

    @Test
    public void
    addItemsToBasket() {
        shoppingBasketService.addItems(customerId, productId, 1);

        verify(basketRepository).basketFor(customerId);
        verify(basket).addItem(productId, 1);
    }

    @Test public void
    retrieve_customer_basket() {
        shoppingBasketService.basketFor(customerId);
    }
}
