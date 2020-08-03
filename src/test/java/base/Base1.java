package base;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class Base1 {

    //strings used
    private String applitoolsEyesServer = "https://eyes.applitools.com/";
    String appName = "AppliFashion";
    public String v1URL = "https://demo.applitools.com/gridHackathonV1.html";
    public String v2URL = "https://demo.applitools.com/gridHackathonV2.html";
    private String batchName = "UFG Hackathon";
    private String eyesAPIKey = "wSWUyAz8qvPfIYdeRnp9Hbm6lVVGbPOb6gNcfrgotok110";


    private EyesRunner runner = null;
    private Configuration testConfig;
    protected Eyes eyes;
    protected WebDriver driver;

    protected HomePage homePage;



    @BeforeSuite
    public void setUp() {
        runner = new VisualGridRunner(10);
        testConfig = (Configuration) new Configuration()

                //laptop browsers viewports(1200 x 700)
                .addBrowser(1200, 700, BrowserType.CHROME)
                .addBrowser(1200, 700, BrowserType.FIREFOX)
                .addBrowser(1200, 700, BrowserType.EDGE_CHROMIUM)

                //tablet browsers viewports(768 x 700)
                .addBrowser(768, 700, BrowserType.CHROME)
                .addBrowser(768, 700, BrowserType.FIREFOX)
                .addBrowser(768, 700, BrowserType.EDGE_CHROMIUM)

                //mobile viewport(500 x 700)
                .addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT)

                .setViewportSize(new RectangleSize(800, 600))
                .setApiKey(eyesAPIKey)
                .setServerUrl(applitoolsEyesServer)
                .setAppName(appName)
                .setBatch(new BatchInfo(batchName));
    }

    @BeforeMethod
    public void launchApplication() {
        eyes = new Eyes(runner);
        eyes.setConfiguration(testConfig);
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        boolean testFailed = result.getStatus() == ITestResult.FAILURE;
        if (!testFailed) {
            eyes.closeAsync();
        } else {
            eyes.abortAsync();
        }
        driver.quit();

    }

    @AfterSuite
    public void processResults() {

        // we pass false to this method to suppress the exception that is thrown if we
        // find visual differences
        TestResultsSummary allTestResults = runner.getAllTestResults(false);
        System.out.println(allTestResults);
    }


}