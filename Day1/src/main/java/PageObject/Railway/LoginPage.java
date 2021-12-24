import Common.Constant;
import Common.Untilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    public final By txtUserName = By.id("username");
    public final By txtPassWord = By.id("password");
    public final By btnLogin = By.xpath("//input[@title='Login']");
    public final By lnkForgotPassWord = By.xpath("//a[normalize-space()='Forgot Password page']");
    public final By txtEmailAddress = By.id("email");
    public final By btnSendIns = By.xpath("//input[@value='Send Instructions']");
    public final By lblErrorlogMsg = By.xpath("//p[@class='message error LoginForm']");
    public final By lblErrorEmailMsg = By.xpath("//label[normalize-space()='You must specify a username.']");

    public WebElement getTextUserName() {
        return Constant.WEBDRIVER.findElement(txtUserName);
    }

    public WebElement getTextPassWord() {
        return Constant.WEBDRIVER.findElement(txtPassWord);
    }

    public WebElement getButtonLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLinkForgotPassWord() {
        return Constant.WEBDRIVER.findElement(lnkForgotPassWord);
    }

    public WebElement getLabelErrorEmailMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorEmailMsg);
    }

    public WebElement getTextEmail() {
        return Constant.WEBDRIVER.findElement(txtEmailAddress);
    }

    public WebElement getButtonSendIns() {
        return Constant.WEBDRIVER.findElement(btnSendIns);
    }

    public WebElement getLabelErrorLogMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorlogMsg);
    }

    public void login(String username, String password) {
        Constant.scrollIntoview();
        getTextUserName().sendKeys(username);
        getTextPassWord().sendKeys(password);
        getButtonLogin().click();
    }

    public void clickForgotPassWordLink() {
        getLinkForgotPassWord().click();
    }

    public LoginPage forgotPassword(String emailAddress) {
        getTextEmail().sendKeys(emailAddress);
        getButtonSendIns().click();
        return new LoginPage();
    }

    public String getErrorLogMsg() {
        return getLabelErrorLogMsg().getText();
    }

    public String getErrorEmailMsg() {
        return getLabelErrorEmailMsg().getText();
    }

    public void loginMutilpleTimes() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            login(Constant.USERNAME, Untilities.generateRandomString());
            WebElement email = getTextUserName();
            email.clear();
            Thread.sleep(1000);
        }
    }
}
