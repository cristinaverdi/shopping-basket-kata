package addItemstobasket;

import org.junit.Test;
import org.junit.Before;

import addItemstobasket.infrastructure.BasketRepository;
import addItemstobasket.infrastructure.ProductRepository;

import addItemstobasket.shoppingBasket.basket.Basket;
import addItemstobasket.shoppingBasket.Product.ProductId;
import addItemstobasket.shoppingBasket.Customer.CustomerId;
import addItemstobasket.shoppingBasket.basketContent.ContentFormatter;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddItemsToShoppingBasketFeature {

    private ProductId productId;
    private CustomerId customerId;
    private ShoppingBasketService shoppingBasketService;

    @Before public void
    set_up() {
        productId = new ProductId(10002);

        customerId = new CustomerId(1234);
        Basket basket = new Basket(customerId);

        ContentFormatter contentFormatter = new ContentFormatter(basket);
        BasketRepository basketRepository = new BasketRepository();
        ProductRepository warehouse = new ProductRepository();

        shoppingBasketService = new ShoppingBasketService(basketRepository, contentFormatter, warehouse);
    }

    @Test public void
    check_basket_content() {
        shoppingBasketService.addItems(customerId, productId, 2);
        String basketContent =
            "Creation date: 22/12/89\n" +
            "2 x The Hobbit\n" +
            "2 x Breaking Bad\n" +
            "Total: 45.00€\n";

        assertThat(shoppingBasketService.checkBasketContent(), is(basketContent));
    }
}
