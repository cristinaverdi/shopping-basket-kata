package addItemstobasket.shoppingBasket.basketContent;

import addItemstobasket.shoppingBasket.basket.Basket;
import addItemstobasket.shoppingBasket.Product.Product;

import java.util.*;

public class ContentFormatter {
    private Basket basket;
    private static final String TIMES = " x ";
    private static final String STRING = "\n";
    private static final String CURRENCY = "€";
    private static final String DECIMALS = ".00";
    private static final String TOTAL = "Total: ";
    private static final String CREATION_DATE = "Creation date: ";

    public ContentFormatter(Basket basket) {
        this.basket = basket;
    }

    public String format() {
        return  formatCreationDate(basket.creationDateAsString()) +
                formatProducts(basket.products()) +
                formatTotalPrice(basket.products());
    }

    String formatCreationDate(String creationDate) {
        return CREATION_DATE + creationDate + STRING;
    }

    String formatProducts(List<Product> content) {
        Map<String, Long> countByTitle = countByTitle(content);

        return formatCountByTitle(countByTitle);
    }

    String formatTotalPrice(List<Product> content) {
        return TOTAL + totalPrice(content) + DECIMALS + CURRENCY + STRING;
    }

    private String formatCountByTitle(Map<String, Long> totalProductsByTitle) {
        String formattedProducts = "";
        for(String title : totalProductsByTitle.keySet()) {
            formattedProducts += totalProductsByTitle.get(title) + TIMES + title + STRING;
        }

        return formattedProducts;
    }

    private Map<String, Long> countByTitle(List<Product> content) {
        Map<String, Long> totalProductsByTitle = new HashMap<>();
        for (Product product : content) {
            totalProductsByTitle.merge(product.getTitle(), 1L, Long::sum);
        }

        return totalProductsByTitle;
    }

    private int totalPrice(List<Product> content) {
        int totalPrice = 0;

        for (Product product : content) {
                totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
