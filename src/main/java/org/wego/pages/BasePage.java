package org.wego.pages;

import org.wego.driver.DriverProvider;
import org.wego.utility.ApplicationConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(DriverProvider.getDriver(), this);
    }

    public static void do_click(WebElement element){
        WebDriver driver = DriverProvider.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ApplicationConfig.getDefaultExplicitWait()));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public static SearchContext getShadowDomInsideShadowDom(SearchContext outerShadowRoot, By innerShadowHost){
        WebDriver driver = DriverProvider.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ApplicationConfig.getDefaultExplicitWait()));wait.until(ExpectedConditions.visibilityOf(outerShadowRoot.findElement(innerShadowHost)));
        return outerShadowRoot.findElement(innerShadowHost).getShadowRoot();
    }

    public static SearchContext getShadowRootForMainShadowDom(WebElement shadowHost){
        WebDriver driver = DriverProvider.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ApplicationConfig.getDefaultExplicitWait()));
         wait.until(ExpectedConditions.visibilityOf(shadowHost));
        return shadowHost.getShadowRoot();
    }
    public static void selectElementInsideShadowDom(SearchContext shadowRoot, By element){
        WebDriver driver = DriverProvider.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ApplicationConfig.getDefaultExplicitWait()));
        wait.until(ExpectedConditions.visibilityOf(shadowRoot.findElement(element))).click();

    }

    public static void sendKeysElementInsideShadowDom(SearchContext shadowRoot, By element,String message){
        WebDriver driver = DriverProvider.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ApplicationConfig.getDefaultExplicitWait()));
        wait.until(ExpectedConditions.visibilityOf(shadowRoot.findElement(element))).clear();
        shadowRoot.findElement(element).sendKeys(message);
        shadowRoot.findElement(element).sendKeys(Keys.ENTER);
    }
}
