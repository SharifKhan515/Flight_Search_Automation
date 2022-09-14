package org.wego.testcases;

import org.wego.pages.FlightSearchHomePage;
import org.testng.annotations.Test;

public class FlightSearchTest extends BaseTest {

    @Test()
    public void flightSearchTest(){
        FlightSearchHomePage flightSearchHomePage = new FlightSearchHomePage();
        flightSearchHomePage.selectOneway();
        flightSearchHomePage.enterFromAirport("Calgary");
        flightSearchHomePage.enterToAirport("Toronto");
        flightSearchHomePage.selectDepartDate("22");
    }
}
