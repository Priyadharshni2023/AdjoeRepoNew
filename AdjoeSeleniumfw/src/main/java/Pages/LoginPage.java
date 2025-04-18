package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Util.TestUtil.waitAndClick;

public class LoginPage extends TestBase {
    public LoginPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@class,'MuiIconButton')]")
    WebElement languageButton;

    @FindBy(xpath = "//span[text()='Englisch']")
    WebElement englishLanguage;

    @FindBy(xpath = "//input[@id='login_username']")
    WebElement userNameInput;

    @FindBy(xpath = "//input[@id='login_password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    public void login(String un, String pwd) {

        waitAndClick(languageButton,10);
        waitAndClick(englishLanguage,10);
        userNameInput.sendKeys(un);
        passwordInput.sendKeys(pwd);
        waitAndClick(loginBtn,10);
    }
}
