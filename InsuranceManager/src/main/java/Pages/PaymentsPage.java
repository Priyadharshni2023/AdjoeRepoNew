package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import static Util.TestUtil.waitAndClick;

public class PaymentsPage extends TestBase {

    public PaymentsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Kreditkarte / Debitkarte']")
    WebElement CreditDebitCardRadioButton;

    @FindBy(xpath = "//span[@class='MuiButton-label']")
    WebElement ContinuePaymentButton;

    @FindBy(xpath = "//input[@name='cardnumber']")
    WebElement CardNumberInputField;

    @FindBy(xpath = "//input[@placeholder='MM/JJ']")
    WebElement ExpDateInputField;

    @FindBy(xpath = "//input[@placeholder='Prüfziffer']")
    WebElement cvvInputField;

    @FindBy(xpath = "//span[normalize-space()='Kostenpflichtig bestellen']")
    WebElement PayButton;

    @FindBy(xpath = "//iframe[@role='presentation' and starts-with(@name,'__privateStripeFrame')]")
    WebElement iframe;

    @FindBy(xpath = "//div[contains(@class,'MuiTypography')] //span[text()='Created']")
    WebElement CreatedStatusText;

    public void PaymentTest() throws InterruptedException {

        CreditDebitCardRadioButton.click();
        waitAndClick(ContinuePaymentButton,10);
        driver.switchTo().frame(iframe);
        CardNumberInputField.sendKeys("4242424242424242");
        ExpDateInputField.sendKeys("02/29");
        cvvInputField.sendKeys("342");
        driver.switchTo().defaultContent();
        waitAndClick(PayButton,10);
        Assert.assertTrue(CreatedStatusText.isDisplayed());

    }
}
