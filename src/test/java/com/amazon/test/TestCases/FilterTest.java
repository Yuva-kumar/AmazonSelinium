package com.amazon.test.TestCases;

import com.amazon.test.Page.Filter;
import com.amazon.test.Page.HomePage;
import com.amazon.test.Page.Search;
import com.amazon.test.base.BaseClass;
import com.amazon.test.utility.ExtentManager;
import junit.framework.TestListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.http.WebSocket;


public class FilterTest extends BaseClass {
    HomePage homePage;
    Search search;
    Filter filter;

    @BeforeMethod
    public void setUp(){
        Config();
        BrowserLaunch();
        homePage = new HomePage();
        search = new Search();
        filter = new Filter();
    }

    @AfterMethod
    public void setDown(){
        webDriver.quit();
    }

    @Test
    public void samsungFilter(){
        homePage.searchBar("smartphones");
        filter.brandFilter("samsung");
        Assert.assertTrue(search.productDisplayed("samsung"));
    }

    @Test
    public void appleFilter(){
        homePage.searchBar("smartphones");
        filter.brandFilter("apple");
        Assert.assertTrue(search.productDisplayed("apple"));
    }

    @Test
    public void priceBar(){
        homePage.searchBar("smartwatch");
        filter.priceFilter("100","3000");
        Assert.assertTrue(search.productDisplayed("smartwatch"));
    }

    @Test
    public void rating(){
        homePage.searchBar("phones");
        filter.applyRatingFilter();
        Assert.assertTrue(search.productDisplayed("phones"));


    }


}
