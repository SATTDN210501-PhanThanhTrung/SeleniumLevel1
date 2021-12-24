import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePassWord extends GeneralPage {

    public final By txtCurrentPassWord = By.id("currentPassword");
    public final By txtNewPassWord = By.id("newPassword");
    public final By txtConfirmPassWord = By.id("confirmPassword");
    public final By btnChangePassword = By.xpath("//input[@title='Change password']");
    public final By lblErrorChangePWMsg = By.xpath("//p[@class='message error']");
    public final By lblErrorDoneMatchMsg = By.xpath("//label[contains(text(),'The password confirmation does not match the new p')]");

    public WebElement getCurrentPassword() {
        return Constant.WEBDRIVER.findElement(txtCurrentPassWord);
    }

    public WebElement getNewPassword() {
        return Constant.WEBDRIVER.findElement(txtNewPassWord);
    }

    public WebElement getConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassWord);
    }

    public WebElement getBtnChangePassword() {
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }

    public WebElement getLabelErrorChangePassword() {
        return Constant.WEBDRIVER.findElement(lblErrorChangePWMsg);
    }

    public WebElement getLabelErrorDontMatchPassword() {
        return Constant.WEBDRIVER.findElement(lblErrorDoneMatchMsg);
    }

    public void changePassWord(String currentPW, String newPW, String confirmPW) {
        this.getCurrentPassword().sendKeys(currentPW);
        this.getNewPassword().sendKeys(newPW);
        this.getConfirmPassword().sendKeys(confirmPW);
        this.getBtnChangePassword().click();
    }

    public String getErrorChangePW() {
        return this.getLabelErrorChangePassword().getText();
    }

    public String getErrorDontMatch() {
        return this.getLabelErrorDontMatchPassword().getText();
    }
}
