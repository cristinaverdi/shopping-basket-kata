package addItemstobasket.shoppingBasket.basket;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {
    public String todayAsString() {
        LocalDate today = today();
        return today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    protected LocalDate today() {
        return LocalDate.now();
    }
}
