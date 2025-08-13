package com.amazon.test.TestCases;

import com.amazon.test.Page.AddToCart;
import com.amazon.test.Page.HomePage;
import com.amazon.test.Page.LoginPage;
import com.amazon.test.Page.Search;
import com.amazon.test.base.BaseClass;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class AddToCartTest  extends BaseClass {
    HomePage homePage;
    AddToCart addToCart;
    Search search;

    @BeforeMethod
    public void setUp(){
        Config();
        BrowserLaunch();
        homePage = new HomePage();
    }

    @AfterMethod
    public  void setDown(){
        webDriver.quit();
    }



    @Test
    public  void AddCartButton(){
        addToCart = new AddToCart();
        boolean isAdded = addToCart.AddToCartDisplayed();
        Assert.assertTrue(isAdded);
    }

    @Test
    public void goToCart(){
        addToCart = new AddToCart();
        addToCart.goToCart();
        Assert.assertTrue(webDriver.getCurrentUrl().contains("nav_cart"),"err");
    }


}
