import by.express_pizza.ExpressPizzaByCheckout;
import org.junit.Assert;
import org.junit.Test;
public class ExpressPizzaByTest extends BaseTest {
    ExpressPizzaByCheckout expressPizzaByCheckout;
    double factprice;
    String stringPrice;
    @Test
    public void expressPizzaBytest() throws InterruptedException {
        orderPizzaAndDrink();
        expressPizzaByCheckout = new ExpressPizzaByCheckout(driver);
        Assert.assertTrue(isDisplayed(expressPizzaByCheckout.CHECKOUT_FOUR_SEAZON_PIZZA));
        Assert.assertTrue(isDisplayed(expressPizzaByCheckout.CHECKOUT_DRINK_GOOD_PALPI));
        Assert.assertTrue(isDisplayed(expressPizzaByCheckout.SUBTOTAL_PRICE));
        stringPrice = getTextByLocator(expressPizzaByCheckout.SUBTOTAL_PRICE);
        factprice = stringPriceToDouble(stringPrice);
        Assert.assertEquals(getTotalPrice(), factprice, 0);
    }
}