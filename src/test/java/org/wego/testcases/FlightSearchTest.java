package org.wego.testcases;

import org.wego.pages.FlightSearchPage;
import org.testng.annotations.Test;
import org.wego.pages.FlightSearchResultPage;

public class FlightSearchTest extends BaseTest {

    @Test()
    public void flightSearchTest(){
        FlightSearchPage flightSearchPage = new FlightSearchPage();
        flightSearchPage.selectOneway();
        flightSearchPage.enterFromAirport("Calgary");
        flightSearchPage.enterToAirport("Toronto");
        flightSearchPage.selectDepartDate("22 January 2023");
        flightSearchPage.selectDirectFlight();
        flightSearchPage.selectNumberOfPassenger("3","2","3");
        flightSearchPage.selectCabinType("First Class");
        flightSearchPage.clickFlightSearch();
        FlightSearchResultPage flightSearchResultPage = new FlightSearchResultPage();
        flightSearchResultPage.getFromAirport();
    }
}
