import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralPage {
    //Locators
    @FindBy(xpath = "//a[@href='/Account/Logout']")
    public WebElement tabLogout;
    @FindBy(xpath = "//a[@href='/Account/Login.cshtml']")
    public WebElement tabLogin;
    @FindBy(xpath = "//a[@href='/Account/Register.cshtml']")
    public WebElement tabRegister;
    @FindBy(xpath = "//a[@href='/Page/BookTicketPage.cshtml']")
    public WebElement tabBookticket;
    @FindBy(xpath = "//a[@href='/Account/ChangePassword.cshtml']")
    public WebElement tabChangePassword;
    @FindBy(xpath = "//a[normalize-space()='create an account']")
    public WebElement lblCreateAcc;//HomePage
    @FindBy(xpath = "//*[@id=\"banner\"]/div/strong")
    public WebElement lblWelcomeMessage;//login
    @FindBy(xpath = "//p[@class='message error LoginForm']")
    public WebElement lblErrorLogMsg;//Login
    @FindBy(xpath = "//p[contains(text(),'Registration Confirmed! You can now log in to the ')]")
    public WebElement lblRegistrationConfirm;//Register
    @FindBy(xpath = "//p[contains(text(),\"There're errors in the form. Please correct the er\")]")
    public WebElement lblErrorResMsg;//Register
    @FindBy(xpath = "//label[contains(text(),'Invalid email length')]")
    public WebElement lblErrorResEmail;//Register
    @FindBy(xpath = "//label[contains(text(),'Invalid password length')]")
    public WebElement lblErrorResPassword;//Register
    @FindBy(xpath = "//label[contains(text(),'Invalid ID length')]")
    public WebElement lblErrorResPID;//Register
    @FindBy(xpath = "//p[contains(text(),'This email address is already in use.')]")
    public WebElement errorAlreadyEmail;//Register

    //Methods
    public LoginPage    gotoLoginPage() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        tabLogin.click();
        return new LoginPage();
    }
    public HomePage logout() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        tabLogout.click();
        return new HomePage();
    }
    public RegisterPage gotoRegister() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        tabRegister.click();
        return new RegisterPage();
    }
    public BookticketPage gotoBookticet() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        tabBookticket.click();
        return new BookticketPage();
    }
    public ChangePassWord gotoChangePassword() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        tabChangePassword.click();
        return new ChangePassWord();
    }
    public String getCreateAccout() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        return this.lblCreateAcc.getText();
    }
    public String getWelcomeMessage() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        return this.lblWelcomeMessage.getText();
    }
    public String getErrorLogMsg() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        return this.lblErrorLogMsg.getText();
    }
    public String getReConfirm() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        return this.lblRegistrationConfirm.getText();
    }
    public String getErrorRegEmail() {
        PageFactory.initElements(Constant.WEBDRIVER, this);

        return this.lblErrorResEmail.getText();
    }
    public String getErrorRegMsg() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        return this.lblErrorResMsg.getText();
    }
    public String getErrorRegPW() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        return this.lblErrorResPassword.getText();
    }
    public String getErrorRegPID() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        return this.lblErrorResPID.getText();
    }
    public String getErrorAlreadyEmail() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        return this.errorAlreadyEmail.getText();
    }
}
