import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginPage {
    //Locators
    private final By _txtUserName = By.xpath("//input[@id='username']");
    private final By _txtPassWord = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//*[@id=\"content\"]/form/fieldset/p/input");

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



    //Methods
    public HomePage login(String username, String password) {
        WebElement element = Constant.WEBDRIVER.findElement(By.xpath("//a[contains(text(),'Web hosting by Somee.com')]"));
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
        this.getTxtUserName().sendKeys(username);
        this.getTxtPassWord().sendKeys(password);
        this.getBtnLogin().click();
        return new HomePage();
    }

}
