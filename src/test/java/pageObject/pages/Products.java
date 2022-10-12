package pageObject.pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageObject.hook.Driver;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Products {
    WebDriver driver = Driver.getDriver();;
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'a-color-base a-text-normal')]")
    List<WebElement> products;

    @FindBy(how = How.ID, using = "add-to-cart-button")
    WebElement addToCartButton;

    public boolean findFirstProduct(String type){
        boolean unfound = false;

        for(WebElement element : products) {
            if(StringUtils.containsIgnoreCase(element.getText(),type)){
                unfound = false;
                element.click();
                driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
                try {
                    addToCartButton.isDisplayed();
                    break;
                } catch(NoSuchElementException e) {
                    unfound = true;
                }

                if(unfound){
                    driver.navigate().back();
                }
            }
        }

        Assert.assertFalse(unfound);

        return unfound;

    }


}
