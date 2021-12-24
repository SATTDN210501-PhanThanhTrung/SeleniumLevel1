import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookticketPage extends GeneralPage {

    public final By lblBookticket = By.xpath("//h1[contains(text(),'Book ticket')]");
    public final By cbodepartDate = By.xpath("//select[@name='Date']");
    public final By dblDepartDate = By.xpath("//select[@name='Date']/descendant::option[@value='6']");
    public final By cboDepartFrom = By.xpath("//select[@name='DepartStation']");
    public final By dblDepartFrom = By.xpath("//select[@name='DepartStation']/descendant::option[@value='1']");
    public final By cboArriveAt = By.xpath("//select[@name='ArriveStation']");
    public final By dblArriveAt = By.xpath("//select[@name='ArriveStation']/descendant::option[@value='4']");
    public final By cboSeattype = By.xpath("//select[@name='SeatType']");
    public final By dblSeatType = By.xpath("//select[@name='SeatType']/descendant::option[@value='1']");
    public final By cboTicketAmount = By.xpath("//select[@name='TicketAmount']");
    public final By dblTicketAmount = By.xpath("//select[@name='TicketAmount']/descendant::option[@value='1']");
    public final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    public final By lblBookTicketSuccessfully = By.xpath("//h1[normalize-space()='Ticket Booked Successfully!']");
    public final By dgdDepartStation = By.xpath("//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)]");
    public final By dgdArriveStation = By.xpath("//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1]");
    public final By dgdSeatType = By.xpath("//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)+2]");
    public final By dgdDepartDate = By.xpath("//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)+3]");
    public final By dgdAmount = By.xpath("//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)+6]");


    public WebElement getLabelBookticket() {
        return Constant.WEBDRIVER.findElement(lblBookticket);
    }

    public WebElement getComboboxDepartDate() {
        return Constant.WEBDRIVER.findElement(cbodepartDate);
    }

    public WebElement getComboboxDepartSattion() {
        return Constant.WEBDRIVER.findElement(cboDepartFrom);
    }

    public WebElement getComboboxArriveStation() {
        return Constant.WEBDRIVER.findElement(cboArriveAt);
    }

    public WebElement getComboboxSeatType() {
        return Constant.WEBDRIVER.findElement(cboSeattype);
    }

    public WebElement getComboboxTicketAmount() {
        return Constant.WEBDRIVER.findElement(cboTicketAmount);
    }

    public WebElement getDatalistDepartDate() {
        return Constant.WEBDRIVER.findElement(dblDepartDate);
    }

    public WebElement getDatalistDepartStation() {
        return Constant.WEBDRIVER.findElement(dblDepartFrom);
    }

    public WebElement getDatalistArriveStation() {
        return Constant.WEBDRIVER.findElement(dblArriveAt);
    }

    public WebElement getDatalistSeatType() {
        return Constant.WEBDRIVER.findElement(dblSeatType);
    }

    public WebElement getDatalistTicketAmount() {
        return Constant.WEBDRIVER.findElement(dblTicketAmount);
    }

    public WebElement getLabelBookedSuccessFully() {
        return Constant.WEBDRIVER.findElement(lblBookTicketSuccessfully);
    }

    public WebElement getDataGridArriveStation() {
        return Constant.WEBDRIVER.findElement(dgdArriveStation);
    }

    public WebElement getDataGridDepartDate() {
        return Constant.WEBDRIVER.findElement(dgdDepartDate);
    }

    public WebElement getDataGridSeatType() {
        return Constant.WEBDRIVER.findElement(dgdSeatType);
    }

    public WebElement getDataGridTicketAmount() {
        return Constant.WEBDRIVER.findElement(dgdAmount);
    }

    public WebElement getDataGridDepartStation() {
        return Constant.WEBDRIVER.findElement(dgdDepartStation);
    }

    public WebElement getButtonBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    public void BookTicket() {
        Constant.scrollIntoview();
        this.getComboboxDepartDate().click();
        this.getDatalistDepartDate().click();
        this.getComboboxDepartSattion().click();
        this.getDatalistDepartStation().click();
        this.getComboboxArriveStation().click();
        this.getDatalistArriveStation().click();
        this.getComboboxSeatType().click();
        this.getDatalistSeatType().click();
        this.getComboboxTicketAmount().click();
        this.getDatalistTicketAmount().click();
    }

    public String getBookticketTitle() {
        return this.getLabelBookticket().getText();
    }

    public String getBookSucessfullyTitle() {
        return this.getLabelBookedSuccessFully().getText();
    }

    public String getTextOfDataListlDepartStation() {
        return this.getDatalistDepartStation().getText();
    }

    public String getTextOfDataListArrStation() {
        return this.getDatalistArriveStation().getText();
    }

    public String getTextOfDataListSeatType() {
        return this.getDatalistSeatType().getText();
    }

    public String getTextOfDataListDepartDate() {
        return this.getDatalistDepartDate().getText();
    }

    public String getTextOfDataListAmount() {
        return this.getDatalistTicketAmount().getText();
    }

    public void clickBtnBookTicket() {
        this.getButtonBookTicket().click();
    }

    public String getDepartStationDataOfTicket() {
        return this.getDataGridDepartStation().getText();
    }

    public String getArrStationDataOfTicket() {
        return this.getDataGridArriveStation().getText();
    }

    public String getSeatTypeDataOfTicket() {
        return this.getDataGridSeatType().getText();
    }

    public String getDepartDateDataOfTicket() {
        return this.getDataGridDepartDate().getText();
    }

    public String getAmountDataOfTicket() {
        return this.getDataGridTicketAmount().getText();
    }
}
