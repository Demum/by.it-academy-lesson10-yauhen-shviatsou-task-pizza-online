import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ExpressPizzaBy {
    protected WebDriver driver;
    public  final  String EXPRESS_PIZZA_BY = "https://express-pizza.by/";
    public  final By BUTTON_PIZZA_SECTION = By.xpath("//a[@href='/picca']");
    public  final By BUTTON_FOUR_SEAZON_PIZZA_ADD_CART =  By.xpath("//div[@class='rows-group Chetyre-sezona group-1274']/div[@class='views-row views-row-2 views-row-even']//button[@class='node-add-to-cart ajax-cart-submit-form-button btn btn-default form-submit ajax-cart-processed']");
    public  final By BUTTON_BEVERAGES_SECTION =  By.xpath("//a[@href='/napitki']");
    public  final By BUTTON_DRINK_GOOD_PALPI_ADD_CART =  By.xpath("//div[@class='rows-group Dobryy-Palpi-0,45-l group-1286']//button[@value='Заказать']");
    public  final By BUTTON_CHECKOUT =  By.xpath("//a[contains(text(), 'Оформить заказ')]");
    public  final By CHECKOUT_FOUR_SEAZON_PIZZA =  By.xpath("//td[@class='desc']/a[@href='/picca-chetyre-sezona30']");
    public  final By CHECKOUT_DRINK_GOOD_PALPI =  By.xpath("//td[@class='desc']/a[@href='/picca-chetyre-sezona30']");

    public ExpressPizzaBy(WebDriver driver)   {
        this.driver=driver;
    }

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Элемент: " + locator + "На странице не найден");
            return false;
        }
    }



}


