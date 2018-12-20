package test.modules;

import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import static test.supports.CommonFunctions.*;

public class SignIn {
    @Test
    public void signIn(){
        setBrowser("chr");
        visit("http://testapp.galenframework.com/");
        click(How.XPATH,"//button[text()='Login']");

        click(How.XPATH,"//input[@name='login.username']");
        click(How.XPATH,"//input[@name='login.password']");
        fill(How.NAME,"login.username","testuser@example.com");
        fill(How.NAME,"login.password","test123");

        click(How.XPATH,"//button[text()='Login']");

        click(How.XPATH,"//button[text()='Add note']");

        fill(How.NAME,"note.title","test");
        fill(How.NAME,"note.description","add new note");

        click(How.XPATH,"//button[text()='Add Note']");


    }
}
