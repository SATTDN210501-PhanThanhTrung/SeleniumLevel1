import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GeneralPage {
    //Locators and Element
    @FindBy(xpath = "//input[@id='username']")
    public WebElement txtUserName;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement txtPassWord;
    @FindBy(xpath = "//input[@title='Login']")
    public WebElement btnLogin;
    @FindBy(xpath = "//a[contains(text(),'Forgot Password page')]")
    public WebElement linkForgotPassWord;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement txtEmailAddress;
    @FindBy(xpath = "//input[@value='Send Instructions']")
    public WebElement btnSendIns;

    //Methods
    public LoginPage login(String username, String password) {
        Constant.scrollIntoview();
        PageFactory.initElements(Constant.WEBDRIVER, this);
        txtUserName.sendKeys(username);
        txtPassWord.sendKeys(password);
        btnLogin.click();
        return new LoginPage();
    }

    public void getLinkForgotPassWord() {
        linkForgotPassWord.click();
    }

    public LoginPage forgotPassword(String emailAddress) {
        txtEmailAddress.sendKeys(emailAddress);
        btnSendIns.click();
        return new LoginPage();
    }
}
