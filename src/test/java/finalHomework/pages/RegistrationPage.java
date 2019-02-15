package finalHomework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    private BaseFunctions baseFunctions;

    private final By NAME_FIELD = By.id("name");
    private final By SURNAME_FIELD = By.id("surname");
    private final By DISCOUNT_FIELD = By.id("discount");
    private final By TRAVELING_WITH_SOMEONE_FIELD = By.id("adults");
    private final By TRAVELING_WITH_CHILDREN_FIELD = By.id("children");
    private final By TRAVELING_WITH_LUGGAGE_FIELD = By.id("bugs");
    private final By NEXT_FLIGHT_FIELD = By.id("flight");
    private final By GET_PRICE_BUTTON = By.xpath(".//span[@onclick = 'setLang();']");
    private final By GET_PRICE_TEXT = By.id("response");
    private final By BOOK_BUTTON = By.id("book2");
    private final By SEATS_FORM = By.xpath(".//div[@class = 'seat']");
    private final By SEAT_CONFORMATION_MESSAGE = By.xpath(".//div[@class = 'line']");
    private final By SECOND_BOOK_BUTTON = By.id("book3");


    public RegistrationPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void fillName(String name) {
        WebElement field = baseFunctions.getElement(NAME_FIELD);
        baseFunctions.writeInTextBox(field, name);
    }

    public void fillSurname(String surname) {
        WebElement field = baseFunctions.getElement(SURNAME_FIELD);
        baseFunctions.writeInTextBox(field, surname);
    }

    public void fillDiscount(String discount) {
        WebElement field = baseFunctions.getElement(DISCOUNT_FIELD);
        baseFunctions.writeInTextBox(field, discount);
    }

    public void fillTravelingWithSomeone(String personCount) {
        WebElement field = baseFunctions.getElement(TRAVELING_WITH_SOMEONE_FIELD);
        baseFunctions.writeInTextBox(field, personCount);
    }

    public void fillTravelingWithChildren(String childrenCount) {
        WebElement field = baseFunctions.getElement(TRAVELING_WITH_CHILDREN_FIELD);
        baseFunctions.writeInTextBox(field, childrenCount);
    }

    public void fillTravelingWithLuggage(String luggageCount) {
        WebElement field = baseFunctions.getElement(TRAVELING_WITH_LUGGAGE_FIELD);
        baseFunctions.writeInTextBox(field, luggageCount);
    }

    public void fillNextFlight(String flightDate) {
        baseFunctions.selectFromDropdown(NEXT_FLIGHT_FIELD, flightDate);
    }

    public void clickOnGetPriceButton() {
        baseFunctions.click(GET_PRICE_BUTTON);
    }

    public void assertionPrice(Integer price) {
        baseFunctions.waitForInvisibilityOfElement(GET_PRICE_TEXT);
        String textWithPrice = baseFunctions.getElement(GET_PRICE_TEXT).getText();
        String textWithoutReservationNumber = textWithPrice.substring(0, textWithPrice.length() - 10);
        Integer ourPrice = Integer.parseInt(textWithoutReservationNumber.replaceAll("[\\D+]", ""));
        Assertions.assertEquals(price, ourPrice, "wrong ticked price");
    }

    public void clickOnBookButton() {
        baseFunctions.click(BOOK_BUTTON);
    }

    public void selectSeatPlace(Integer seat) {
        baseFunctions.getElements(SEATS_FORM).get(seat - 1).click();
    }

    public void assertSeatConformationMessage() {
        Assertions.assertTrue(baseFunctions.getElement(SEAT_CONFORMATION_MESSAGE).isDisplayed(), "Conformation message not displayed");
    }

    public ConfirmationPage clickOnSecondBookButton() {
        baseFunctions.getElement(SECOND_BOOK_BUTTON).click();
        return new ConfirmationPage(baseFunctions);
    }

    public void checkRegistrationPage() {
        Assertions.assertTrue(baseFunctions.getElement(GET_PRICE_BUTTON).isDisplayed(), "Incorrect Registration page");
    }

    public void checkSeatPage() {
        baseFunctions.waitForElement(SEATS_FORM);
        Assertions.assertTrue(baseFunctions.getElement(SEATS_FORM).isDisplayed(), "Incorrect Seat page");
    }

}
