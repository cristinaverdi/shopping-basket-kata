package shoppingcart;


public class ShoppingBasketService {

    private Basket basket;
    private BasketRepository basketRepository;

    public ShoppingBasketService(Basket basket, BasketRepository basketRepository) {
        this.basket = basket;
        this.basketRepository = basketRepository;
    }

    public void addItems(CustomerId customerId, ProductId productId, int quantity) {
        if(basketFor(customerId) == null) {
            basket.create();
        }

        basket.addItem(productId, quantity);
    }

    public Basket basketFor(CustomerId customerId) {
        return basketRepository.basketFor(customerId);
    }
}
