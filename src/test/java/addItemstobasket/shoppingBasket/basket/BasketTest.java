package addItemstobasket.shoppingBasket.basket;

import org.junit.Test;
import org.junit.Before;
import addItemstobasket.shoppingBasket.Product.ProductId;
import addItemstobasket.shoppingBasket.Customer.CustomerId;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class BasketTest {
    private Basket basket;
    private List<ProductId> content;
    private CustomerId customerId;

    @Before public void
    set_up() {
        customerId = new CustomerId(1234);
        basket = new Basket(customerId);
        content = new ArrayList<>();
    }

    @Test public void
    create_one_empty_basket_per_client() {
        basket.create(customerId);
        assertThat(basket.content(), is(content));
    }

    @Test public void
    add_item_into_shopping_basket() {
        ProductId productId = new ProductId(10002);
        basket.addItem(productId, 1);
        content.add(productId);

        assertThat(basket.content(), is(content));
    }
}
