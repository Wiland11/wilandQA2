package finalHomework.pages;

import org.openqa.selenium.By;

public class HomePage {

    private BaseFunctions baseFunctions;

    private final By DEPARTURE_DROPDOWN = By.id("afrom");
    private final By ARRIVAL_DROPDOWN = By.id("bfrom");
    private final By GOGOGO_BUTTON = By.xpath(".//span[@class='gogogo']");

    //в каждом пейдже нужно передать браузер в конструктор
    public HomePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void selectDepartureAirport(String departure) {
        baseFunctions.selectFromDropdown(DEPARTURE_DROPDOWN, departure);
    }

    public void selectArrivalAirport(String arrival) {
        baseFunctions.selectFromDropdown(ARRIVAL_DROPDOWN, arrival);
    }

    public RegistrationPage clickOnGoButton() {
        baseFunctions.click(GOGOGO_BUTTON);
        return new RegistrationPage(baseFunctions);
    }

}