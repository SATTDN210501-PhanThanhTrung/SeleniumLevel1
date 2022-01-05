import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    public final By txtUserName = By.id("username");
    public final By txtPassWord = By.id("password");
    public final By btnLogin = By.xpath("//input[@title='Login']");
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

    public WebElement getLabelErrorEmailMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorEmailMsg);
    }

    public WebElement getLabelErrorLogMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorlogMsg);
    }

    public void login(String username, String password) {
        Utilities.scrollIntoview();
        getTextUserName().sendKeys(username);
        getTextPassWord().sendKeys(password);
        getButtonLogin().click();
    }

    public String getErrorLogMsg() {
        return getLabelErrorLogMsg().getText();
    }

    public String getErrorEmailMsg() {
        return getLabelErrorEmailMsg().getText();
    }

    public void loginMutilpleTimes() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            login(Constant.USERNAME, Utilities.generateRandomString());
            WebElement email = getTextUserName();
            email.clear();
            Thread.sleep(1000);
        }
    }
}
