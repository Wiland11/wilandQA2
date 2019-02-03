package finalHomework;

import cucumber.api.java.After;
import finalHomework.pages.BaseFunctions;
import finalHomework.pages.ConfirmationPage;
import finalHomework.pages.HomePage;
import finalHomework.pages.RegistrationPage;
import finalHomework.model.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;
import java.util.Map;

public class ReservationStepDefinitions {

    private BaseFunctions baseFunc = new BaseFunctions();
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private ConfirmationPage confirmationPage;
    private ReservationRequester requester = new ReservationRequester();
    private Response response;
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
        registrationPage.checkRegistrationPage();
    }

    @When("I fill registration form with:")
    public void fill_registration_form(Map<String, String> params) {
        registrationPage.fillName(params.get("name"));
        registrationPage.fillSurname(params.get("surname"));
        registrationPage.fillDiscount(params.get("discountCode"));
        registrationPage.fillTravelingWithSomeone(params.get("personCount"));
        registrationPage.fillTravelingWithChildren(params.get("childrenCount"));
        registrationPage.fillTravelingWithLuggage(params.get("luggageCount"));
        registrationPage.fillNextFlight(params.get("departureDate"));
    }

    @Then("I click on Get Price button")
    public void click_get_price_button() {
        registrationPage.clickOnGetPriceButton();
    }

    @Then("I get price for current flight: ([0-9]*) EUR")
    public void check_flight_price(Integer price) {
        registrationPage.assertionPrice(price);
    }

    @When("I click on Book button")
    public void click_book_button() {
        registrationPage.clickOnBookButton();
    }

    @Then("seat selection page appeared")
    public void check_seat_selection_page() {
        registrationPage.checkSeatPage();
    }

    @When("I select desired seat ([0-9]*)")
    public void select_seat(Integer seat) {
        registrationPage.selectSeatPlace(seat);
    }

    @Then("seat confirmation message appears")
    public void check_seat_confirmation_message() {
        registrationPage.assertSeatConformationMessage();
    }

    @When("I click on Book button again")
    public void click_on_book_button() {
        confirmationPage = registrationPage.clickOnSecondBookButton();
    }

    @Then("reservation confirmation page appears")
    public void check_confirmation_page() {
        confirmationPage.checkConfirmationPage();
    }

    @When("I request reservations list")
    public void request_reservation_list() throws IOException {
        response = requester.getReservationsList();
    }

    @Then("my reservation is in this list")
    public void check_my_reservation() {

    }

    @After
    public void delete_my_reservation() {

    }

}