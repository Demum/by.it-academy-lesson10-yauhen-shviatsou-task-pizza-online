import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExpressPizzaBy {
    public final String EXPRESS_PIZZA_BY = "https://express-pizza.by/";
    public final By BUTTON_PIZZA_SECTION = By.xpath("//a[@href='/picca']");
    public final By BUTTON_FOUR_SEAZON_PIZZA_ADD_CART = By.xpath("//div[@class='rows-group Chetyre-sezona group-1274']/div[@class='views-row views-row-2 views-row-even']//button[@class='node-add-to-cart ajax-cart-submit-form-button btn btn-default form-submit ajax-cart-processed']");
    public final By PRICE_OFF_PIZZA_FOUR_SEASONS = By.xpath("//div[@class='rows-group Chetyre-sezona group-1274']//span[@class='size'][contains(text(), '30 см' )]/following-sibling::*");
    protected WebDriver driver;

    public ExpressPizzaBy(WebDriver driver) {
        this.driver = driver;
    }
}