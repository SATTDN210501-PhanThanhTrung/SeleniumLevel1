import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 extends TestBase {
    @Test(description = "Ticket price page displays with ticket details after clicking on check price link in Train timetable page")
    public void TC15() {
        HomePage homePage = new HomePage();
        TimeTable timeTable=new TimeTable();
        LoginPage loginPage=new LoginPage();
        System.out.println("1.Go to RailWay web");
        homePage.open();
        homePage.gotoLoginPage();
        System.out.println("3.Enters valid Email and Password");
        System.out.println("4.Click on Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        System.out.println("5.Go to TimeTable Page");
        homePage.gotoTimeTable();
        String expectedMsg = "Ticket price from " + timeTable.getDepartSationOnTT() + " to " + timeTable.getArriveSationOnTT();
        System.out.println("6.Click checkprice link Sài Gòn to Phan Thiết");
        timeTable.clickCheckPriceLink();
        TicketPrice ticketPrice = new TicketPrice();
        String actualMsg = ticketPrice.getInforTicketPrice();
        System.out.println("verify all information of the ticket");
        String[] expectedTicketPrice = {"HS : 90000", "SS : 115000", "SSC : 140000", "HB : 190000", "SB : 240000", "SBC : 290000"};
        for (int i = 1; i <= expectedTicketPrice.length; i++) {
            WebElement seatType = Constant.WEBDRIVER.findElement(By.xpath("//th[normalize-space()='Seat type']/following-sibling::td[text()='HS']/../td[count(//td[text()='HS']/preceding-sibling::td)+" + i + "]"));
            WebElement price = Constant.WEBDRIVER.findElement(By.xpath("//th[normalize-space()='Price (VND)']/following-sibling::td[count(//td[text()='HS']/preceding-sibling::td)+" + i + "]"));
            String actualTicketPrice = seatType.getText() + " : " + price.getText();
            Assert.assertEquals(expectedTicketPrice[i-1], actualTicketPrice, "Information is incorrect");
        }
        Assert.assertEquals(actualMsg, expectedMsg, "The ticket information is incorrect");

    }
}
