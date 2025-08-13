package com.amazon.test.TestCases;

import com.amazon.test.Page.HomePage;
import com.amazon.test.Page.Search;
import com.amazon.test.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ObjectInputFilter;

public class SearchTest extends BaseClass {

    HomePage homePage;
    Search search;

    @BeforeMethod
    public void setUp(){
        Config();
        BrowserLaunch();
        homePage = new HomePage();
    }

    @AfterMethod
    public void setDown(){
        webDriver.quit();
    }

    @Test
    public void validSearch(){
        homePage.searchBar("iphone");
        search = new Search();
        Assert.assertTrue(search.productDisplayed("iphone"));
    }

    @Test
    public void testInvalidProductSearch() {
        homePage.searchBar("adsdhbsfxyzInvalidProduct");
        search = new Search();
        Assert.assertFalse(search.productDisplayed("adsdhbsfxyzInvalidProduct"),
                "Invalid product unexpectedly found in Search Results");
    }



    @Test
    public void emptySearch(){
        homePage.searchBar(" ");
        search = new Search();
        Assert.assertFalse(search.productDisplayed(" "),"invalid product that you r looking for");
    }



}
