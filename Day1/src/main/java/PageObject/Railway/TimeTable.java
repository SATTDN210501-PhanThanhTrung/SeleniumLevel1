import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTable extends GeneralPage {

    public final String lnkCheckPrice = "//td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a";
    public final String dgdDepartStaion = "//td[text()='%s']/following-sibling::td[text()='%s']";
    public final String dgdArrivetStaion = "//td[text()='%s']/preceding-sibling::td[text()='%s']";

    public WebElement getLinkCheckPrice(String departFrom, String arriveAt) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lnkCheckPrice, departFrom, arriveAt)));
    }

    public WebElement getDataGridDepartStation(String departFrom, String arriveAt) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dgdDepartStaion, departFrom, arriveAt)));
    }

    public WebElement getDataGridArriveStation(String arriveAt, String departFrom) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dgdArrivetStaion, arriveAt, departFrom)));
    }

    public void clickCheckPriceLink(String departFrom, String arriveAt) {
        Utilities.scrollIntoview();
        getLinkCheckPrice(departFrom, arriveAt).click();
    }

    public String getDepartSationOnTT(String departFrom, String arriveAt) {
        return getDataGridDepartStation(departFrom,arriveAt).getText();
    }

    public String getArriveSationOnTT(String arriveAt, String departFrom) {
        return getDataGridArriveStation(arriveAt,departFrom).getText();
    }
}
