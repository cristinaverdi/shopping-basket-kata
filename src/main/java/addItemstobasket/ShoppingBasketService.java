package addItemstobasket;

import addItemstobasket.shoppingBasket.basket.Basket;
import addItemstobasket.shoppingBasket.basket.Baskets;
import addItemstobasket.shoppingBasket.product.Product;
import addItemstobasket.shoppingBasket.product.ProductId;
import addItemstobasket.shoppingBasket.product.Warehouse;
import addItemstobasket.shoppingBasket.customer.CustomerId;
import addItemstobasket.shoppingBasket.basketContent.ContentFormatter;

import java.util.Optional;

public class ShoppingBasketService {
    private Basket basket;
    private Warehouse warehouse;
    private Baskets basketRepository;
    private ContentFormatter contentFormatter;

    private Basket createBasket(CustomerId customerId) {
        return new Basket(customerId);
    }

    public ShoppingBasketService(
            Baskets basketRepository,
            ContentFormatter contentFormatter,
            Warehouse warehouse
    ) {
        this.warehouse = warehouse;
        this.basketRepository = basketRepository;
        this.contentFormatter = contentFormatter;
    }

    public void addItems(CustomerId customerId, ProductId productId, int quantity) throws NotAvailableProductException {
        if(!basketFor(customerId).isPresent()) {
            basket = createBasket(customerId);
        }

        if(!warehouse.isProductAvailable(productId)) {
            throw new NotAvailableProductException();
        }

        Product product = warehouse.findProductById(productId).get();
        basket.addItem(product, quantity);
    }

    public String checkBasketContent() {
        return formatBasketContent();
    }

    public Optional<Basket> basketFor(CustomerId customerId) {
        if(basketRepository.basketFor(customerId).isPresent()) {
            return basketRepository.basketFor(customerId);
        }
        return Optional.empty();
    }

    private String formatBasketContent() {
        return contentFormatter.format();
    }
}
