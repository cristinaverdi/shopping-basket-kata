package shoppingcart;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddItemsToShoppingCartFeature {

    private Basket basket;
    private Customer cristina;
    private ShoppingBasketService shoppingBasketService;
    private CustomerId customerId;
    private ProductId productId;
    private BasketRepository basketRepository;

    @Before public void
    set_up() {
        customerId = new CustomerId(1234);
        productId = new ProductId(10002);

        cristina = new Customer(customerId);
        basket = new Basket(customerId);

        basketRepository = new BasketRepository();

        shoppingBasketService = new ShoppingBasketService(basket, basketRepository);
    }

    @Test public void
    check_basket_content() {
        shoppingBasketService.addItems(customerId, productId, 2);

        String basketContent =
                "Creation date: 22/12/89 \n" +
                        "2 x The Hobbit \n" +
                        "2 x Breaking Bad \n" +
                        "Total: 45.00€ \n";

        assertThat(shoppingBasketService.basketFor(customerId).format(), is(basketContent));
    }
}
