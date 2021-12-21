import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class GeneralPage {
    //Locators
    private final By tabLogin = By.xpath("//*[@id=\"menu\"]/ul/li[8]/a");
    private final By tabLogout=By.xpath("//*[@id=\"menu\"]/ul/li[9]/a");
    private final By lblWelcomeMessage= By.xpath("//*[@id=\"banner\"]/div/strong");
    private final By tabRegister = By.xpath("//*[@id=\"menu\"]/ul/li[7]/a");
    private final By lblRegistrationConfirm= By.xpath("//p[contains(text(),'Registration Confirmed! You can now log in to the ')]");
    private final By lblCreateAcc= By.xpath("//h1[contains(text(),'Create account')]");
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
    protected WebElement getTabRegister(){

        return  Constant.WEBDRIVER.findElement(tabRegister);
    }
    protected WebElement getlblReConfirm(){
        return Constant.WEBDRIVER.findElement(lblRegistrationConfirm);
    }
    protected WebElement getLblCreateAcc(){
        return Constant.WEBDRIVER.findElement(lblCreateAcc);
    }
    //Methods
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }
    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }
    public  RegisterPage gotoRegister(){
        this.getTabRegister().click();
        return  new RegisterPage();
    }
    public String getReConfirm(){
        return this.getlblReConfirm().getText();
    }
    public String getCreateAccout(){
        return this.getLblCreateAcc().getText();
    }
}
