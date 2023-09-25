package com.qa;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGtest2 {
    private RemoteWebDriver driver;
    private String Status = "failed";

    public TestNGtest2() {
    }

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = ""; //pass your username here
        String authkey = ""; //pass your accesskey here
        String hub = "@hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("platform", "Windows 11");
        ltOptions.put("version", "latest");
        ltOptions.put("selenium_version", "4.11.0");

        //passing chrome options within lt:options
        String[] args = {"--user-agent=QA-Automation/985.25.77"};
        HashMap<String, Object> op = new HashMap<>();
        op.put("args",args);
        ltOptions.put("goog:chromeOptions",op);
        ltOptions.put("build", "Build Name");
        ltOptions.put("w3c", true);
        browserOptions.addArguments("--user-agent=QA-Automation/985.25.77");
        browserOptions.setCapability("LT:Options", ltOptions);
        this.driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + "@hub.lambdatest.com/wd/hub"), browserOptions);
        String[] var10000 = new String[]{"Feature"};
    }

    @Test
    public void basicTest() throws InterruptedException {
        System.out.println("Loading Url");
        Thread.sleep(10000L);
        System.out.println(driver.getSessionId());
        this.driver.get("https://lambdatest.github.io/sample-todo-app/");
        Thread.sleep(10000L);
        System.out.println("Checking Box");
        this.driver.executeScript("return navigator.userAgent", new Object[0]);
        this.Status = "passed";
        Thread.sleep(150L);
        System.out.println("TestFinished");
    }

    @AfterMethod
    public void tearDown() {
        this.driver.executeScript("lambda-status=" + this.Status, new Object[0]);
        this.driver.quit();
    }
}














