import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTable extends GeneralPage{

    public final By lnkCheckPrice= By.xpath("//td[text()='Sài Gòn']/following-sibling::td[text()='Phan Thiết']/../td[count(//th[text()='Depart Time']/preceding-sibling::th)+3]/a");
    public final By dgdDepartStaion=By.xpath("//td[text()='1']/following-sibling::td[text()='Sài Gòn']");
    public final By dgdArrivetStaion=By.xpath("//td[text()='1']/following-sibling::td[text()='Phan Thiết']");

    public WebElement getLinkCheckPrice(){
        return Constant.WEBDRIVER.findElement(lnkCheckPrice);
    }
    public WebElement getDataGridDepartStation(){
        return Constant.WEBDRIVER.findElement(dgdDepartStaion);
    }
    public WebElement getDataGridArriveStation(){
        return Constant.WEBDRIVER.findElement(dgdArrivetStaion);
    }
    public void clickCheckPriceLink(){
        getLinkCheckPrice().click();
    }
    public String getDepartSationOnTT(){
        return getDataGridDepartStation().getText();
    }
    public String getArriveSationOnTT(){
        return getDataGridArriveStation().getText();
    }
}
