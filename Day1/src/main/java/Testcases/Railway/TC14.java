import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC14 extends TestBase {
    @Test(description = "User can book many tickets at a time",dataProvider = "dataProvider")
    public void TC14(String departFrom,String arriveAt,String seatType,String amount) throws InterruptedException {
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

        String actualMsg = bookticketPage.getBookSucessfullyTitle();
        String expectedMsg = "Ticket Booked Successfully!";

        String actualDepartStation = bookticketPage.getDataOfTicket("Depart Station");
        String expectedDepartStation = departFrom;

        String actualArStation = bookticketPage.getDataOfTicket("Arrive Station");
        String expectedArStation = arriveAt;

        String actualSeatType = bookticketPage.getDataOfTicket("Seat Type");
        String expectedSeatType = seatType;

        String actualDepartDate = bookticketPage.getDataOfTicket("Depart Date");
        String expectedDepartDate = Utilities.DepartDate();

        String actualAmout = bookticketPage.getDataOfTicket("Amount");
        String expectedAmout = amount;

        Assert.assertEquals(actualMsg, expectedMsg, "Book tickets failed");
        Assert.assertEquals(actualDepartStation, expectedDepartStation, "DepartStation is not same");
        Assert.assertEquals(actualArStation, expectedArStation, "ArriveStaion is not same");
        Assert.assertEquals(actualSeatType, expectedSeatType, "SeatType is not same");
        Assert.assertEquals(actualDepartDate, expectedDepartDate, "DepartDate is not same");
        Assert.assertEquals(actualAmout, expectedAmout, "Amount is not same");
    }
    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "\\src\\main\\java\\DataObject\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC14 = jsonObject.getAsJsonObject("TC14");
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
