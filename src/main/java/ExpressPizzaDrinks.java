import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExpressPizzaDrinks {
    //Drinks
    public final By BUTTON_BEVERAGES_SECTION = By.xpath("//a[@href='/napitki']");
    public final By BUTTON_DRINK_GOOD_PALPI_ADD_CART = By.xpath("//div[@class='rows-group Dobryy-Palpi-0,45-l group-1286']//button[@value='Заказать']");
    public final By BUTTON_CHECKOUT = By.xpath("//a[contains(text(), 'Оформить заказ')]");
    public final By PRICE_OFF_DOBRYY_PALPI = By.xpath("//div[@class='rows-group Dobryy-Palpi-0,45-l group-1286']//span[@class='price']");
    protected WebDriver driver;

    public ExpressPizzaDrinks(WebDriver driver) {
        this.driver = driver;
    }
}