package by.express_pizza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExpressPizzaByCheckout {
    //checkout
    public final By CHECKOUT_FOUR_SEAZON_PIZZA = By.xpath("//td[@class='desc']/a[@href='/picca-chetyre-sezona30']");
    public final By CHECKOUT_DRINK_GOOD_PALPI = By.xpath("//td[@class='desc']/a[@href='/napitki-dobryy-palpi']");
    public final By SUBTOTAL_PRICE = By.xpath("//td[@class='subtotal']//span[@class='uc-price']");
    protected WebDriver driver;

    public ExpressPizzaByCheckout(WebDriver driver) {
        this.driver = driver;
    }


}