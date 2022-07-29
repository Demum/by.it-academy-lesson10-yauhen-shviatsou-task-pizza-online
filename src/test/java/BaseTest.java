import by.express_pizza.ExpressPizzaBy;
import by.express_pizza.ExpressPizzaDrinks;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    ExpressPizzaBy expressPizzaBy;
    ExpressPizzaDrinks expressPizzaDrinks;
    double totalPrice;
    private By locator;
    private String stringPrice;

    @Before
    public void openConnection() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeConnection() {
        driver.quit();
    }

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Элемент: " + locator + "На странице не найден");
            return false;
        }
    }
    public void orderPizzaAndDrink() throws InterruptedException {
        //PIZZA
        expressPizzaBy = new ExpressPizzaBy(driver);
        expressPizzaBy.driver.get(expressPizzaBy.EXPRESS_PIZZA_BY);
        expressPizzaBy.addPizzaToCard();
        stringPrice = expressPizzaBy.getPriceOfPizza();
        totalPrice += stringPriceToDouble(stringPrice);
        //BEVERAGES
        expressPizzaDrinks = new ExpressPizzaDrinks(driver);
        expressPizzaDrinks.addDrinkTooCard();
        stringPrice = expressPizzaDrinks.getPriceOfDrink();
        totalPrice += stringPriceToDouble(stringPrice);
        totalPrice = Math.round(totalPrice * 100.0) / 100.0;
        Thread.sleep(500);
        expressPizzaDrinks.clickButtonCheckout();
    }
    public Double getTotalPrice() {
        return totalPrice;
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
}
