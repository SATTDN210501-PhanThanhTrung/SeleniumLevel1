import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

public class MyTicket extends GeneralPage {

    public final By btnCancel = By.xpath("//tbody/tr[count(//th[text()='Operation']/preceding-sibling::th)-8]//input[@value='Cancel']");

    public WebElement getButtonCancel() {
        return Constant.WEBDRIVER.findElement(btnCancel);
    }

    public void clickCancelButton() {
        Utilities.scrollIntoview();
        getButtonCancel().click();
    }

    public boolean isCancelButtonDisappear() {
        try {
            getButtonCancel();
            return false;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return true;
        }
    }
}
