package org.wego.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightSearchHomePage extends BasePage {
    @FindBy(css = "#app")
    private WebElement shadowHostMainPage;
    By shadowHostFlightPage = new By.ByCssSelector("wego-search-form[app-name='flights']");
    By shadowHostFlightSearchContainer = new By.ByCssSelector("wego-flight-search-form[page='home']");
    By shadowHostFlightSearchForm = new By.ByCssSelector("wego-flight-search-form-home[page='home']");
    By oneWayButton = new By.ByCssSelector("button[data-category='oneWay']");
    By roundTripButton = new By.ByCssSelector("button[data-category='return']");
    By multiCityButton = new By.ByCssSelector("button[data-category='multicity']");
    By shadowHostFlightLocationPicker = new By.ByCssSelector("wego-location-picker[app-type='flights']");
    By shadowHostFromLocation = new By.ByCssSelector("single-location-picker:nth-child(2)");
    By shadowHostToLocation = new By.ByCssSelector("single-location-picker:nth-child(3)");
    By shadowHostLocationSelector = new By.ByCssSelector("#locationSelector");
    By shadowHostLocationOverlay = new By.ByCssSelector("#locationOverlay");
    By shadowHostLocationInputField = new By.ByCssSelector("wego-selector");
    By inputFromAirport = new By.ByCssSelector("input[placeholder='From']");
    By inputToAirport = new By.ByCssSelector("input[placeholder='to']");

    By shadowHostDatePicker = new By.ByCssSelector("wego-date-picker[app-type='flights']");
    By shadowHostDateSelector = new By.ByCssSelector("wego-date-selectors");
    By shadowHostDepartDate = new By.ByCssSelector("wego-date-selector:nth-child(2)");
    By shadowHostReturnDate = new By.ByCssSelector("wego-date-selector:nth-child(3)");
    By inputDepartDate = new By.ByCssSelector("input[placeholder='Depart']");
    By inputReturnDate = new By.ByCssSelector("input[placeholder='Return']");

    By calenderOverlay = new By.ByCssSelector("calendar-overlay");

    private SearchContext flightForm() {
		// Return FlightContainerShadowRoot
        SearchContext mainShadowRoot = getShadowRootForMainShadowDom(shadowHostMainPage);
        SearchContext shadowRootFlightPage = getShadowDomInsideShadowDom(mainShadowRoot, shadowHostFlightPage);
        SearchContext shadowRootFlightSearchContainer = getShadowDomInsideShadowDom(shadowRootFlightPage, shadowHostFlightSearchContainer);
		return getShadowDomInsideShadowDom(shadowRootFlightSearchContainer, shadowHostFlightSearchForm);
    }

	private SearchContext flightLocationForm(String location){
       //Return the form which contain To and From
        SearchContext shadowRootFlightLocationPicker = getShadowDomInsideShadowDom(flightForm(),shadowHostFlightLocationPicker);
        SearchContext flightLocationRoot = null;
        if(location.equalsIgnoreCase("to")){
            flightLocationRoot =  getShadowDomInsideShadowDom(shadowRootFlightLocationPicker,shadowHostToLocation);
        }else if(location.equalsIgnoreCase("from")){
            flightLocationRoot =  getShadowDomInsideShadowDom(shadowRootFlightLocationPicker,shadowHostFromLocation);
        }
        assert flightLocationRoot != null;
        selectElementInsideShadowDom(flightLocationRoot,shadowHostLocationSelector);
        SearchContext locationOverlay = getShadowDomInsideShadowDom(flightLocationRoot,shadowHostLocationOverlay);
        return  getShadowDomInsideShadowDom(locationOverlay,shadowHostLocationInputField);
	}

    private SearchContext flightDateForm(String date){
        //Return the form which contain To and From
        SearchContext shadowRootDatePicker= getShadowDomInsideShadowDom(flightForm(),shadowHostDatePicker);
        SearchContext shadowRootDateSelector = getShadowDomInsideShadowDom(shadowRootDatePicker,shadowHostDateSelector);
        SearchContext flightDateRoot = null;
        if(date.equalsIgnoreCase("depart")){
            flightDateRoot =  getShadowDomInsideShadowDom(shadowRootDateSelector,shadowHostDepartDate);
            selectElementInsideShadowDom(flightDateRoot,inputDepartDate);
        }else if(date.equalsIgnoreCase("return")){
            flightDateRoot =  getShadowDomInsideShadowDom(shadowRootDateSelector,shadowHostReturnDate);
            selectElementInsideShadowDom(flightDateRoot,inputReturnDate);
        }
        assert flightDateRoot  != null;
        SearchContext dateOverlay = getShadowDomInsideShadowDom(shadowRootDatePicker,calenderOverlay);
        return  dateOverlay;
    }

    public void selectOneway() {
        selectElementInsideShadowDom(flightForm(), oneWayButton);
    }

    public void enterFromAirport(String airport){
        SearchContext flightFromRoot = flightLocationForm("From");
        sendKeysElementInsideShadowDom(flightFromRoot,inputFromAirport,airport);
    }

    public void enterToAirport(String airport){
        SearchContext flightFromRoot = flightLocationForm("To");
        sendKeysElementInsideShadowDom(flightFromRoot,inputToAirport,airport);
    }

    public void selectDepartDate(String date){
        SearchContext departDateOverlay = flightDateForm("Depart");

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
