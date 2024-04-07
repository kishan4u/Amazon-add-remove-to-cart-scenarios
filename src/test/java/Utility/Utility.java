package Utility;

import StepDefinations.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class Utility extends BaseClass {



    public WebDriver driver;
    public Utility(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


 // Method for mouse hover and click using action class
    public void _mouseOverAndClick(WebElement element) {
        Actions action = new Actions(BaseClass.driver);
        action.moveToElement(element).click().build().perform();
    }


    //Method to scroll to the element to make it visible on screen to take action
    public void _scrollToElement(WebElement element) {
        Coordinates cor = ((Locatable)element).getCoordinates();
        cor.inViewPort();
    }


    // Method to assert the text or alerts messages
    public void validateText(String expectedText, String actualText){

        Assert.assertEquals(expectedText,actualText);
    }

    // Method to click on element in case unable to click
    public void javaScriptClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public void SwitchToWindow(WebDriver driver)  {
        try {
            String parent_wh1 = driver.getWindowHandle();
            Set<String> all_wh1 = driver.getWindowHandles();
            for (String wh1 : all_wh1) {
                driver.switchTo().window(wh1);
                if (wh1.equals(parent_wh1)) {
                } else {
                    driver.switchTo().window(wh1);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
