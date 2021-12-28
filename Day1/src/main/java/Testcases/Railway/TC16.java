import Common.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC16 extends TestBase {
    @Test(description = "User can cancel the bookes ticket")
    public void TC16() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        MyTicket myTicket = new MyTicket();
        System.out.println("1.Navigate to Railway web");
        homePage.open();
        System.out.println("2.Go to Login Page.");
        homePage.gotoLoginPage();
        System.out.println("3.Enters valid Email and Password");
        System.out.println("4.Click on Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        System.out.println("5.Go to My ticket Page");
        loginPage.gotoMyTicket();
        List<WebElement> beforeCancel = myTicket.getrowsOfCancelButton();
        System.out.println("6. Click Cancel button on your ticket");
        myTicket.clickCancelButton();
        Thread.sleep(1000);
        System.out.println("7. Accept cancel");
        Alert alt = Constant.WEBDRIVER.switchTo().alert();
        alt.accept();
        List<WebElement> afterCancel = myTicket.getrowsOfCancelButton();
        Assert.assertTrue(beforeCancel.size() - afterCancel.size() == 1, "Cancellation of the booked ticket failed");
    }
}
