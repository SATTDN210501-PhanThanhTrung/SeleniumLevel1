import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class GeneralPage {
    //Locators
    private final By tabLogin = By.xpath("//*[@id=\"menu\"]/ul/li[8]/a");
    private final By tabLogout=By.xpath("//*[@id=\"menu\"]/ul/li[9]/a");
    private final By lblWelcomeMessage= By.xpath("//*[@id=\"banner\"]/div/strong");

    //Elements
    protected WebElement getTabLogin(){

        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabLogout(){

        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getLblWelcomeMessage(){

        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    //Methods
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }
    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }
}
