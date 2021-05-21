package scenarios;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.ExecutionListener;

@Listeners(ExecutionListener.class)
public class SampleTest2 {

    @Test(description = "login")
    public void login(){

    }

    @Test(description = "search for flights", dependsOnMethods = "login")
    public void search(){
        Assert.fail("issue with flight");
    }

    @Test(description = "select flight", dependsOnMethods = "search")
    public void select(){
    	Assert.fail("select flights");
    }

    @Test(description = "book flight", dependsOnMethods = "select")
    public void book(){

    }

    @Test(description = "logout", dependsOnMethods = "book")
    public void logout(){

    }
}