package ModernTestsV2;

import base.Base1;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;

public class ModernTestsV2 extends Base1 {

    @Test(priority = 1)
    public void crossDeviceElementsTest() {
        Configuration testConfig = eyes.getConfiguration();
        testConfig.setTestName("Task 1");
        eyes.setConfiguration(testConfig);
        driver = eyes.open(driver);
        driver.get(v2URL);
        eyes.check(Target.window().fully().withName("Cross-Device Elements Test"));
    }

    @Test(priority = 2)
    public void shoppingExperienceTest() {
        Configuration testConfig = eyes.getConfiguration();
        testConfig.setTestName("Task 2");
        eyes.setConfiguration(testConfig);
        driver = eyes.open(driver);
        driver.get(v2URL);
        homePage.clickFilterIcon();
        homePage.clickFilterBlackShoeCheckbox();
        homePage.clickFilterButton();
        homePage.waitForProductGridToBePresent();
        eyes.check("Filter Results", Target.region(homePage.productGrid));

    }

    @Test(priority = 3)
    public void productDetailsTest() {
        Configuration testConfig = eyes.getConfiguration();
        testConfig.setTestName("Task 3");
        eyes.setConfiguration(testConfig);
        driver = eyes.open(driver);
        driver.get(v2URL);
        homePage.clickFilterIcon();
        homePage.clickFilterBlackShoeCheckbox();
        homePage.clickFilterButton();
        homePage.clickFirstShoeInFilter();
        eyes.check(Target.window().fully().withName("Product Details test"));

    }

}