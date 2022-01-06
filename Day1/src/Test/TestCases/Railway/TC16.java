package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.*;
import com.google.gson.JsonObject;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC16 extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookticketPage bookticketPage = new BookticketPage();
    RegisterPage registerPage = new RegisterPage();
    MyTicket myTicket=new MyTicket();

    @Test(description = "User can cancel the bookes ticket",dataProvider = "dataProvider")
    public void TC16(String departFrom,String arriveAt,String seatType,String amount) throws InterruptedException {

        System.out.println("Pre-Condition");
        homePage.open();
        homePage.gotoRegister();
        registerPage.register(Utilities.generateRandomEmail(), Constant.PASSWORD, Constant.PASSWORD, Utilities.generateRandomString());
        String useName = registerPage.getTextEmail().getAttribute("value");
        registerPage.clickRegisterButton();

        System.out.println("1.Go to RailWay web");
        System.out.println("2.Go to Login Page");
        homePage.gotoLoginPage();

        System.out.println("3.Enters valid Email and Password");
        System.out.println("4.Click on Login button");
        loginPage.login(useName, Constant.PASSWORD);

        System.out.println("5.Go to Book ticket Page");
        homePage.gotoBookticet();

        System.out.println("6.Select a Depart date from the list");
        bookticketPage.selectDepartDate(Utilities.getDayNextWeek());

        System.out.println("7.Select Depart from");
        bookticketPage.selectDepartFrom(departFrom);

        System.out.println("8.Select Arrive at");
        bookticketPage.selectArriveAt(arriveAt);

        System.out.println("9.Select Seat type");
        bookticketPage.selectSeatType(seatType);

        System.out.println("10.Select Ticket amount");
        bookticketPage.selectTicketAmount(amount);

        System.out.println("11.Click on Book ticket button");
        bookticketPage.clickBtnBookTicket();
        System.out.println("12.Go to My ticket Page");
        loginPage.gotoMyTicket();

        System.out.println("13.Click Cancel button on your ticket");
        String valueOfOnclick = myTicket.getButtonCancel().getAttribute("onclick");
        myTicket.clickCancelButton();

        System.out.println("14.Accept cancel");
        Alert alt = Constant.WEBDRIVER.switchTo().alert();
        alt.accept();

        Assert.assertTrue(myTicket.isCancelButtonDisappear() == true
                        || (myTicket.isCancelButtonDisappear() == false && valueOfOnclick != myTicket.getButtonCancel().getAttribute("onclick")),
                "Cancel button is not disappear");
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "\\src\\main\\java\\DataObject\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC14 = jsonObject.getAsJsonObject("TC16");
        String departStation1 = dataTC14.get("DepartFrom").getAsString();
        String arriveStation1 = dataTC14.get("ArriveAt").getAsString();
        String seatType1 = dataTC14.get("SeatType").getAsString();
        String amount = dataTC14.get("TicketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departStation1, arriveStation1, seatType1,amount}
        };

        return object;
    }
}
