package addItemstobasket.shoppingBasket.basket;

import addItemstobasket.shoppingBasket.customer.CustomerId;

import java.util.Optional;

public class GetBasketService implements GetBasket {
    private CustomerId customerId;
    private Baskets basketRepository;
    private Clock clock;
    private Basket basket;


    public GetBasketService(CustomerId customerId, Baskets basketRepository, Clock clock) {
        this.customerId = customerId;
        this.basketRepository = basketRepository;
        this.clock = clock;
    }

    public void execute() {
        if(!basketFor(customerId).isPresent()) {
            createAndSaveBasketFor(customerId);
        }else {
            retrieveBasketFor(customerId);
        }
    }

    public Basket basket() {
        return this.basket;
    }

    private Optional<Basket> basketFor(CustomerId customerId) {
        if(basketRepository.basketFor(customerId).isPresent()) {
            return basketRepository.basketFor(customerId);
        }
        return Optional.empty();
    }

    private void createAndSaveBasketFor(CustomerId customerId) {
        basket = createBasket(customerId);
        basketRepository.add(basket);
    }

    private void retrieveBasketFor(CustomerId customerId) {
        basket = basketRepository.basketFor(customerId).get();
    }

    private Basket createBasket(CustomerId customerId) {
        return new Basket(customerId, clock);
    }
}
