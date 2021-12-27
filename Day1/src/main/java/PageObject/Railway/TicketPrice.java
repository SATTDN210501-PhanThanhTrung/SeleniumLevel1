import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketPrice extends GeneralPage {

    public final By inforOfTicket = By.xpath("//tr[@class='TableSmallHeader']/th");

    public WebElement getInforOfTicket() {
        return Constant.WEBDRIVER.findElement(inforOfTicket);
    }

    public String getInforTicketPrice() {
        return getInforOfTicket().getText();
    }

    String[] actualTicketPrice = {};
    List<String> actualSeatTypeList=new ArrayList<>(Arrays.asList(actualTicketPrice));
    public String[] verifyAllInforOfTicket() {
        for (int i = 1; i <= 6; i++) {
            WebElement seatType = Constant.WEBDRIVER.findElement(By.xpath("//th[normalize-space()='Seat type']/following-sibling::td[text()='HS']/../td[count(//td[text()='HS']/preceding-sibling::td)+" + i + "]"));
            WebElement price = Constant.WEBDRIVER.findElement(By.xpath("//th[normalize-space()='Price (VND)']/following-sibling::td[count(//td[text()='HS']/preceding-sibling::td)+" + i + "]"));
            String actualSeatType = seatType.getText() + " : " + price.getText();
           actualSeatTypeList.add(actualSeatType);
        }
        actualTicketPrice=actualSeatTypeList.toArray(new String[0]);
        return actualTicketPrice;
    }

}
