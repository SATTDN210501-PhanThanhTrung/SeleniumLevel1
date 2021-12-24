import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPrice extends  GeneralPage{

    public final By inforOfTicket= By.xpath("//tr[@class='TableSmallHeader']/th");
    public WebElement getInforOfTicket(){
        return Constant.WEBDRIVER.findElement(inforOfTicket);
    }

    public String getInforTicketPrice(){
        return getInforOfTicket().getText();
    }

}
