package org.wego.testcases;

import org.testng.asserts.SoftAssert;
import org.wego.pages.FlightSearchPage;
import org.testng.annotations.Test;
import org.wego.pages.FlightSearchResultPage;

import java.util.HashMap;

public class FlightSearchTest extends BaseTest {

    @Test()
    public void flightSearchTest(){
        SoftAssert softAssert = new SoftAssert();
        FlightSearchPage flightSearchPage = new FlightSearchPage();
        FlightSearchResultPage flightSearchResultPage = new FlightSearchResultPage();
        String fromAirport = "Calgary";
        String toAirport = "Toronto";
        String date = "22 February 2023";
        String adult ="3",child ="2",infant="2";
        String cabin = "Economy";
        String trip = "One-way";

        flightSearchPage.selectTripType(trip);
        flightSearchPage.enterFromAirport(fromAirport);
        flightSearchPage.enterToAirport(toAirport);
        flightSearchPage.selectDepartDate(date);
        flightSearchPage.selectDirectFlight();
        flightSearchPage.selectNumberOfPassenger(adult,child,infant);
        flightSearchPage.selectCabinType(cabin);
        flightSearchPage.clickFlightSearch();

        String fromAirportInResult = flightSearchResultPage.getFromAirport();
        softAssert.assertTrue(fromAirportInResult.contains(fromAirport),"From airport in search page and Search result page not match");

        String toAirportInResult = flightSearchResultPage.getToAirport();
        softAssert.assertTrue(toAirportInResult.contains(toAirport),"To airport in search page and Search result page not match");

        String tripType = flightSearchResultPage.getActiveTripType();
        softAssert.assertEquals(tripType,trip,"Trip Type in search page and Search result page not match");

        String departDateInResult = flightSearchResultPage.getDepartDate();
        String[] departDate = departDateInResult.split(" ");
        softAssert.assertTrue(date.contains(departDate[1]),"Depart date in search page and Search result page not match");
        softAssert.assertTrue(date.contains(departDate[2]),"Depart month in search page and Search result page not match");
        softAssert.assertTrue(date.contains(departDate[3]),"Depart year in search page and Search result page not match");

        String cabinTypeInResult = flightSearchResultPage.getCabinType();
        softAssert.assertEquals(cabinTypeInResult,cabin,"Cabin Type in search page and Search result page not match");

        HashMap<String,String> passengerCount = flightSearchResultPage.getAllPassengerCount();
        int total_passenger = Integer.parseInt(adult)+Integer.parseInt(child)+Integer.parseInt(infant);
        softAssert.assertEquals(passengerCount.get("adult"),adult,"adult passenger in search page and Search result page not match");
        softAssert.assertEquals(passengerCount.get("child"),child,"child passenger in search page and Search result page not match");
        softAssert.assertEquals(passengerCount.get("infant"),infant,"infant passenger in search page and Search result page not match");
        softAssert.assertEquals(passengerCount.get("total_passenger").split(" ")[0],Integer.toString(total_passenger),"Total passenger in search page and Search result page not match");

        softAssert.assertAll();
    }
}
