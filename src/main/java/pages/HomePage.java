package pages;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private Eyes eyes;

    private By filterIcon = By.id("ti-filter");
    private By blackShoesCheckbox = By.id("SPAN__checkmark__107");
    private By filterButton = By.id("filterBtn");
    public By productGrid = By.id("product_grid");
    public By firstFilterShoe = By.xpath(".//h3[text()='Appli Air x Night']");
    public By secondFilterShoe = By.xpath(".//h3[text()='Appli Air 720']");




    //elements to assert

    //home page
    public String filter_icon = "LI____205";
    public String filter = "LI____206";
    public String heart_shuffle_cart_shoe1 = "UL____222";
    public String heart_shuffle_cart_shoe2 = "UL____247";
    public String heart_shuffle_cart_shoe3 = "UL____269";
    public String heart_shuffle_cart_shoe4 = "UL____291";
    public String heart_shuffle_cart_shoe5 = "UL____313";
    public String heart_shuffle_cart_shoe6 = "UL____335";
    public String heart_shuffle_cart_shoe7 = "UL____357";
    public String heart_shuffle_cart_shoe8 = "UL____382";
    public String heart_shuffle_cart_shoe9 = "UL____404";


    //filter results
    public String product_grid = "product_grid";
    public String filterResultsShoe1 = ".//h3[text()='Appli Air x Night']";
    public String filterResultsShoe2 = ".//h3[text()='Appli Air 720']";
    public String filterResultsShoe1heart_shuffle_cart_shoe1 = "UL____222";
    public String filterResultsShoe2heart_shuffle_cart_shoe2 = "UL____244";
    //check not present
    public String filterResultsWhiteShoe = "DIV__griditem__259";

    public HomePage(WebDriver driver){
        this.driver = driver;
        eyes = new Eyes();
    }

    public void clickFilterBlackShoeCheckbox(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(blackShoesCheckbox));
        driver.findElement(blackShoesCheckbox).click();
    }

    public boolean clickFilterIcon() {
        boolean result = false;
        try {
            driver.findElement(filterIcon).click();
            result = false;
        } catch (NoSuchElementException e) {
            result = true;
        } catch (ElementNotInteractableException e) {
            result = true;
        }

        finally
        {
            // close
        }
        return result;
    }


    public void clickFilterButton(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(filterButton));
        driver.findElement(filterButton).click();
    }

    public ProductDetailsPage clickFirstShoeInFilter(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(firstFilterShoe));
        driver.findElement(firstFilterShoe).click();
        return new ProductDetailsPage(driver);
    }

    public void waitForProductGridToBePresent(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(productGrid));
    }




    //for CrossDevice Elements Test
    public boolean checkFilterIconPresent(){
        boolean result = false;
        try {
            driver.findElement(By.id(filter_icon)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkFilterPresent(){
        boolean result = false;
        try {
            driver.findElement(By.id(filter)).isDisplayed();
            result = false;
        } catch (NoSuchElementException e) {
            result = true;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkHeartShuffleCartIconsForShoe1Present(){
        boolean result = false;
        try {
            driver.findElement(By.id(heart_shuffle_cart_shoe1)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkHeartShuffleCartIconsForShoe2Present(){
        boolean result = false;
        try {
            driver.findElement(By.id(heart_shuffle_cart_shoe2)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkHeartShuffleCartIconsForShoe3Present(){
        boolean result = false;
        try {
            driver.findElement(By.id(heart_shuffle_cart_shoe3)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkHeartShuffleCartIconsForShoe4Present(){
        boolean result = false;
        try {
            driver.findElement(By.id(heart_shuffle_cart_shoe4)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkHeartShuffleCartIconsForShoe5Present(){
        boolean result = false;
        try {
            driver.findElement(By.id(heart_shuffle_cart_shoe5)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkHeartShuffleCartIconsForShoe6Present(){
        boolean result = false;
        try {
            driver.findElement(By.id(heart_shuffle_cart_shoe6)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkHeartShuffleCartIconsForShoe7Present(){
        boolean result = false;
        try {
            driver.findElement(By.id(heart_shuffle_cart_shoe7)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkHeartShuffleCartIconsForShoe8Present(){
        boolean result = false;
        try {
            driver.findElement(By.id(heart_shuffle_cart_shoe8)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkHeartShuffleCartIconsForShoe9Present(){
        boolean result = false;
        try {
            driver.findElement(By.id(heart_shuffle_cart_shoe9)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }





    //for shopping experience tests
    public boolean checkProductGridPresent(){
        boolean result = false;
        try {
            driver.findElement(By.id(product_grid)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkFilterResultShoe1Present(){
        boolean result = false;
        try {
            driver.findElement(By.xpath(filterResultsShoe1)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkFilterResultShoe2Present(){
        boolean result = false;
        try {
            driver.findElement(By.xpath(filterResultsShoe2)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkFilterResultShoe1Heart_shuffle_cart_shoe1Present(){
        boolean result = false;
        try {
            driver.findElement(By.id(filterResultsShoe1heart_shuffle_cart_shoe1)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkFilterResultShoe1Heart_shuffle_cart_shoe2Present(){
        boolean result = false;
        try {
            driver.findElement(By.id(filterResultsShoe2heart_shuffle_cart_shoe2)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkFilterResultWhiteShoeNotPresent(){
        boolean result = false;
        try {
            driver.findElement(By.id(filterResultsWhiteShoe)).isDisplayed();
            result = false;
        } catch (NoSuchElementException e) {
            result = true;
        }
        finally
        {
            // close
        }
        return result;
    }

    //elements to assert
    //product details
    public String product_serial = "SMALL____84";
    public String shoe_image = "shoe_img";


    public boolean checkProductSerialPresent(){
        boolean result = false;
        try {
            driver.findElement(By.id(product_serial)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }

    public boolean checkShoeImagePresent(){
        boolean result = false;
        try {
            driver.findElement(By.id(shoe_image)).isDisplayed();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        finally
        {
            // close
        }
        return result;
    }


}