import org.junit.Assert;
import org.junit.Test;

public class ExpressPizzaByTest extends WebDriverSettings {
    ExpressPizzaBy expressPizzaBy;
    @Test
    public void expressPizzaBytest() throws InterruptedException {
        expressPizzaBy = new ExpressPizzaBy(driver);
        expressPizzaBy.driver.get(expressPizzaBy.EXPRESS_PIZZA_BY);
        driver.findElement(expressPizzaBy.BUTTON_PIZZA_SECTION).click();
        driver.findElement(expressPizzaBy.BUTTON_FOUR_SEAZON_PIZZA_ADD_CART).click();
        driver.findElement(expressPizzaBy.BUTTON_BEVERAGES_SECTION).click();
        driver.findElement(expressPizzaBy.BUTTON_DRINK_GOOD_PALPI_ADD_CART).click();
        Thread.sleep(500);
        driver.findElement(expressPizzaBy.BUTTON_CHECKOUT).click();
        Assert.assertTrue(expressPizzaBy.isDisplayed(expressPizzaBy.CHECKOUT_FOUR_SEAZON_PIZZA));
        Assert.assertTrue(expressPizzaBy.isDisplayed(expressPizzaBy.CHECKOUT_DRINK_GOOD_PALPI));
        Thread.sleep(2000);
    }

}
