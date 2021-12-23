import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookticketPage extends GeneralPage {
    //Locator
    @FindBy(xpath = "//h1[contains(text(),'Book ticket')]")
    public WebElement titelBookticket;
    @FindBy(xpath = "//select[@name='Date']")
    public WebElement cbdepartDate;
    @FindBy(xpath = "//select[@name='Date']/descendant::option[@value='6']")
    public WebElement departDate;
    @FindBy(xpath = "//select[@name='DepartStation']")
    public WebElement cbDepartFrom;
    @FindBy(xpath = "//select[@name='DepartStation']/descendant::option[@value='1']")
    public WebElement departFrom;
    @FindBy(xpath = "//select[@name='ArriveStation']")
    public WebElement cbArriveAt;
    @FindBy(xpath = "//select[@name='ArriveStation']/descendant::option[@value='4']")
    public WebElement arriveAt;
    @FindBy(xpath = "//select[@name='SeatType']")
    public WebElement cbSeattype;
    @FindBy(xpath = "//select[@name='SeatType']/descendant::option[@value='1']")
    public WebElement seatType;
    @FindBy(xpath = "//select[@name='TicketAmount']")
    public WebElement cbTicketAmout;
    @FindBy(xpath = "//select[@name='TicketAmount']/descendant::option[@value='1']")
    public WebElement ticketAmout;
    @FindBy(xpath = "//input[@value='Book ticket']")
    public WebElement btnBookTicket;
    @FindBy(xpath = "//h1[normalize-space()='Ticket Booked Successfully!']")
    public WebElement bookSucess;
    @FindBy(xpath = "//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)]")
    public WebElement actualDeStation;
    @FindBy(xpath = "//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1]")
    public WebElement actualArStation;
    @FindBy(xpath = "//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)+2]")
    public WebElement actualSeattype;
    @FindBy(xpath = "//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)+3]")
    public WebElement actualDepartDate;
    @FindBy(xpath = "//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)+6]")
    public WebElement actualAmout;
    public String getTextBookticket() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        return this.titelBookticket.getText();
    }

    public HomePage BookTicket() {
        Constant.scrollIntoview();
        PageFactory.initElements(Constant.WEBDRIVER,this);
        cbdepartDate.click();
        departDate.click();
        cbDepartFrom.click();
        departFrom.click();
        cbArriveAt.click();
        arriveAt.click();
        cbSeattype.click();
        seatType.click();
        cbTicketAmout.click();
        ticketAmout.click();
        btnBookTicket.click();
        return new HomePage();
    }
    public String getBookSucess(){
        PageFactory.initElements(Constant.WEBDRIVER,this);
        return this.bookSucess.getText();
    }
    public String getDepartStation(){
        PageFactory.initElements(Constant.WEBDRIVER,this);
        return this.actualDeStation.getText();
    }
    public String getArrStation(){
        PageFactory.initElements(Constant.WEBDRIVER,this);
        return this.actualArStation.getText();
    }
    public String getSeatType(){
        PageFactory.initElements(Constant.WEBDRIVER,this);
        return this.actualSeattype.getText();
    }
    public String getDepartDate(){
        PageFactory.initElements(Constant.WEBDRIVER,this);
        return this.actualDepartDate.getText();
    }
    public String getAmount(){
        PageFactory.initElements(Constant.WEBDRIVER,this);
        return this.actualAmout.getText();
    }
}
