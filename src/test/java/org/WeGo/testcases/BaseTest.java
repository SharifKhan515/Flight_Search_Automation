package org.WeGo.testcases;

import com.aventstack.extentreports.Status;
import org.WeGo.driver.DriverProvider;
import org.WeGo.utility.ApplicationConfig;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class BaseTest {

    private final String baseUrl = ApplicationConfig.getBaseUrl();
    public WebDriver driver;

    public SoftAssert softVerify;

    @BeforeClass
    public void init() {
        driver = DriverProvider.getDriver();
        driver.get(baseUrl);
    }

  /*  @BeforeMethod
    public void methodInit(Method m) {
        log = LogManager.getLogger(this.getClass().getName() + ":" + m.getName());
    }

    @AfterSuite
    public void exit() {
        DriverProvider.quitDriver();
    }

    public void reportLog(String message) {
        test.log(Status.INFO, message);
        log.info(message);
    }*/
}
