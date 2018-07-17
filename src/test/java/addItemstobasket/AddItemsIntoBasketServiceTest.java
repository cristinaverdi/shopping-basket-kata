package addItemstobasket;

import org.junit.Test;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.is;

import addItemstobasket.shoppingBasket.basket.Baskets;
import addItemstobasket.shoppingBasket.Product.Warehouse;
import addItemstobasket.shoppingBasket.Product.ProductId;
import addItemstobasket.shoppingBasket.Customer.CustomerId;
import addItemstobasket.shoppingBasket.basketContent.ContentFormatter;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AddItemsIntoBasketServiceTest {
    private ProductId productId;
    private CustomerId customerId;
    private AddItemsIntoBasketService addItemsIntoBasketService;

    @Mock private
    Warehouse warehouse;
    @Mock private
    Baskets basketRepository;
    @Mock private
    ContentFormatter contentFormatter;

    @Before public void
    set_up() {
        addItemsIntoBasketService = new AddItemsIntoBasketService(basketRepository, contentFormatter, warehouse);
        customerId = new CustomerId(1234);
        productId = new ProductId(10002);
    }

    @Test public void
    addItemsToBasket() {
        addItemsIntoBasketService.addItems(customerId, productId, 1);
        given(addItemsIntoBasketService.checkBasketContent()).willReturn(
                "Creation date: 22/12/89 \n" +
                        "1 x The Hobbit \n" +
                        "Total: 45.00€ \n"
        );

        verify(warehouse).isProductAvailable(productId);
        String basketContent =
                "Creation date: 22/12/89 \n" +
                        "1 x The Hobbit \n" +
                        "Total: 45.00€ \n";

        assertThat(addItemsIntoBasketService.checkBasketContent(), is(basketContent));
    }
}
