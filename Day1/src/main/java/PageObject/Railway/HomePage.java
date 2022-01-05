import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {

    public final By lblWelcomeHomePage = By.tagName("h1");

    public WebElement getLabelWelcomeHP() {
        return Constant.WEBDRIVER.findElement(lblWelcomeHomePage);
    }

    public void open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public String getTextWelcomeHP() {
        return getLabelWelcomeHP().getText();
    }

}
