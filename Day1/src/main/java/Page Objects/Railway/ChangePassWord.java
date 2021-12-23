import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePassWord extends GeneralPage {
    @FindBy(xpath = "//input[@id='currentPassword']")
    public WebElement curentPassWord;
    @FindBy(xpath = "//input[@id='newPassword']")
    public WebElement newPassWord;
    @FindBy(xpath = "//input[@id='confirmPassword']")
    public WebElement confirmPassWord;
    @FindBy(xpath = "//body/div[@id='page']/div[@id='content']/form[@id='ChangePW']/fieldset[1]/p[1]/input[1]")
    public WebElement btnChangePW;
    @FindBy(xpath = "//p[contains(text(),'Password change failed. Please correct the errors ')]")
    public WebElement errorChangePW;
    @FindBy(xpath = "//label[contains(text(),'The password confirmation does not match the new p')]")
    public WebElement errorDontMatch;


    public ChangePassWord changePassWord(String currentPW, String newPW, String confirmPW) {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        this.curentPassWord.sendKeys(currentPW);
        this.newPassWord.sendKeys(newPW);
        this.confirmPassWord.sendKeys(confirmPW);
        this.btnChangePW.click();
        return new ChangePassWord();
    }


    public String getErrorChangePW() {
        return this.errorChangePW.getText();
    }

    public String getErrorDontMatch() {
        return this.errorDontMatch.getText();
    }
}
