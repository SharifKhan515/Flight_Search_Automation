package org.WeGo.testcases;

import org.WeGo.pages.FlightSearchHomePage;
import org.testng.annotations.Test;

public class FlightSearchTest extends BaseTest {

    @Test()
    public void flightSearchTest() throws InterruptedException {
        FlightSearchHomePage flightSearchHomePage = new FlightSearchHomePage();
        flightSearchHomePage.selectOneway();
    }
}
