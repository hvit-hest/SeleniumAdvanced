package org.courses.tests;

import org.courses.pages.AdminPage;
import org.courses.utils.WebDriverSelection;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class OpenBrowsersTest {

    private WebDriver myPersonalDriver;

    @BeforeTest
    public void beforeTest() {
        myPersonalDriver = new WebDriverSelection().getDriverFromProperties();

    }

    @Test
    public void openBrowsersTest() {
        myPersonalDriver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        //Open page
        AdminPage adminPage = new AdminPage(myPersonalDriver);
        adminPage.open();
        //Check title (Also it is possible to look for some elements on the page)
        Assert.assertTrue(adminPage.isLoginFormOpen() || adminPage.isAdminPageOpen(),
                "the test does not pass");

    }

    @AfterTest
    public void afterTest() {
        //Quit driver
        myPersonalDriver.quit();
    }
}
