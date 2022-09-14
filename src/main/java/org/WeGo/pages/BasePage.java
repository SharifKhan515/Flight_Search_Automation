package org.WeGo.pages;

import org.WeGo.driver.DriverProvider;
import org.WeGo.utility.ApplicationConfig;
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

   /* public static SearchContext getElementFromShadowDom(WebElement shadowHost, WebElement element){
        WebDriver driver = DriverProvider.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ApplicationConfig.getDefaultExplicitWait()));
        WebElement shadowHostElement = wait.until(ExpectedConditions.visibilityOf(shadowHost));

        //WebElement shadowHostElement = driver.findElement(shadowHost);
        SearchContext shadowRoot = shadowHostElement.getShadowRoot();
        WebElement shadowContent = wait.until(ExpectedConditions.visibilityOf(element));
        return shadowContent;
    }*/

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

}
