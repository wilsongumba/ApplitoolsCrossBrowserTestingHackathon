package ModernTestsV1;

import base.Base1;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;

public class ModernTestsV1 extends Base1 {

    @Test
    public void crossDeviceElementsTest() {
        Configuration testConfig = eyes.getConfiguration();
        testConfig.setTestName("Task 1");
        eyes.setConfiguration(testConfig);
        driver = eyes.open(driver);
        driver.get(v1URL);
        eyes.check(Target.window().fully().withName("Cross-Device Elements Test"));
    }

    @Test
    public void shoppingExperienceTest() {
        Configuration testConfig = eyes.getConfiguration();
        testConfig.setTestName("Task 2");
        eyes.setConfiguration(testConfig);
        driver = eyes.open(driver);
        driver.get(v1URL);
        homePage.clickFilterIcon();
        homePage.clickFilterBlackShoeCheckbox();
        homePage.clickFilterButton();
        homePage.waitForProductGridToBePresent();
        eyes.check("Filter Results", Target.region(homePage.productGrid));

    }

    @Test
    public void productDetailsTest() {
        Configuration testConfig = eyes.getConfiguration();
        testConfig.setTestName("Task 3");
        eyes.setConfiguration(testConfig);
        driver = eyes.open(driver);
        driver.get(v1URL);
        homePage.clickFilterIcon();
        homePage.clickFilterBlackShoeCheckbox();
        homePage.clickFilterButton();
        homePage.clickFirstShoeInFilter();
        eyes.check(Target.window().fully().withName("Product Details test"));

    }

}