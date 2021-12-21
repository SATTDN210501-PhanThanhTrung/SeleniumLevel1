import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    //Locator
    private final By _email = By.xpath("//input[@id='email']");
    private final By _passWord = By.xpath("//input[@id='password']");
    private final By _confirmPW = By.xpath("//input[@id='confirmPassword']");
    private final By _passPort = By.xpath("//input[@id='pid']");
    private final By _btnRegister = By.xpath("//body/div[@id='page']/div[@id='content']/form[@id='RegisterForm']/fieldset[1]/p[1]/input[1]");

    //Element
    public WebElement getEmail() {
        return Constant.WEBDRIVER.findElement(_email);
    }

    public WebElement getPassword() {
        return Constant.WEBDRIVER.findElement(_passWord);
    }

    public WebElement getConfirmPassword() {
        return Constant.WEBDRIVER.findElement(_confirmPW);
    }

    public WebElement getPID() {
        return Constant.WEBDRIVER.findElement(_passPort);

    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(_btnRegister);

    }

    public HomePage register(String email, String password, String confirmpw, String pid) {
        this.getEmail().sendKeys(email);
        this.getPassword().sendKeys(password);
        this.getConfirmPassword().sendKeys(confirmpw);
        this.getPID().sendKeys(pid);
        this.getBtnRegister().click();
        return new HomePage();
    }

}
