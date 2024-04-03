package Tests;

import Base.TestBase;
import Pages.CreateNewPolicyPage;
import Pages.LoginPage;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.*;
import Util.TestUtil;

import java.io.IOException;

public class TestSuite extends TestBase {



    public TestSuite(){
        super();

    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        LoginPage loginPageObject = new LoginPage();
        loginPageObject.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @DataProvider(name = "csvData")
    public Object[][] getTestData() throws IOException, CsvException {
        Object data1[][] = TestUtil.getData();
        return data1;
    }
    
    @Test(dataProvider = "csvData")
    public void CreateNewPolicyTest(String Product_Code, String Category,String customer_email, String customer_salutation, String customer_first_name,
                                    String customer_last_name, String customer_street, String customer_street_number,
                                    String customer_zip, String customer_city, String customer_country,
                                    String identifiers_0_serialNumber, String identifiers_0_name, String identifiers_0_orderNumber,
                                    String identifiers_0_invoiceNumber) throws InterruptedException {
       CreateNewPolicyPage newPolicyObject = new CreateNewPolicyPage();
       newPolicyObject.CreateNewPolicy( Product_Code, Category, customer_email,  customer_salutation,  customer_first_name, customer_last_name,  customer_street,  customer_street_number,  customer_zip, customer_city, customer_country,
                identifiers_0_serialNumber,  identifiers_0_name,  identifiers_0_orderNumber,  identifiers_0_invoiceNumber );
    }

    @Test(enabled = false)
    public void VerifyFilterAndSortoptions() throws InterruptedException {
        CreateNewPolicyPage newPolicyObject = new CreateNewPolicyPage();
        }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }





}
