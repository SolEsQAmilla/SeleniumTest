package pageObject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.concurrent.TimeUnit;

import static pageObject.hook.Driver.driver;

public class Product {

    @FindBy(how = How.ID, using = "add-to-cart-button")
    WebElement addToCartButton;

    @FindBy(how = How.ID, using = "attachSiNoCoverage")
    WebElement dontAddProtection;

    public void addToCart(){
        addToCartButton.click();
        dontAddProtection.click();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }
}
