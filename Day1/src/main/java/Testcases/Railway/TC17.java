import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC17 extends TestBase {
    @Test(description = "User can't book more than 10 tickets", dataProvider = "dataProvider")
    public void TC17(String departFrom, String arriveAt, String seatType, String amount, String amount2) throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookticketPage = new BookticketPage();
        RegisterPage registerPage = new RegisterPage();

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
        bookticketPage.selectDepartDate(Utilities.DepartDate());

        System.out.println("7.Select Depart from");
        bookticketPage.selectDepartFrom(departFrom);
        Thread.sleep(1000);

        System.out.println("8. Select Arrive at");
        bookticketPage.selectArriveAt(arriveAt);

        System.out.println("9.Select Seat type");
        bookticketPage.selectSeatType(seatType);

        System.out.println("10.Select Ticket amount");
        bookticketPage.selectTicketAmount(amount);

        System.out.println("11.Click on Book ticket button");
        bookticketPage.clickBtnBookTicket();

        System.out.println("12.Go back Bookticket Page");
        bookticketPage.gotoBookticet();

        System.out.println("13.Select all infotmation again");
        bookticketPage.selectDepartDate(Utilities.DepartDate());
        bookticketPage.selectDepartFrom(departFrom);
        Thread.sleep(1000);
        bookticketPage.selectArriveAt(arriveAt);
        bookticketPage.selectSeatType(seatType);
        bookticketPage.selectTicketAmount(amount2);
        bookticketPage.clickBtnBookTicket();

        String actualMsg = bookticketPage.getTextErrorBookTicketMsg();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        String actualMsg2 = bookticketPage.getTextErrorTicketAmountMsg();
        String expectedMsg2 = "You have booked 10 tickets. You can book no more.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsg2, expectedMsg2, "Error message is not displayed as expected");

    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "\\src\\main\\java\\DataObject\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonObject.getAsJsonObject("TC17");
        String departStation1 = dataTC17.get("DepartFrom").getAsString();
        String arriveStation1 = dataTC17.get("ArriveAt").getAsString();
        String seatType1 = dataTC17.get("SeatType").getAsString();
        String amount = dataTC17.get("TicketAmount").getAsString();
        String amount2 = dataTC17.get("TicketAmount2").getAsString();

        Object[][] object = new Object[][]{
                {departStation1, arriveStation1, seatType1, amount, amount2}
        };

        return object;
    }
}