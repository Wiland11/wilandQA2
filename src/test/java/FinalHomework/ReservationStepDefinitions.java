package FinalHomework;

import FinalHomework.pages.BaseFunctions;
import FinalHomework.pages.HomePage;
import FinalHomework.pages.RegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

public class ReservationStepDefinitions {

    private BaseFunctions baseFunc = new BaseFunctions();
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private final String URL = "qaguru.lv:8090/tickets";

    @Given("I am on home page")
    public void open_home_page() {
        baseFunc.openPage(URL);
        homePage = new HomePage(baseFunc);
    }

    @When("I selected departure airport (.*)")
    public void select_departure_airport(String departure) {
        homePage.selectDepartureAirport(departure);
    }

    @When("I selected arrival airport (.*)")
    public void select_arrival_airport(String arrival) {
        homePage.selectArrivalAirport(arrival);
    }

    @When("I click on GO button")
    public void click_go_button() {
        registrationPage = homePage.clickOnGoButton();
    }

    @Then("registration page appears")
    public void check_registration_page() {

    }

    @When("I fill registration form with:")
    public void fill_registration_form(Map<String, String> params) {

    }

    @Then("I click on Get Price button")
    public void click_getprice_button() {

    }
}