package org.wego.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightSearchResultPage extends BasePage{

    @FindBy(css = "#app")
    private WebElement shadowHostMainPage;
    By shadowHostFlightPage = new By.ByCssSelector("wego-search-form[app-name='flights']");
    By shadowHostFlightSearchContainer = new By.ByCssSelector("wego-flight-search-form[page='flights-search']");
    By shadowHostFlightSearchForm = new By.ByCssSelector("wego-flight-search-form-results[page='flights-search']");
    By shadowHostFlightLocationPicker = new By.ByCssSelector("wego-location-picker[app-type='flights']");
    By shadowHostFromLocation = new By.ByCssSelector("single-location-picker:nth-child(2)");
    By shadowHostToLocation = new By.ByCssSelector("single-location-picker:nth-child(3)");
    By shadowHostLocationSelector = new By.ByCssSelector("#locationSelector");

    By shadowHostLocationOverlay = new By.ByCssSelector("#locationOverlay");
    By shadowHostLocationInputField = new By.ByCssSelector("wego-selector");

    By inputFromAirport = new By.ByCssSelector("input[placeholder='From']");
    By inputToAirport = new By.ByCssSelector("input[placeholder='to']");

    private SearchContext getFlightSearchForm() {
        // Return FlightContainerShadowRoot
        SearchContext mainShadowRoot = getShadowRootForMainShadowDom(shadowHostMainPage);
        SearchContext shadowRootFlightPage = getShadowDomInsideShadowDom(mainShadowRoot, shadowHostFlightPage);
        SearchContext shadowRootFlightSearchContainer = getShadowDomInsideShadowDom(shadowRootFlightPage, shadowHostFlightSearchContainer);
        return getShadowDomInsideShadowDom(shadowRootFlightSearchContainer, shadowHostFlightSearchForm);
    }

    private SearchContext getFlightLocation(String location){
        //Return the form which contain To and From
        SearchContext shadowRootFlightLocationPicker = getShadowDomInsideShadowDom(getFlightSearchForm(),shadowHostFlightLocationPicker);
        SearchContext flightLocationRoot = null;
        if(location.equalsIgnoreCase("to")){
            flightLocationRoot =  getShadowDomInsideShadowDom(shadowRootFlightLocationPicker,shadowHostToLocation);
        }else if(location.equalsIgnoreCase("from")){
            flightLocationRoot =  getShadowDomInsideShadowDom(shadowRootFlightLocationPicker,shadowHostFromLocation);
        }
        assert flightLocationRoot != null;
        return getShadowDomInsideShadowDom(flightLocationRoot,shadowHostLocationSelector);

    }

    public String getFromAirport(){
        SearchContext locationShadowDom = getFlightLocation("from");
       return getAttributeFromElementInsideShadowDom(locationShadowDom, inputFromAirport, "value");
    }

    public String getToAirport(){
        SearchContext locationShadowDom = getFlightLocation("to");
        return getAttributeFromElementInsideShadowDom(locationShadowDom,inputFromAirport,"value");
    }
}
