package org.wego.driver;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class DriverHelper extends DriverProvider{

    public static void moveToChildWindow(){

        WebDriver driver = getDriver();
        String MainWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String ChildWindow : windowHandles) {
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                break;
            }
        }
    }
}
