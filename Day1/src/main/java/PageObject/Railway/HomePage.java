import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {

    public final By lblWelcomeHomePage = By.xpath("//h1[contains(text(),'Welcome to Safe Railway')]");

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
