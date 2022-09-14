package org.wego.testcases;

import org.wego.driver.DriverProvider;
import org.wego.utility.ApplicationConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

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
