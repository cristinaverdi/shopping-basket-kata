package addItemstobasket;

import org.junit.Test;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;

import addItemstobasket.shoppingBasket.product.*;
import addItemstobasket.shoppingBasket.basket.Clock;
import addItemstobasket.shoppingBasket.basket.Baskets;
import addItemstobasket.infrastructure.ProductRepository;
import addItemstobasket.shoppingBasket.customer.CustomerId;
import addItemstobasket.shoppingBasket.basketContent.ContentFormatter;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingBasketServiceTest {
    private Clock clock;
    private ProductId productId;
    private CustomerId customerId;
    private ShoppingBasketService addItemsIntoBasketService;

    private Warehouse warehouse;
    @Mock private Baskets basketRepository;
    @Mock private ContentFormatter contentFormatter;

    @Before public void
    set_up() {
        clock = new TestableClock();
        productId = new ProductId(10002);
        customerId = new CustomerId(1234);
        warehouse = new ProductRepository();
        addItemsIntoBasketService = new ShoppingBasketService(basketRepository, contentFormatter, warehouse, clock);
    }

    @Test public void
    addItemsToBasket() throws NotAvailableProductException {
        addItemsIntoBasketService.addItems(customerId, productId, 1);
        given(addItemsIntoBasketService.checkBasketContent()).willReturn(
                "Creation date: 22/12/89 \n" +
                        "1 x The Hobbit \n" +
                        "Total: 45.00€ \n"
        );

        String basketContent =
                "Creation date: 22/12/89 \n" +
                        "1 x The Hobbit \n" +
                        "Total: 45.00€ \n";

        assertThat(addItemsIntoBasketService.checkBasketContent(), is(basketContent));
    }

    private class TestableClock extends Clock {
        protected LocalDate today() {
            return LocalDate.of(1989, 12, 22);
        }
    }
}
