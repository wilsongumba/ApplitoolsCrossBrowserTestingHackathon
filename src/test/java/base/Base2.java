package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Base2 {

    public String browserName;
    public String viewport;
    public String device;
    protected String v1URL = "https://demo.applitools.com/gridHackathonV1.html";
    protected String  v2URL = "https://demo.applitools.com/gridHackathonV2.html";

    protected WebDriver driver;
    protected HomePage homePage;
    private Dimension dimension;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void launchBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            setBrowserViewportLaptopSize();
            browserName = "chrome";
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            setBrowserViewportLaptopSize();
            browserName = "firefox";
        } else if (browser.equalsIgnoreCase("edgechromium")) {
            System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
            driver = new EdgeDriver();
            setBrowserViewportLaptopSize();
            browserName = "edge";
        } else if (browser.equalsIgnoreCase("chrome-tablet")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            setBrowserViewportTabletSize();
            browserName = "chrome";
        } else if (browser.equalsIgnoreCase("firefox-tablet")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            setBrowserViewportTabletSize();
            browserName = "firefox";
        } else if (browser.equalsIgnoreCase("edgechromium-tablet")) {
            System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
            driver = new EdgeDriver();
            setBrowserViewportTabletSize();
            browserName = "edge";
        } else if (browser.equalsIgnoreCase("chrome-iphonex")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            setBrowserViewportMobileSize();
            browserName = "chrome";
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }



    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Output/FailedScreenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = Base2.getScreenshot(driver, result.getName());
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            System.out.println(screenshotPath);
        }
        driver.quit();
    }



    public void setBrowserViewportLaptopSize() {
        dimension = new Dimension(1200, 700);
        driver.manage().window().setSize(dimension);
        viewport = "1200 x 700";
        device = "Laptop";
    }

    public void setBrowserViewportTabletSize() {
        dimension = new Dimension(768, 700);
        driver.manage().window().setSize(dimension);
        viewport = "768 x 700";
        device = "Tablet";
    }

    public void setBrowserViewportMobileSize() {
        dimension = new Dimension(500, 700);
        driver.manage().window().setSize(dimension);
        viewport = "500 x 700";
        device = "Mobile";
    }

    /**
     * @param task
     * @param testName
     * @param domId
     * @param comparisonResult
     */

    public boolean hackathonReporterV1(int task, String testName, String domId, boolean comparisonResult) {
        try(var writer = new BufferedWriter(new FileWriter("Traditional-V1-TestResults.txt", true))){
            writer.write("Task: " + task + ", Test Name: " + testName +", DOM Id: " + domId + ", Browser: " + browserName
                    + ", Viewport: " + viewport + ", Device: " + device + ", Status: " + (comparisonResult ? "Pass" : "Fail"));
            writer.newLine();
        }catch(Exception e){
            System.out.println("Error writing to report file");
            e.printStackTrace();
        }
        //returns the result so that it can be used for further Assertions in the test code.
        return comparisonResult;
    }


    /**
     * @param task
     * @param testName
     * @param domId
     * @param comparisonResult
     */
    public boolean hackathonReporterV2(int task, String testName, String domId, boolean comparisonResult) {
        try(var writer = new BufferedWriter(new FileWriter("Traditional-V2-TestResults.txt", true))){
            writer.write("Task: " + task + ", Test Name: " + testName +", DOM Id: " + domId + ", Browser: " + browserName
                    + ", Viewport: " + viewport + ", Device: " + device + ", Status: " + (comparisonResult ? "Pass" : "Fail"));
            writer.newLine();
        }catch(Exception e){
            System.out.println("Error writing to report file");
            e.printStackTrace();
        }
        //returns the result so that it can be used for further Assertions in the test code.
        return comparisonResult;
    }
}