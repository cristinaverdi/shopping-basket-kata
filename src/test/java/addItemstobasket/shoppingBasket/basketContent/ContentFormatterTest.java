package addItemstobasket.shoppingBasket.basketContent;

import java.util.List;
import java.util.Arrays;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;

import org.mockito.junit.MockitoJUnitRunner;
import addItemstobasket.shoppingBasket.product.Price;
import addItemstobasket.shoppingBasket.product.Title;
import addItemstobasket.shoppingBasket.basket.Basket;
import addItemstobasket.shoppingBasket.product.Product;
import addItemstobasket.shoppingBasket.product.ProductId;

@RunWith(MockitoJUnitRunner.class)
public class ContentFormatterTest {
    @Mock private Basket basket;
    private List<Product> basketContent;
    private ContentFormatter contentFormatter;

    @Before public void
    set_up() {
        contentFormatter = new ContentFormatter(basket);
        basketContent = Arrays.asList(
                new Product(new ProductId(10002), new Title("The Hobbit"), new Price(5)),
                new Product(new ProductId(10002), new Title("The Hobbit"), new Price(5)),
                new Product(new ProductId(20010), new Title("Breaking Bad"), new Price(7)),
                new Product(new ProductId(20010), new Title("Breaking Bad"), new Price(7))
        );
    }

    @Test public void
    format_products() {
        String formattedProducts =
                        "2 x Breaking Bad\n" +
                        "2 x The Hobbit\n";

        assertThat(contentFormatter.formatProducts(basketContent), is(formattedProducts));
    }

    @Test public void
    format_total_price() {
        String formattedTotalPrice = "Total: 24.00€\n";
        assertThat(contentFormatter.formatTotalPrice(basketContent), is(formattedTotalPrice));
    }

    @Test public void
    format_creation_date() {
        given(basket.creationDateAsString()).willReturn("22/12/1989");
        String formattedCreationDate = "Creation date: 22/12/1989\n";
        assertThat(contentFormatter.formatCreationDate(basket.creationDateAsString()), is(formattedCreationDate));
    }

    @Test public void
    format_basket_content() {
        given(basket.creationDateAsString()).willReturn("22/12/1989");
        given(basket.products()).willReturn(basketContent);

        String formattedBasketContent = "Creation date: 22/12/1989\n" +
                "2 x Breaking Bad\n" +
                "2 x The Hobbit\n" +
                "Total: 24.00€\n";
        assertThat(contentFormatter.format(), is(formattedBasketContent));
    }
}
