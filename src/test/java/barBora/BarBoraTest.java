import barBora.pages.BaseFunc;
import barBora.pages.HomePage;
import barBora.pages.PopUp;
import barBora.pages.Registration;
import org.junit.jupiter.api.Test;

public class BarBoraTest {
    private BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "www.barbora.lv";

    @Test
    public void barBoraTest() {
        baseFunc.goToUrl(HOME_PAGE);
        HomePage homePage = new HomePage(baseFunc);
        PopUp popUp = homePage.addToCartByName("CLEMENULES");
        Registration registration = popUp.goToRegistrationPage();
        registration.fillEmail("qwerty");
        registration.selectCity("Jūrmala");
    }
}