package addItemstobasket.shoppingBasket.basket;

import addItemstobasket.shoppingBasket.Product.Price;
import addItemstobasket.shoppingBasket.Product.Product;
import addItemstobasket.shoppingBasket.Product.Title;
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
    private List<Product> content;
    private CustomerId customerId;

    @Before public void
    set_up() {
        customerId = new CustomerId(1234);
        basket = new Basket(customerId);
        content = new ArrayList<Product>();
    }

    @Test public void
    create_one_empty_basket_per_client() {
        basket.create(customerId);
        assertThat(basket.content(), is(content));
    }

    @Test public void
    add_item_into_shopping_basket() {
        Product product = new Product(new ProductId(10002), new Title("El Hobbit"), new Price(7));
        basket.addItem(product, 1);
        content.add(product);

        assertThat(basket.content(), is(content));
    }
}
