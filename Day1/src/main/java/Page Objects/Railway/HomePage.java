import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GeneralPage {
    @FindBy(xpath = "//a[contains(text(),'create an account')]")
    public WebElement linkcreateAcc;

    @FindBy(xpath = "//h1[contains(text(),'Welcome to Safe Railway')]")
    public WebElement welcomeHomePage;

    public HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return new HomePage();
    }

    public String getTextWelcomeHP() {
        return welcomeHomePage.getText();
    }

    public HomePage createAccount() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        Constant.scrollIntoview();
        linkcreateAcc.click();
        return new HomePage();
    }

}
