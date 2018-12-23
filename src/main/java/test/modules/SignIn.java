package test.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.supports.CommonFunctions.*;

public class SignIn {
    String noteTitle = "test";
    String noteDescription = "add new note";

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

        Assert.assertTrue(isElementDisplayed(How.XPATH, "//div[@id='my-notes-page']"));
    }

    @Test
    public void TC02_AddNote() throws InterruptedException {
        click(How.XPATH, "//button[text()='Add note']");
        fill(How.NAME, "note.title", noteTitle);
        fill(How.NAME, "note.description", noteDescription);

        click(How.XPATH, "//button[text()='Add Note']");

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='list-group']/a"));
        int listSize = list.size();
        List<WebElement> titles = driver.findElements(By.xpath("//h4[@class='list-group-item-heading']"));
        List<WebElement> descriptions = driver.findElements(By.xpath("//p[@class='list-group-item-text']"));

        if (titles.get(listSize - 1).getText().equals(noteTitle) && descriptions.get(listSize - 1).getText().equals(noteDescription)) {
            System.out.println("Add note successfully");
        }
        System.out.println("Fail at Add Note");
    }


    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
