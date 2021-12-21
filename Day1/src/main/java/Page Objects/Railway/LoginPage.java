import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    //Locators
    private final By _txtUserName = By.xpath("//input[@id='username']");
    private final By _txtPassWord = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//body/div[@id='page']/div[@id='content']/form[1]/fieldset[1]/p[1]/input[1]");
    private final By _lblLoginErrorMsg = By.xpath("//*[@id=\"content\"]/p");

    //Elements
    public WebElement getTxtUserName() {
        return Constant.WEBDRIVER.findElement(_txtUserName);
    }

    public WebElement getTxtPassWord() {
        return Constant.WEBDRIVER.findElement(_txtPassWord);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    //Methods
    public HomePage login(String username, String password) {

        this.getTxtUserName().sendKeys(username);
        this.getTxtPassWord().sendKeys(password);
        this.getBtnLogin().click();
        return new HomePage();
    }
}
