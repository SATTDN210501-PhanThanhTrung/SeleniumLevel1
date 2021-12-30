import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketPrice extends GeneralPage {

    public final By inforOfTicket = By.xpath("//tr[@class='TableSmallHeader']/th");
    public final By seatType = By.xpath("//th[normalize-space()='Seat type']/following-sibling::td[text()='HS']/../td");
    public final By price = By.xpath("//th[normalize-space()='Price (VND)']/following-sibling::td");

    public WebElement getInforOfTicket() {
        return Constant.WEBDRIVER.findElement(inforOfTicket);
    }

    public List<WebElement> getSeatType() {
        return Constant.WEBDRIVER.findElements(seatType);
    }

    public List<WebElement> getPrice() {
        return Constant.WEBDRIVER.findElements(price);
    }

    public String getInforTicketPrice() {
        return getInforOfTicket().getText();
    }

    public String[] actualTicketPrice = {};
    List<String> actualSeatTypeList = new ArrayList<>(Arrays.asList(actualTicketPrice));

    public String[] verifyAllInforOfTicket() {
        for (int i = 0; i < getSeatType().size(); i++) {
            String actualSeatType = getSeatType().get(i).getText() + " : " + getPrice().get(i).getText();
            actualSeatTypeList.add(actualSeatType);
        }
        actualTicketPrice = actualSeatTypeList.toArray(new String[actualSeatTypeList.size()]);
        return actualTicketPrice;
    }

}
