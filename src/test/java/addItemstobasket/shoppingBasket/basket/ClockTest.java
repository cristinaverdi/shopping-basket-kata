package addItemstobasket.shoppingBasket.basket;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ClockTest {
    @Test public void
    format_todays_date_in_DD_MM_YY_format() {
        Clock clock = new TestableClock();
        String date = clock.todayAsString();
        assertThat(date, is("22/12/1989"));
    }

    private class TestableClock extends Clock {
        protected LocalDate today() {
            return LocalDate.of(1989, 12, 22);
        }
    }
}