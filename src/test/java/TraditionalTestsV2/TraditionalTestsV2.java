package TraditionalTestsV2;

import base.Base2;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.HomePage;

public class TraditionalTestsV2 extends Base2 {


    @Test
    public void crossDeviceElementsTest() {
        driver.get(v2URL);
        HomePage homepage = homePage;
        SoftAssertions softAssertions = new SoftAssertions();

        //Report and then soft-assert
        softAssertions.assertThat(hackathonReporterV2(1, "Filter icon is displayed", homepage.filter_icon, homepage.checkFilterIconPresent()));
        softAssertions.assertThat(hackathonReporterV2(1, "Filter is not displayed", homepage.filter, homepage.checkFilterPresent()));
        softAssertions.assertThat(hackathonReporterV2(1, "Heart_Shuffle_Cart_ForShoe1 displayed", homepage.heart_shuffle_cart_shoe1, homepage.checkHeartShuffleCartIconsForShoe1Present()));
        softAssertions.assertThat(hackathonReporterV2(1, "Heart_Shuffle_Cart_ForShoe2 displayed", homepage.heart_shuffle_cart_shoe2, homepage.checkHeartShuffleCartIconsForShoe2Present()));
        softAssertions.assertThat(hackathonReporterV2(1, "Heart_Shuffle_Cart_ForShoe3 displayed", homepage.heart_shuffle_cart_shoe3, homepage.checkHeartShuffleCartIconsForShoe3Present()));
        softAssertions.assertThat(hackathonReporterV2(1, "Heart_Shuffle_Cart_ForShoe4 displayed", homepage.heart_shuffle_cart_shoe4, homepage.checkHeartShuffleCartIconsForShoe4Present()));
        softAssertions.assertThat(hackathonReporterV2(1, "Heart_Shuffle_Cart_ForShoe5 displayed", homepage.heart_shuffle_cart_shoe5, homepage.checkHeartShuffleCartIconsForShoe5Present()));
        softAssertions.assertThat(hackathonReporterV2(1, "Heart_Shuffle_Cart_ForShoe6 displayed", homepage.heart_shuffle_cart_shoe6, homepage.checkHeartShuffleCartIconsForShoe6Present()));
        softAssertions.assertThat(hackathonReporterV2(1, "Heart_Shuffle_Cart_ForShoe7 displayed", homepage.heart_shuffle_cart_shoe7, homepage.checkHeartShuffleCartIconsForShoe7Present()));
        softAssertions.assertThat(hackathonReporterV2(1, "Heart_Shuffle_Cart_ForShoe8 displayed", homepage.heart_shuffle_cart_shoe8, homepage.checkHeartShuffleCartIconsForShoe8Present()));
        softAssertions.assertThat(hackathonReporterV2(1, "Heart_Shuffle_Cart_ForShoe9 displayed", homepage.heart_shuffle_cart_shoe9, homepage.checkHeartShuffleCartIconsForShoe9Present()));

        //Assert all elements inside this test
        softAssertions.assertAll();
    }

    @Test
    public void shoppingExperienceTest() {
        driver.get(v2URL);
        HomePage homepage = homePage;
        homePage.clickFilterIcon();
        homePage.clickFilterBlackShoeCheckbox();
        homePage.clickFilterButton();
        homePage.waitForProductGridToBePresent();

        SoftAssertions softAssertions = new SoftAssertions();

        //Report and then soft-assert
        softAssertions.assertThat(hackathonReporterV2(2, "Product Grid is present", homepage.product_grid, homepage.checkProductGridPresent()));
        softAssertions.assertThat(hackathonReporterV2(2, "Filter Result Black Shoe 1 displayed", homepage.filterResultsShoe1, homepage.checkFilterResultShoe1Present()));
        softAssertions.assertThat(hackathonReporterV2(2, "Filter Result Black Shoe 2 displayed", homepage.filterResultsShoe2, homepage.checkFilterResultShoe2Present()));
        softAssertions.assertThat(hackathonReporterV2(2, "Filter Result White Shoe not displayed", homepage.filterResultsWhiteShoe, homepage.checkFilterResultWhiteShoeNotPresent()));
        softAssertions.assertThat(hackathonReporterV2(2, "Filter Result Heart_Shuffle_Cart_ForShoe1 displayed", homepage.filterResultsShoe1heart_shuffle_cart_shoe1, homepage.checkFilterResultShoe1Heart_shuffle_cart_shoe1Present()));
        softAssertions.assertThat(hackathonReporterV2(2, "Filter Result Heart_Shuffle_Cart_ForShoe2 displayed", homepage.filterResultsShoe2heart_shuffle_cart_shoe2, homepage.checkFilterResultShoe1Heart_shuffle_cart_shoe2Present()));
        //Assert all elements inside this test
        softAssertions.assertAll();
    }


    @Test
    public void productDetailsTest() {
        driver.get(v2URL);
        HomePage homepage = homePage;
        homePage.clickFilterIcon();
        homePage.clickFilterBlackShoeCheckbox();
        homePage.clickFilterButton();
        homePage.clickFirstShoeInFilter();

        SoftAssertions softAssertions = new SoftAssertions();

        //Report and then soft-assert
        softAssertions.assertThat(hackathonReporterV2(3, "Product serial number is displayed", homePage.product_serial, homePage.checkProductSerialPresent()));
        softAssertions.assertThat(hackathonReporterV2(3, "Product Image is displayed", homePage.shoe_image, homePage.checkShoeImagePresent()));

        //Assert all elements inside this test
        softAssertions.assertAll();

    }
}