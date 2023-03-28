package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    /*
    in this class we will be able to pass pre -post conditions
    to each scenario and each step

     */
    // import from io.cucumber.java not from junit
    @Before
    public void setupScenario(){
        System.out.println("=== Setting up browser using cucumber @Before");


    }
    @After
    public void teardownScenario(Scenario scenario){

        if(scenario.isFailed()){

            byte[] screenshot=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png",scenario.getName());


        }






        Driver.closeDriver();
        // System.out.println("====Closing browser unsing cucumber @After");
        //System.out.println("====Scenario ended/ take screenshot if failed");


    }
    @BeforeStep
    public void setupStep(){
        System.out.println("----- applying setup using @BeforeStep");


    }

    @AfterStep
    public void afterStep(){
        System.out.println("--------->applying tearDown using @AfterStep");
    }


}
