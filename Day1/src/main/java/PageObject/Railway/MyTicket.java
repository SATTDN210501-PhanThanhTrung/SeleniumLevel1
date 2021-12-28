import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTicket extends GeneralPage {

    public final By btnCancel = By.xpath("//tbody/tr[count(//th[text()='Operation']/preceding-sibling::th)-8]//input[@value='Cancel']");
    public final By rowsOfCancelButton = By.xpath("//tbody//input[@value='Cancel']");

    public List<WebElement> getrowsOfCancelButton() {
        return Constant.WEBDRIVER.findElements(rowsOfCancelButton);
    }

    public WebElement getButtonCancel() {
        return Constant.WEBDRIVER.findElement(btnCancel);
    }

    public void clickCancelButton() {
        Constant.scrollIntoview();
        getButtonCancel().click();
    }
}
