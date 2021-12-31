import Common.Constant;
import Common.Untilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTable extends GeneralPage {

    public final By lnkCheckPrice = By.xpath("//td[text()='Đà Nẵng']/following-sibling::td[text()='Sài Gòn']/../td[count(//th[text()='Depart Time']/preceding-sibling::th)+3]/a");
    public final By dgdDepartStaion = By.xpath("//td[text()='13']/following-sibling::td[text()='Đà Nẵng']");
    public final By dgdArrivetStaion = By.xpath("//td[text()='13']/following-sibling::td[text()='Sài Gòn']");

    public WebElement getLinkCheckPrice() {
        return Constant.WEBDRIVER.findElement(lnkCheckPrice);
    }

    public WebElement getDataGridDepartStation() {
        return Constant.WEBDRIVER.findElement(dgdDepartStaion);
    }

    public WebElement getDataGridArriveStation() {
        return Constant.WEBDRIVER.findElement(dgdArrivetStaion);
    }

    public void clickCheckPriceLink() {
        Untilities.scrollIntoview();
        getLinkCheckPrice().click();
    }

    public String getDepartSationOnTT() {
        return getDataGridDepartStation().getText();
    }

    public String getArriveSationOnTT() {
        return getDataGridArriveStation().getText();
    }
}
