package com.amazon.test.TestCases;

import com.amazon.test.Page.HomePage;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ObjectInputFilter;

import com.amazon.test.base.BaseClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass{

    HomePage homePage;

    @BeforeMethod
    public void setUp(){
        Config();
        BrowserLaunch();
    }

    @AfterMethod
    public void setDown(){
        webDriver.quit();
    }

    @Test
    public  void validateLogo(){
        homePage = new HomePage();
        boolean res = homePage.validateLogo();
        Assert.assertTrue(res);
    }

    @Test
    public void testSearch(){
        homePage = new HomePage();
        homePage.searchBar("laptop");

    }

    // it tests the searched product is search or not
    @Test
    public void testProduct(){
        homePage = new HomePage();
        homePage.searchBar("laptop");
        String currUrl = homePage.getCurrUrl();
        Assert.assertTrue(currUrl.contains("laptop"));
    }

    @Test
    public void testSignInButton(){
        homePage = new HomePage();
        homePage.clickOnSignIn();
        String currUrl = homePage.getCurrUrl();
        Assert.assertTrue(currUrl.contains("signin") || currUrl.contains("account"));
    }



}
