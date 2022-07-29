package by.express_pizza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExpressPizzaDrinks {
    //Drinks
    public final By BUTTON_BEVERAGES_SECTION = By.xpath("//a[@href='/napitki']");
    public final String BUTTON_DRINK_GOOD_PALPI_ADD_CART = "edit-submit-151054";
    public final String BUTTON_CHECKOUT = "Оформить заказ";
    public final By PRICE_OFF_DOBRYY_PALPI = By.xpath("//div[@class='rows-group Dobryy-Palpi-0,45-l group-1286']//span[@class='price']");

    public WebDriver driver;

    public ExpressPizzaDrinks(WebDriver driver) {
        this.driver = driver;
    }

    public void addDrinkTooCard()  {
        driver.findElement(BUTTON_BEVERAGES_SECTION).click();
        driver.findElement(By.id(BUTTON_DRINK_GOOD_PALPI_ADD_CART)).click();
    }

    public String getPriceOfDrink() {
        return driver.findElement(PRICE_OFF_DOBRYY_PALPI).getText();

    }

    public void clickButtonCheckout() {
        driver.findElement(By.linkText(BUTTON_CHECKOUT)).click();
    }
}