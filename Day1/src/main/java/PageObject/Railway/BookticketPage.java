import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookticketPage extends GeneralPage {

    public final By lblBookticket = By.xpath("//h1[contains(text(),'Book ticket')]");
    public final By cbodepartDate = By.xpath("//select[@name='Date']");
    public final By cboDepartFrom = By.xpath("//select[@name='DepartStation']");
    public final By cboArriveAt = By.xpath("//select[@name='ArriveStation']");
    public final By cboSeattype = By.xpath("//select[@name='SeatType']");
    public final By cboTicketAmount = By.xpath("//select[@name='TicketAmount']");
    public final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    public final By lblBookTicketSuccessfully = By.xpath("//h1[normalize-space()='Ticket Booked Successfully!']");
    public final By dgdDepartStation = By.xpath("//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)]");
    public final By dgdArriveStation = By.xpath("//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1]");
    public final By dgdSeatType = By.xpath("//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)+2]");
    public final By dgdDepartDate = By.xpath("//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)+3]");
    public final By dgdAmount = By.xpath("//tbody/tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th)+6]");
    public final By lblErrorBookTicetMsg = By.xpath("//p[@class='message error']");
    public final By lblErrorTicketAmountMsg = By.xpath("//label[normalize-space()='You have booked 10 tickets. You can book no more.']");

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

    public WebElement getLabelErrorBookTicketMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorBookTicetMsg);
    }

    public WebElement getLabelErrorTicketAmountMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorTicketAmountMsg);
    }

    public String getBookticketTitle() {
        return this.getLabelBookticket().getText();
    }

    public String getBookSucessfullyTitle() {
        return this.getLabelBookedSuccessFully().getText();
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

    public void selectDepartDate(String option) {
        Select select = new Select(getComboboxDepartDate());
        select.selectByVisibleText(option);
    }

    public void selectDepartFrom(String option) {
        Select select = new Select(getComboboxDepartSattion());
        select.selectByVisibleText(option);
    }

    public void selectArriveAt(String option) {
        Select select = new Select(getComboboxArriveStation());
        select.selectByVisibleText(option);
    }

    public void selectSeatType(String option) {
        Select select = new Select(getComboboxSeatType());
        select.selectByVisibleText(option);
    }

    public void selectTicketAmount(String option) {
        Select select = new Select(getComboboxTicketAmount());
        select.selectByVisibleText(option);
    }

    public String getTextErrorBookTicketMsg() {
        return getLabelErrorBookTicketMsg().getText();
    }

    public String getTextErrorTicketAmountMsg() {
        return getLabelErrorTicketAmountMsg().getText();
    }
}
