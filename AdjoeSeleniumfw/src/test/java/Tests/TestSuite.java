package Tests;

import Base.TestBase;
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
    public void setup() {
        initialization();
        LoginPage loginPageObject = new LoginPage();
        loginPageObject.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @DataProvider(name = "csvData")
    public Object[][] getTestData() throws IOException, CsvException {
        Object[][] data;
        data = TestUtil.getData();
        return data;
    }
    
    @Test
    public void CreateNewTest() {
    }





    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }




}
