package pageObject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    @FindBy(how = How.XPATH, using = "//*[@class='nav-input nav-progressive-attribute']")
    WebElement searchBar;

    @FindBy(how = How.XPATH, using = "//*[contains(@title,'Search For')]")
    WebElement searchBarSecondWay;

    public void searchProduct(String product){
        if(searchBar.isDisplayed()){
            searchBar.sendKeys(product);
            searchBar.sendKeys(Keys.ENTER);
        }else{
            searchBarSecondWay.sendKeys(product);
            searchBarSecondWay.sendKeys(Keys.ENTER);
        }

    }
}
