package Pages;

import Base.TestBase;
import dev.failsafe.internal.util.Assert;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Util.TestUtil.waitAndClick;

public class CreateNewPolicyPage extends TestBase {

    String Country = "Austria";
    String MobileDevice = "Iphone20";
    private static final Logger logger = LogManager.getLogger(CreateNewPolicyPage.class);

    public CreateNewPolicyPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='country-select']")
    WebElement CountryDropdown;

   String CountryDropdownOptions = "//li[@role='option']/span[text()='%s']";


    @FindBy(xpath = "//div[@id='product-name-select']")
    WebElement ProductName;

    @FindBy(xpath = "//li[@role='option' and text()='Nokia_v1Allianz_global']")
    WebElement ProductDropdownOptions;

    @FindBy(xpath = "//div[@id='tariff-name-select']")
    WebElement TariffDropdown;

    @FindBy(xpath = "//li[@role='option' and text()='1-34-Nokia_v1Allianz_global-D-EUR-v1-Accidental_damage']")
    WebElement TariffDropdownOptions;
    @FindBy(xpath = "//div[@id='category-name-select']")
    WebElement CategoryNameDropdown;

    String CategoryNameDropdownOptions = "//li[@role='option' and text()='%s']";

    @FindBy(xpath = "//div[@id='duration-select']")
    WebElement DurationDropdown;

    @FindBy(xpath = "//li[@role='option' and text()='12 month(s)']")
    WebElement DurationOptions;

    @FindBy(xpath = "//div[@id='frequency-select']")
    WebElement PaymentTypeDropdown ;

    @FindBy(xpath = "//li[@role='option']/span[text()='One-time']")
    WebElement PaymentTypeDropdownOptions;

    @FindBy(xpath = "//div[@id='class-name-select']")
    WebElement ClassDropdown;


    @FindBy(xpath = "//li[@role='option' and text()='Nokia 3/500 - EUR 500.00']")
    WebElement ClassOptions;

    @FindBy(xpath = "//input[@id='input-createCertificate_serialNumber']")
    WebElement SerialNumberTextField ;

    @FindBy(xpath = "//input[@id='input-createCertificate_deviceName']")
    WebElement DeviceNameTextField;
    @FindBy(xpath = "//input[@id='input-createCertificate_invoiceNumber']")
    WebElement InvoiceNumberTextField;

    @FindBy(xpath = "//input[@id='input-createCertificate_orderNumber']")
    WebElement  OrderNumberTextField;

    @FindBy(xpath = "//button[contains(@class,'MuiButtonBase')]/span[text()='Next']")
    WebElement NextButton;

    @FindBy(xpath = "//input[@value=\"female\"]")
    WebElement SalutationMrsRadioButton ;

    @FindBy(xpath = "//input[@value=\"male\"]")
    WebElement SalutationMrRadioButton;

    @FindBy(xpath = "//input[@value=\"diverse\"]")
    WebElement SalutationDiverseRadioButton;

    @FindBy(xpath = "//input[@id='input-createCertificate_firstName']")
    WebElement FirstNameTextField;

    @FindBy(xpath = "//input[@id='input-createCertificate_lastName']")
    WebElement LastNameTextField;

    @FindBy(xpath = "//input[@id='input-createCertificate_email']")
    WebElement EmailTextField;

    @FindBy(xpath = "//input[@id='input-createCertificate_streetName']")
    WebElement StreetTextField;

    @FindBy(xpath = "//input[@id='input-createCertificate_streetNumber']")
    WebElement HouseNumTextField;

    @FindBy(xpath = "//input[@id='input-createCertificate_zip']")
    WebElement PostalCodeTextField;

    @FindBy(xpath = " //input[@id='input-createCertificate_city']")
    WebElement CityTextField;

    @FindBy(xpath = "//input[@id='input-createCertificate_country']")
    WebElement CountryTextField ;

    @FindBy(xpath = "//input[@id='input-createCertificate_taxCode']")
    WebElement TaxCode;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-item')]//input[@type='checkbox']")
    List<WebElement> ConditionsCheckBox;

    @FindBy(xpath = "//button[contains(@class,'MuiButtonBase')]/span[text()='Create insurance']\n")
    WebElement CreateInsuranceButton;


    public void CreateNewPolicy(String Product_Code, String Category,String customer_email, String customer_salutation, String customer_first_name,
                                String customer_last_name, String customer_street, String customer_street_number, String customer_zip, String customer_city, String customer_country,
                                String identifiers_0_serialNumber, String identifiers_0_name, String identifiers_0_orderNumber, String identifiers_0_invoiceNumber ) throws InterruptedException
    {
        ListOfPoliciesPage listpageObj = new ListOfPoliciesPage();
        listpageObj.clickOnNewButton();
        waitAndClick(CountryDropdown,10);
        driver.findElement(By.xpath(String.format(CountryDropdownOptions,Country))).click();
        logger.info("Selected Country");

        waitAndClick(ProductName,10);
        waitAndClick(ProductDropdownOptions,10);
        logger.info("Selected ProductName");


        waitAndClick(TariffDropdown,10);
        waitAndClick(TariffDropdownOptions,10);
        logger.info("Selected TariffDropdown");

        waitAndClick(CategoryNameDropdown,10);
        driver.findElement(By.xpath(String.format(CategoryNameDropdownOptions, Category))).click();
        logger.info("Selected Category");

        waitAndClick(DurationDropdown,10);
        waitAndClick(DurationOptions,10);
        logger.info("Selected Duration");

        waitAndClick(PaymentTypeDropdown,10);
        waitAndClick(PaymentTypeDropdownOptions,10);
        logger.info("Selected payment Method");

        waitAndClick(ClassDropdown,10);
        waitAndClick(ClassOptions,10);
        logger.info("Selected Class");

        SerialNumberTextField.sendKeys(identifiers_0_serialNumber);
        DeviceNameTextField.sendKeys(MobileDevice);
        logger.info("Entered mobile device name");
        InvoiceNumberTextField.sendKeys(identifiers_0_invoiceNumber);
        OrderNumberTextField.sendKeys(identifiers_0_orderNumber);
        waitAndClick(NextButton,10);
        logger.info("Switching to next page");
        if(customer_salutation == "2") {
            SalutationMrRadioButton.click();
            logger.info("Enabled Mr Radio Button");
        }
        else if(customer_salutation == "3") {
            SalutationDiverseRadioButton.click();
            logger.info("Enabled diverse Radio Button");
        }
        FirstNameTextField.sendKeys(customer_first_name);
        LastNameTextField.sendKeys(customer_last_name);
        EmailTextField.sendKeys(customer_email);
        StreetTextField.sendKeys(customer_street);
        HouseNumTextField.sendKeys(customer_street_number);
        PostalCodeTextField.sendKeys(customer_zip);
        CityTextField.sendKeys(customer_city);
        CountryTextField.sendKeys(customer_country);
        TaxCode.sendKeys("Tax123");
        waitAndClick(NextButton,10);
        for(int i=0; i<ConditionsCheckBox.size();i++)
        {
          ConditionsCheckBox.get(i).click();
        }
        waitAndClick(CreateInsuranceButton,10);
        logger.info("clicking on create insurance button ");
        PaymentsPage PaymentObj =new PaymentsPage();
        PaymentObj.PaymentTest();
    }
}
