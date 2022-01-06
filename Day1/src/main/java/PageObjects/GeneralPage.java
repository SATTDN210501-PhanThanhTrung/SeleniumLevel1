package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    public final By tabLogout = By.xpath("//a[@href='/Account/Logout']");
    public final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
    public final By tabRegister = By.xpath("//a[@href='/Account/Register.cshtml']");
    public final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    public final By tabChangePassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    public final By tabTimeTabel = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
    public final By tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
    public final By tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");
    public final By lbbMyWelcomeMessage = By.tagName("strong");
    public final By elementScroll= By.xpath("//a[contains(text(),'Web hosting by Somee.com')]");

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

    public WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    public WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    public WebElement getLabelWelcome() {
        return Constant.WEBDRIVER.findElement(lbbMyWelcomeMessage);
    }

    public WebElement getElementScroll(){
        return Constant.WEBDRIVER.findElement(elementScroll);
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

    public void gotoTimeTable() {
        getTabTimeTabel().click();
    }

    public void gotoMyTicket() {
        getTabMyTicket().click();
    }

    public void gotoContact() {
        getTabContact().click();
    }

    public String getWelcomeMessage() {
        return getLabelWelcome().getText();
    }

}
