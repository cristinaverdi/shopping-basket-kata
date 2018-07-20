package addItemstobasket.shoppingBasket.basket;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import org.mockito.junit.MockitoJUnitRunner;

import addItemstobasket.shoppingBasket.product.Title;
import addItemstobasket.shoppingBasket.product.Price;
import addItemstobasket.shoppingBasket.product.Product;
import addItemstobasket.shoppingBasket.product.ProductId;
import addItemstobasket.shoppingBasket.customer.CustomerId;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class BasketTest {
    private Basket basket;
    private List<Product> content;
    private CustomerId customerId;

    private Clock clock;

    @Before public void
    set_up() {
        clock = new TestableClock();
        customerId = new CustomerId(1234);
        basket = new Basket(customerId, clock);
        content = new ArrayList<>();
    }

    @Test public void
    create_one_empty_basket_per_client() {
        basket.create(customerId);
        assertThat(basket.products(), is(content));
    }

    @Test public void
    add_item_into_shopping_basket() {
        Product product = new Product(new ProductId(10002), new Title("El Hobbit"), new Price(7));
        basket.addItem(product, 1);
        content.add(product);

        assertThat(basket.products(), is(content));
    }

    @Test public void
    basket_creation_date_when_new_basket_is_created() {
        assertThat(basket.creationDateAsString(), is("22/12/1989"));
    }

    private class TestableClock extends Clock {
        protected LocalDate today() {
            return LocalDate.of(1989, 12, 22);
        }
    }
}
