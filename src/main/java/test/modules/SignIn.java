package test.modules;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static test.supports.CommonFunctions.*;

public class SignIn {

    @BeforeClass
    public void Before() {
        System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testapp.galenframework.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC01_SignIn() throws InterruptedException {

        click(How.XPATH, "//button[text()='Login']");

        fill(How.NAME, "login.username", "testuser@example.com");
        fill(How.NAME, "login.password", "test123");

        click(How.XPATH, "//button[text()='Login']");
}

    @Test
    public void TC02_AddNote() throws InterruptedException {
        click(How.XPATH, "//button[text()='Add note']");
        fill(How.NAME, "note.title", "test");
        fill(How.NAME, "note.description", "add new note");

        click(How.XPATH, "//button[text()='Add Note']");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
