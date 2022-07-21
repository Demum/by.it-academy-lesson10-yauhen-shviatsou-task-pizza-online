import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ExpressPizzaByTest extends WebDriverSettings {
    ExpressPizzaBy expressPizzaBy;
    ExpressPizzaDrinks expressPizzaDrinks;
    ExpressPizzaByCheckout expressPizzaByCheckout;
    double totalPrice, factprice;
    String stringPrice;
    By locator;

    @Test
    public void expressPizzaBytest() throws InterruptedException {
        //PIZZA
        expressPizzaBy = new ExpressPizzaBy(driver);
        expressPizzaBy.driver.get(expressPizzaBy.EXPRESS_PIZZA_BY);
        buttonClick(expressPizzaBy.BUTTON_PIZZA_SECTION);
        buttonClick(expressPizzaBy.BUTTON_FOUR_SEAZON_PIZZA_ADD_CART);
        stringPrice = getTextByLocator(expressPizzaBy.PRICE_OFF_PIZZA_FOUR_SEASONS);
        System.out.println("Price of pizza 4 season :" + stringPrice);
        totalPrice += stringPriceToDouble(stringPrice);
        //BEVERAGES
        expressPizzaDrinks = new ExpressPizzaDrinks(driver);
        buttonClick(expressPizzaDrinks.BUTTON_BEVERAGES_SECTION);
        buttonClick(expressPizzaDrinks.BUTTON_DRINK_GOOD_PALPI_ADD_CART);
        stringPrice = getTextByLocator(expressPizzaDrinks.PRICE_OFF_DOBRYY_PALPI);
        System.out.println("Price of dobryy palpi :" + stringPrice);
        totalPrice += stringPriceToDouble(stringPrice);
        totalPrice = Math.round(totalPrice * 100.0) / 100.0;
        System.out.println("Total price: " + totalPrice);
        // new WebDriverWait(driver, 1.0).until(ExpectedConditions.presenceOfAllElementsLocatedBy(expressPizzaBy.BUTTON_CHECKOUT));
        Thread.sleep(1000);
        buttonClick(expressPizzaDrinks.BUTTON_CHECKOUT);
        //CHECKOUT
        expressPizzaByCheckout = new ExpressPizzaByCheckout(driver);
        Assert.assertTrue(isDisplayed(expressPizzaByCheckout.CHECKOUT_FOUR_SEAZON_PIZZA));
        Assert.assertTrue(isDisplayed(expressPizzaByCheckout.CHECKOUT_DRINK_GOOD_PALPI));
        Assert.assertTrue(isDisplayed(expressPizzaByCheckout.SUBTOTAL_PRICE));
        stringPrice = getTextByLocator(expressPizzaByCheckout.SUBTOTAL_PRICE);
        factprice = stringPriceToDouble(stringPrice);
        System.out.println("fact price:" + factprice);
        Assert.assertEquals(totalPrice, factprice, 0);
    }

    public Double stringPriceToDouble(String s) {
        this.stringPrice = s;
        s = s.replaceAll("[р]", "");
        return Double.parseDouble(s);
    }

    public String getTextByLocator(By locator) {
        this.locator = locator;
        return driver.findElement(locator).getText();
    }

    public void buttonClick(By locator) {
        driver.findElement(locator).click();
    }
}