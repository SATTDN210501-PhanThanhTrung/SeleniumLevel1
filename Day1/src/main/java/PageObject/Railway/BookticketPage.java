import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookticketPage extends GeneralPage {

    public final By lblBookticket = By.xpath("//h1[contains(text(),'Book ticket')]");
    public final By cbodepartDate = By.name("Date");
    public final By cboDepartFrom = By.name("DepartStation");
    public final By cboArriveAt = By.name("ArriveStation");
    public final By cboSeattype = By.name("SeatType");
    public final By cboTicketAmount = By.name("TicketAmount");
    public final By btnBookTicket = By.tagName("input");
    public final By lblBookTicketSuccessfully = By.tagName("h1");
    public final String dgdTicket = "//tbody/tr[@class='OddRow']/td[count(//th[text()='%s']/preceding-sibling::th)+1]";
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

    public WebElement getDataGrid(String title) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dgdTicket, title)));
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

    public String getDataOfTicket(String title) {
        return this.getDataGrid(title).getText();
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
