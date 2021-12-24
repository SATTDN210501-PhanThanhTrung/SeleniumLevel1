import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GeneralPage {

    public final By tabLogout = By.xpath("//a[@href='/Account/Logout']");
    public final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
    public final By tabRegister = By.xpath("//a[@href='/Account/Register.cshtml']");
    public final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    public final By tabChangePassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    public final By tabTimeTabel = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
    public final By tabTicketPrice = By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']");
    public final By tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
    public final By tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");
    public final By lbbMyWelcomeMessage = By.xpath("//*[@id=\"banner\"]/div/strong");

    public WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    public WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    public WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    public WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    public WebElement getTabChangePassWord() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    public WebElement getTabTimeTabel() {
        return Constant.WEBDRIVER.findElement(tabTimeTabel);
    }

    public WebElement getTabTicketPrice() {
        return Constant.WEBDRIVER.findElement(tabTicketPrice);
    }

    public WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    public WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    public WebElement getLabelWelcome() {
        return Constant.WEBDRIVER.findElement(lbbMyWelcomeMessage);
    }

    //Methods
    public void gotoLoginPage() {
        getTabLogin().click();
    }

    public void logout() {
        getTabLogout().click();
    }

    public void gotoRegister() {
        getTabRegister().click();
    }

    public void gotoBookticet() {
        getTabBookTicket().click();
    }

    public void gotoChangePassword() {
        getTabChangePassWord().click();
    }

    public TicketPrice gotoTicketPrice() {
        getTabTicketPrice().click();
        return new TicketPrice();
    }

    public void gotoTimeTable() {
        getTabTimeTabel().click();
    }

    public MyTicket gotoMyTicket() {
        getTabMyTicket().click();
        return new MyTicket();
    }

    public void gotoContact() {
        getTabContact().click();
    }

    public String getWelcomeMessage() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        return getLabelWelcome().getText();
    }

}
