package pageObject.shopAmazon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObject.hook.Driver;
import pageObject.pages.CartPage;
import pageObject.pages.HomePage;
import pageObject.pages.Product;
import pageObject.pages.Products;

import java.util.concurrent.TimeUnit;

public class TotalPriceTest{
    WebDriver driver = Driver.getDriver();

    private String totalPrice;
    private int totalPriceInteger;
    private boolean unfound;

    @Test
    public void amountValidation(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Products products = PageFactory.initElements(driver, Products.class);
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        Product product = PageFactory.initElements(driver, Product.class);
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        homePage.searchProduct("Refrigerador");
        unfound = products.findFirstProduct("samsung");
        if(!unfound){
            product.addToCart();
            driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
            driver.navigate().back();
            driver.navigate().back();
            driver.navigate().forward();
        }
        unfound = products.findFirstProduct("mabe");
        if(!unfound){
            product.addToCart();
            driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        }
        totalPrice = cartPage.getTotalPrice();
        totalPriceInteger = Integer.parseInt(totalPrice);
        if(totalPriceInteger > 10000){
            System.out.println("The price is greater than 10,000!");
        }else{
            System.out.println("The price is less than 10,000!");
        }
    }

    @AfterTest
    public void close(){
        driver.close();
        driver.quit();
    }
}
