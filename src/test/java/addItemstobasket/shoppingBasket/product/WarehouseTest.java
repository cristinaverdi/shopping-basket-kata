package addItemstobasket.shoppingBasket.product;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import addItemstobasket.infrastructure.ProductRepository;

public class WarehouseTest {
    private Warehouse warehouse;
    private ProductId productId;

    @Before public void
    set_up() {
        warehouse = new ProductRepository();
        productId = new ProductId(10001);
    }

    @Test public void
    check_if_product_is_available() {

        assertThat(
                warehouse.isProductAvailable(productId),
                is(true)
        );

        assertThat(
                warehouse.isProductAvailable(new ProductId(101)),
                is(false)
        );
    }

    @Test public void
    find_a_product_by_id() {
        assertThat(warehouse.findProductById(productId).get(), is(new Product(new ProductId(10001), new Title("Lord of the Rings"), new Price(10))));
    }
}
