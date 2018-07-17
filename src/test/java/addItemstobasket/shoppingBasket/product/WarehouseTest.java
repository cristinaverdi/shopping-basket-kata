package addItemstobasket.shoppingBasket.product;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import addItemstobasket.shoppingBasket.Product.ProductId;
import addItemstobasket.shoppingBasket.Product.Warehouse;
import addItemstobasket.infrastructure.ProductRepository;

public class WarehouseTest {

    private Warehouse warehouse;

    @Before public void
    set_up() {
        warehouse = new ProductRepository();
    }

    @Test
    public void
    check_if_product_is_available() {
        assertThat(
                warehouse.isProductAvailable(new ProductId(10001)),
                is(true)
        );

        assertThat(
                warehouse.isProductAvailable(new ProductId(101)),
                is(false)
        );
    }

}