package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "_username")
    public WebElement inputUsername;

    @FindBy(name = "_password")
    public WebElement inputPassword;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(xpath="//h1[text()='Quick Launchpad']")
    public WebElement quickLaunchpadText;


    @FindBy(xpath="//h1[@class='oro-subtitle']")
    public WebElement dashboardText;


    @FindBy(id="_submit")
    public WebElement login;


    @FindBy(xpath="//div[.='Invalid user name or password.']")
    public WebElement invalidUserNameMessage;



    @FindBy(xpath="//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeBtn;



    public String isBulletSign(){
        return inputPassword.getAttribute("type");
    }

    public void loginWithCredentials(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        login.click();
    }


    public void hitEnterKey(){
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
    }


    @FindBy(xpath="//a[@href='/user/reset-request']")
    public WebElement forgotPasswordLink;

    @FindBy(xpath="//a[@class='dropdown-toggle']")
    public WebElement profileMenu;
}
