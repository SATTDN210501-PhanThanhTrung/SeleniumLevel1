import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookticketPage extends GeneralPage{
    //Locator
private final By titelBookticket=By.xpath("//h1[contains(text(),'Book ticket')]");

protected WebElement getTitleBookticket(){
    return Constant.WEBDRIVER.findElement(titelBookticket);
}
public String getTextBookticket(){
    return this.getTitleBookticket().getText();
}
}
