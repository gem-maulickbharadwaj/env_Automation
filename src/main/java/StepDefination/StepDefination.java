package StepDefination;

import com.gemini.generic.reporting.GemEcoUpload;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.gemini.generic.utils.GemJarGlobalVar;
import com.gemini.generic.utils.ProjectConfigData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

import Objects.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Objects.Locators.*;

public class StepDefination extends GemEcoUpload {
    Logger logger = LoggerFactory.getLogger(StepDefination.class);


    @Given("^validate super-admin is not present$")
    public void superAdminIsPresent() throws Exception {
        try {
            global2();
            List<WebElement> buttons = DriverManager.getWebDriver().findElements(By.xpath("//div[@class=\"icon-text col-md-9 col-sm-12 text-md-start text-center\"]"));
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).getText().contains("Super Admin")) {
                    GemTestReporter.addTestStep("Super Admin isDisplayed?", "Super Admin is Displayed", STATUS.FAIL, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Super Admin isDisplayed?", "Super Admin is not Displayed", STATUS.PASS, DriverAction.takeSnapShot());
                }
            }
            Map<String, String> envVars = System.getenv();
            for (String key : envVars.keySet()) {
                String value = envVars.get(key);
                System.out.println(key + " = " + value);
                GemTestReporter.addTestStep("env variables", key + " = " + value, STATUS.INFO);
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
//        GemTestReporter.addTestStep("exception","Exception",STATUS.INFO);
    }


    public void global2() throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.click(Locators.logIn, "Log In");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.username, "Username");
            DriverAction.waitSec(1);
            DriverAction.typeText(Locators.username, "geco-maulick");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.passwordm, "Password");
            DriverAction.waitSec(1);
            DriverAction.typeText(Locators.passwordm, "Avani0001");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.LoginButton, "LogIn Button");
            DriverAction.waitSec(6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}