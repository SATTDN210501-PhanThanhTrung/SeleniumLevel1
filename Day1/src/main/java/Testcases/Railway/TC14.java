import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends Before {
    @Test
    public void TC14() {
        System.out.println("User can book many tickets at a time");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        BookticketPage bookticketPage = homePage.gotoBookticet();
        bookticketPage.BookTicket();
        String actualMsg=bookticketPage.getBookSucess();
        String expectedMsg="Ticket Booked Successfully!";
        String actualDepartStation=bookticketPage.getDepartStation();
        String expectedDepartStation="Sài Gòn";
        String actualArStation=bookticketPage.getArrStation();
        String expectedArStation="Đà Nẵng";
        String actualSeatType=bookticketPage.getSeatType();
        String expectedSeatType="Hard seat";
        String actualDepartDate=bookticketPage.getDepartDate();
        String expectedDepartDate="12/29/2021";
        String actualAmout=bookticketPage.getAmount();
        String expectedAmout="1";
        Assert.assertEquals(actualMsg,expectedMsg,"Book tickets failed");
        Assert.assertEquals(actualDepartStation,expectedDepartStation,"DepartStations are not same");
        Assert.assertEquals(actualArStation,expectedArStation,"ArriveStaions are not same");
        Assert.assertEquals(actualSeatType,expectedSeatType,"SeatTypes are not same");
        Assert.assertEquals(actualDepartDate,expectedDepartDate,"DepartDate not same");
        Assert.assertEquals(actualAmout,expectedAmout,"Amout not same");
    }
}
