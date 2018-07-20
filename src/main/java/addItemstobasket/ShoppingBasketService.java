package addItemstobasket;

import addItemstobasket.shoppingBasket.basket.Clock;
import addItemstobasket.shoppingBasket.basket.Basket;
import addItemstobasket.shoppingBasket.basket.Baskets;
import addItemstobasket.shoppingBasket.product.Product;
import addItemstobasket.shoppingBasket.product.ProductId;
import addItemstobasket.shoppingBasket.product.Warehouse;
import addItemstobasket.shoppingBasket.customer.CustomerId;
import addItemstobasket.shoppingBasket.basketContent.ContentFormatter;

import java.util.Optional;

public class ShoppingBasketService {
    private Clock clock;
    private Basket basket;
    private Warehouse warehouse;
    private Baskets basketRepository;
    private ContentFormatter contentFormatter;

    public ShoppingBasketService(Baskets basketRepository, ContentFormatter contentFormatter, Warehouse warehouse, Clock clock) {
        this.clock = clock;
        this.warehouse = warehouse;
        this.basketRepository = basketRepository;
        this.contentFormatter = contentFormatter;
    }

    public void addItems(CustomerId customerId, ProductId productId, int quantity) throws NotAvailableProductException {
        if(!warehouse.isProductAvailable(productId)) {
            throw new NotAvailableProductException();
        }

        getBasket(customerId);
        addItem(productId, quantity);
    }

    public String checkBasketContent() {
        return formatBasketContent();
    }

    private void getBasket(CustomerId customerId) {
        GetBasketService getBasket = new GetBasketService(customerId, basketRepository, clock);
        getBasket.execute();
        basket = getBasket.basket();
    }

    private void addItem(ProductId productId, int quantity) {
        Product product = warehouse.findProductById(productId).get();
        basket.addItem(product, quantity);
    }

    private String formatBasketContent() {
        return contentFormatter.format(basket);
    }
}
