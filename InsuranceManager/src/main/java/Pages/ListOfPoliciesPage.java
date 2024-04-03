package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Util.TestUtil.waitAndClick;

public class ListOfPoliciesPage extends TestBase {
    public ListOfPoliciesPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/certificates']")
    WebElement ListMenu;

    @FindBy(xpath = "//a[@href='/policy/create']")
    WebElement NewButton;

    @FindBy(xpath = "//a[@href='/policy/import']")
    WebElement ImportButton;

    @FindBy(xpath = "//div[contains(@class,'MuiInputBase-input MuiInput')]")
    WebElement SearchBox;

    @FindBy(xpath = "//li[contains(@class,'MuiMenuItem-gutters')]//span[text()='Policy number']")
    WebElement SearchInput;

    @FindBy(xpath = "//input[contains(@class,'MuiSwitch-input ')]")
    WebElement Togglebutton;

    @FindBy(xpath = "//th[@data-sort='ACTIVATED_AT']//*[name()='svg']")
    WebElement PolicyNumberFilter;

    @FindBy(xpath = "//div[contains(@class,'MuiTablePagination-select')]")
    WebElement Pagination;

    @FindBy(xpath = "//ul[@id=':rc:']")
    WebElement PaginationValues;

    @FindBy(xpath = "//*[name()='svg' and @data-testid='FirstPageIcon']")
    WebElement PaginationFirstPage;

    @FindBy(xpath = "//*[name()='svg' and @data-testid='KeyboardArrowLeftIcon’]")
    WebElement PaginationMoveLeft;

    @FindBy(xpath = "//*[name()='svg' and @data-testid='KeyboardArrowRightIcon']")
    WebElement PaginationMoveRight;


    public void clickOnNewButton() throws InterruptedException {
        waitAndClick(NewButton,10);
    }

    public void clickOnListButton() throws InterruptedException {
        waitAndClick(ListMenu,10);
    }
}
