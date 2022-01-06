package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    public final By txtEmail = By.id("email");
    public final By txtPassWord = By.id("password");
    public final By txtConfirmPassWord = By.id("confirmPassword");
    public final By txtPassPort = By.id("pid");
    public final By btnRegister = By.xpath("//input[@title='Register']");
    public final By lblRegisterConfirm = By.xpath("//p[normalize-space()=\"You're here\"]");
    public final By lblErrorRegMsg=By.xpath("//p[@class='message error']");
    public final By lblErrorPassWordMsg=By.xpath("//label[normalize-space()='Invalid password length']");
    public final By lblErrorPIDMsg=By.xpath("//label[normalize-space()='Invalid ID length']");
    public final By lblErrorAlreadyEmailMsg=By.xpath("//p[@class='message error']");
    public WebElement getLabelRegisterConfirm() {
        return Constant.WEBDRIVER.findElement(lblRegisterConfirm);
    }

    public WebElement getTextEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    public WebElement getTextPassWord() {
        return Constant.WEBDRIVER.findElement(txtPassWord);
    }

    public WebElement getTextConfirmPassWord() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassWord);
    }

    public WebElement getTextPID() {
        return Constant.WEBDRIVER.findElement(txtPassPort);
    }

    public WebElement getButtonRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }
    public WebElement getLabelErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorRegMsg);
    }
    public WebElement getLabelErrorPassWordMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorPassWordMsg);
    }
    public WebElement getLabelErrorPIDMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorPIDMsg);
    }
    public WebElement getLabelErrorAlreadyEmail() {
        return Constant.WEBDRIVER.findElement(lblErrorAlreadyEmailMsg);
    }

    public void register(String email, String password, String confirmpw, String pid) {
        getTextEmail().sendKeys(email);
        getTextPassWord().sendKeys(password);
        getTextConfirmPassWord().sendKeys(confirmpw);
        getTextPID().sendKeys(pid);

    }
    public void clickRegisterButton(){
        getButtonRegister().click();
    }

    public String getReConfirm() {
        return getLabelRegisterConfirm().getText();
    }
    public String getErrorMsg() {
        return getLabelErrorMsg().getText();
    }
    public String getErrorPassWordMsg() {
        return getLabelErrorPassWordMsg().getText();
    }
    public String getErrorPIDMsg() {
        return getLabelErrorPIDMsg().getText();
    }
    public String getErrorAlreadyEmailMsg() {
        return getLabelErrorAlreadyEmail().getText();
    }
}
