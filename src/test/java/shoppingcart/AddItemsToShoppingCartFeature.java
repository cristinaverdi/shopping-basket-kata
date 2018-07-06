package shoppingcart;

import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddItemsToShoppingCartFeature {

    private Basket basket;
    private Customer cristina;

    @Before public void
    set_up() {
        int customerId = 1234;
        cristina = new Customer(customerId);

        basket = new Basket(customerId);
    }

    @Test public void
    check_basket_content() {

        cristina.addItemToBasket(2, "The Hobbit");
        cristina.addItemToBasket(5, "Breaking Bad");

        verify(basket).add(2, "The Hobbit");
        verify(basket).add(5, "Breaking Bad");

        String basketContent =
                "Creation date: 22/12/89 \n" +
                        "2 x The Hobbit \n" +
                        "2 x Breaking Bad \n" +
                        "Total: 45.00€ \n";
        assertThat(cristina.checkBasketContent(), is(basketContent));
    }
}
