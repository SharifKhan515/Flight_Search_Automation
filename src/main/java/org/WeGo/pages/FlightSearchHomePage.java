package org.WeGo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightSearchHomePage extends BasePage {
    @FindBy(css = "#app")
    private WebElement shadowHostMainPage;
    By shadowHostFlightPage = new By.ByCssSelector("wego-search-form[app-name='flights']");
    String shadow = "wego-search-form[app-name='flights']";
    By shadowHostFlightSearchContainer = new By.ByCssSelector("wego-flight-search-form[page='home']");
    By shadowHostFlightSearchForm = new By.ByCssSelector("wego-flight-search-form-home[page='home']");

    By oneWayButton = new By.ByCssSelector("button[data-category='oneWay']");

    @FindBy(css = "wego-location-picker[app-type='flights']")
    private WebElement shadowHostFlightLocationPicker;

    @FindBy(css = "single-location-picker:nth-child(2)")
    private WebElement shadowHostFromLocation;

    @FindBy(css = "single-location-picker:nth-child(3)")
    private WebElement shadowHostToLocation;

    @FindBy(css = "#locationSelector")
    private WebElement shadowHostLocationSelector;

    @FindBy(css = "input[placeholder='to']")
    private WebElement input;

    private SearchContext flightForm() {
		// Return FlightContainerShadowRoot
        SearchContext mainShadowRoot = getShadowRootForMainShadowDom(shadowHostMainPage);
        SearchContext shadowRootFlightPage = getShadowDomInsideShadowDom(mainShadowRoot, shadowHostFlightPage);
        SearchContext shadowRootFlightSearchContainer = getShadowDomInsideShadowDom(shadowRootFlightPage, shadowHostFlightSearchContainer);
		return getShadowDomInsideShadowDom(shadowRootFlightSearchContainer, shadowHostFlightSearchForm);
    }

	/*private SearchContext flightSearchForm(){
       //Return the form which contain To and From

	}*/

    public void selectOneway() {
        selectElementInsideShadowDom(flightForm(), oneWayButton);
    }

	/*public void shadowElement(String fromAirport){




	}

	public void insertFromAirport(String fromAirport){


	}*/








	/*String cssSelectorForHost4 = "wego-flight-search-form-home[page='home']";
        Thread.sleep(1000);
	SearchContext shadow0 = driver.findElement(By.cssSelector("#app")).getShadowRoot();
        Thread.sleep(1000);
	SearchContext shadow1 = shadow0.findElement(By.cssSelector("wego-search-form[app-name='flights']")).getShadowRoot();
        Thread.sleep(1000);
	SearchContext shadow2 = shadow1.findElement(By.cssSelector("wego-flight-search-form[page='home']")).getShadowRoot();
        Thread.sleep(1000);
	SearchContext shadow3 = shadow2.findElement(By.cssSelector("wego-flight-search-form-home[page='home']")).getShadowRoot();
        Thread.sleep(1000);
        shadow3.findElement(By.cssSelector("button[data-category='oneWay']")).click();*/


}
