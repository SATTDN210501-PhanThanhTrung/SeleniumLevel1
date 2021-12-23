import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends GeneralPage {
    //Locator
    @FindBy(xpath = "//input[@id='email']")
    public WebElement _email;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement _passWord;
    @FindBy(xpath = "//input[@id='confirmPassword']")
    public WebElement _confirmPW;
    @FindBy(xpath = "//input[@id='pid']")
    public WebElement _passPort;
    @FindBy(xpath = "//input[@title='Register']")
    public WebElement _btnRegister;

    public HomePage register(String email, String password, String confirmpw, String pid) {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        _email.sendKeys(email);
        _passWord.sendKeys(password);
        _confirmPW.sendKeys(confirmpw);
        _passPort.sendKeys(pid);
        _btnRegister.click();
        return new HomePage();
    }

}
