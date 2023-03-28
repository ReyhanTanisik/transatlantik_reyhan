package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    public static void sleep(int second){
        second *=1000;
        try{
            Thread.sleep(second);

        }catch( InterruptedException e){

        }
    }


    public static void switchWindowAndVerify( String expectedInUrl, String expectedInTitle){
        Set<String > allWindowsHandles=Driver.getDriver().getWindowHandles();// we store here

        for (String each : allWindowsHandles) {
            Driver.getDriver().switchTo().window(each);

            System.out.println("Current Url: " + Driver.getDriver().getCurrentUrl());
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }



        }

        String actualTitle= Driver.getDriver().getTitle();


        Assert.assertTrue(actualTitle.contains(expectedInTitle));




    }

    /*
    this method accepts a string "expectedTitle " and asserts if it is true
     */

    public static void verifyTitle( String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);


    }
    //crating a utility method for explicit wait,so we don't have to repeat lines
    public static void waitForInvisibilityOf(WebElement webElement){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));

    }
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);

        //List of all ACTUAL month <options> as a web element
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        //List of all ACTUAL month <options> as a string
        List<String> actualOptionsAsString= new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }

        return  actualOptionsAsString;

    }


    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons) {

            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }

    public static void clickWithWait(By by, int timeOut){
        waitClickability(by,timeOut);
        Driver.getDriver().findElement(by).click();
    }


    public static void waitClickability(By locator, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(locator)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
