package Util;

import Base.TestBase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;


    public static void waitAndClick(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static Object[][] getData() throws IOException, IOException, CsvException {

        String csvFile = System.getProperty("user.dir")+ "/src/main/resources/TestData/testdata.csv";
        CSVReader reader = new CSVReader(new FileReader(csvFile));
        List<String[]> csvData = reader.readAll();
        csvData.remove(0);
        reader.close();
        Object[][] data = new Object[csvData.size()][];
        for (int i = 0; i < csvData.size(); i++) {
            data[i] = csvData.get(i);
        }
        return data;
    }
}
