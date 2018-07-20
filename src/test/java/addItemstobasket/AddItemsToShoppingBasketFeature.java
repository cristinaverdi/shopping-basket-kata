package addItemstobasket;

import addItemstobasket.shoppingBasket.product.NotAvailableProductException;
import addItemstobasket.shoppingBasket.basket.Clock;
import org.junit.Test;
import org.junit.Before;

import addItemstobasket.infrastructure.BasketRepository;
import addItemstobasket.infrastructure.ProductRepository;

import addItemstobasket.shoppingBasket.product.ProductId;
import addItemstobasket.shoppingBasket.customer.CustomerId;
import addItemstobasket.shoppingBasket.basketContent.ContentFormatter;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddItemsToShoppingBasketFeature {
    private ProductId productId;
    private CustomerId customerId;
    private ShoppingBasketService shoppingBasketService;

    @Before public void
    set_up() throws NotAvailableProductException {
        productId = new ProductId(10002);

        customerId = new CustomerId(1234);
        Clock clock = new TestableClock();

        ProductRepository warehouse = new ProductRepository();
        BasketRepository basketRepository = new BasketRepository();
        ContentFormatter contentFormatter = new ContentFormatter();

        shoppingBasketService = new ShoppingBasketService(basketRepository, contentFormatter, warehouse, clock);
        shoppingBasketService.addItems(customerId, new ProductId(20010), 2);
        shoppingBasketService.addItems(customerId, productId, 2);
    }

    @Test public void
    check_basket_content() throws NotAvailableProductException {
        String basketContent =
            "Creation date: 22/12/1989\n" +
            "2 x Breaking Bad\n" +
            "2 x The Hobbit\n" +
            "Total: 24.00€\n";

        assertThat(shoppingBasketService.checkBasketContent(), is(basketContent));
    }

    private class TestableClock extends Clock {
        protected LocalDate today() {
            return LocalDate.of(1989, 12, 22);
        }
    }
}
