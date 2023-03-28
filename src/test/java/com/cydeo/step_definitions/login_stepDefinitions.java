package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class login_stepDefinitions {



    LoginPage loginPage = new LoginPage();







    @When("user enters driver username")
    public void user_enters_driver_username() {

        loginPage.inputUsername.sendKeys("user1");

    }
    @When("user enters driver password")
    public void user_enters_driver_password() {

        loginPage.inputPassword.sendKeys("UserUser123");


        // Write code here that turns the phrase above into concrete actions

    }
    @Then("user should see the quick launchpad page")
    public void user_should_see_the_quick_launchpad_page() {

        BrowserUtils.sleep(1);
        String expectedText="Quick Launchpad";
        String actualText= loginPage.quickLaunchpadText.getText();
        System.out.println(actualText);
        Assert.assertEquals(expectedText,actualText);


    }

    @When("user enters sales manager username")
    public void user_enters_sales_manager_username() {


        loginPage.inputUsername.sendKeys("salesmanager101");
    }


    @When("user enters sales manager password")
    public void user_enters_sales_manager_password() {

        loginPage.inputPassword.sendKeys("UserUser123");


    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {


        String expectedText="Dashboard";
        String actualText= loginPage.dashboardText.getText();
        Assert.assertEquals(expectedText,actualText);






    }



    @When("user enters store manager username")
    public void user_enters_store_manager_username() {
        loginPage.inputUsername.sendKeys("storemanager51");


    }
    @When("user enters store manager password")
    public void user_enters_store_manager_password() {
        loginPage.inputPassword.sendKeys("UserUser123");


    }


    @And("user click to the login button")
    public void userClickToTheLoginButton() {

        loginPage.login.click();

    }

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get("https://qa.translantik.com");

    }
    @When("The user tries to login with {string} and {string}")
    public void the_user_tries_to_login_with_and(String string, String string2) {

        loginPage.inputUsername.sendKeys(string);
        loginPage.inputPassword.sendKeys(string2);
        loginPage.login.click();

    }
    @Then("Invalid username or password message should be displayed")
    public void invalid_username_or_password_message_should_be_displayed() {
        String actualMessage= loginPage.invalidUserNameMessage.getText();
        String expectedMessage="Invalid user name or password.";
        Assert.assertEquals(expectedMessage,actualMessage);




    }





    @When("The user clicks on login btn while username field is empty,and with any password")
    public void the_user_clicks_on_login_btn_while_username_field_is_empty_and_with_any_password() {
        loginPage.inputUsername.sendKeys("");
        loginPage.inputPassword.sendKeys("UserUser123");
        loginPage.login.click();
    }

    @Then("{string} message should be displayed in username field")
    public void message_should_be_displayed_in_field(String string) {

        BrowserUtils.sleep(1);
        if (loginPage.inputUsername.getAttribute("required").equals("required")) {
            Assert.assertEquals(loginPage.inputUsername.getAttribute("validationMessage"), string);
        }


    }


    @When("The user enters any username and click on login btn while password field is empty")
    public void the_user_enters_any_username_and_click_on_login_btn_while_password_field_is_empty() {

        loginPage.inputUsername.sendKeys("user1");
        loginPage.inputPassword.sendKeys("");
        loginPage.login.click();

    }

    @Then("{string} message should be displayed in password field")
    public void message_should_be_displayed_in_password_field(String string) {

        BrowserUtils.sleep(1);
        if (loginPage.inputPassword.getAttribute("required").equals("required")) {
            Assert.assertEquals(loginPage.inputPassword.getAttribute("validationMessage"), string);
        }

    }


    @When("user enters anything in the username and password field")
    public void user_enters_anything_in_the_username_and_password_field() {

        loginPage.inputUsername.sendKeys("");
        loginPage.inputPassword.sendKeys("");
        loginPage.login.click();
    }



    @When("The user enters anything into password field")
    public void the_user_enters_anything_into_password_field() {

        loginPage.inputUsername.sendKeys("user1");
        loginPage.inputPassword.sendKeys("UserUser123");



    }
    @Then("The password field must be seen in bullet sign")
    public void the_password_field_must_be_seen_in_bullet_sign() {

        Assert.assertEquals("password", loginPage.isBulletSign());


    }






    @Given("The user  see and clicks on RememberMe button")
    public void the_user_see_and_clicks_on_remember_me_button() {
        loginPage.rememberMeBtn.isDisplayed();
        loginPage.rememberMeBtn.click();
    }



    @When("The user enters username into username field")
    public void the_user_enters_username_into_username_field() {

        loginPage.inputUsername.sendKeys("user1");

    }
    @When("Hit the enter key on keyboard")
    public void hit_the_enter_key_on_keyboard() {
        loginPage.hitEnterKey();

    }
    @When("The user enters password into password field")
    public void the_user_enters_password_into_password_field() {
        loginPage.inputPassword.sendKeys("UserUser123");

    }
    @Then("The user is on the Quick Launchpad page")
    public void the_user_is_on_the_quick_launchpad_page() {

        BrowserUtils.sleep(10);
        String expectedText="Quick Launchpad";
        String actualText= loginPage.quickLaunchpadText.getText();
        System.out.println(actualText);
        Assert.assertEquals(expectedText,actualText);

    }



    @When("The user clicks on Forgot your password? link")
    public void the_user_clicks_on_forgot_your_password_link() {
        loginPage.forgotPasswordLink.click();



    }
    @Then("The user lands on the Forgot Password page")
    public void the_user_lands_on_the_forgot_password_page() {

        String expectedTitle="Forgot Password";
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());


    }


    @Then("The user can see his own username user1 in the profile menu")
    public void the_user_can_see_his_own_username_user1_in_the_profile_menu() {
        String username="user1";

        Assert.assertEquals(loginPage.profileMenu.getText(),username);
    }


    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get("https://qa.translantik.com");

    }
}


