package pageObject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage {
    private String price;

    @FindBy(how = How.XPATH, using = "//*[@class='a-size-base a-color-price a-text-bold']")
    WebElement totalPrice;

    public String getTotalPrice(){
        price = totalPrice.getText().replace("$","");
        price = price.replace(",","");
        price = price.replace(".00","");
        return price;
    }
}
