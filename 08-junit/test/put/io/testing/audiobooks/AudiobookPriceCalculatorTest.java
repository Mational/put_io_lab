package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    private Audiobook audiobook;
    private Customer customer;
    private AudiobookPriceCalculator price;
    @BeforeEach
    void setUp() {
        audiobook = new Audiobook("Harry Potter i kamień fizjologiczny",
                15.53);

        price = new AudiobookPriceCalculator();
    }

    @Test
    void testPath1() {
        customer = new Customer("Grzegorz",
                Customer.LoyaltyLevel.STANDARD, false);
        assertEquals(audiobook.getStartingPrice(), price.calculate(customer, audiobook),
                "Działa");
    }

    @Test
    void testPath2() {
        customer = new Customer("Grzegorz",
                Customer.LoyaltyLevel.STANDARD, true);
        assertEquals(0.0, price.calculate(customer, audiobook),"" +
                "Działa");
    }

    @Test
    void testPath3() {
        customer = new Customer("Grzegorz",
                Customer.LoyaltyLevel.SILVER, false);
        assertEquals(0.9 * audiobook.getStartingPrice(), price.calculate(customer, audiobook),"" +
                "Działa");
    }

    @Test
    void testPath4() {
        customer = new Customer("Grzegorz",
                Customer.LoyaltyLevel.GOLD, false);
        assertEquals(0.8 * audiobook.getStartingPrice(), price.calculate(customer, audiobook),"" +
                "Działa");
    }
}