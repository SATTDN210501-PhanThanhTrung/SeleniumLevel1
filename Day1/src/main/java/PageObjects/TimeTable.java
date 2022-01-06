package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTable extends GeneralPage {

    public final String lnkCheckPrice = "//td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a";

    public WebElement getLinkCheckPrice(String departFrom, String arriveAt) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lnkCheckPrice, departFrom, arriveAt)));
    }

    public void clickCheckPriceLink(String departFrom, String arriveAt) {
        Utilities.scrollIntoview(getElementScroll());
        getLinkCheckPrice(departFrom, arriveAt).click();
    }

}
