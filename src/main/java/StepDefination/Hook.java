package StepDefination;

import com.gemini.generic.exception.GemException;
import com.gemini.generic.reporting.GemEcoUpload;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.gemini.generic.utils.GemJarGlobalVar;
import com.gemini.generic.utils.GemJarUtils;
import io.cucumber.java.Before;
import com.gemini.generic.reporting.GemTestReporter.*;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;
import java.util.logging.Logger;

public class Hook {
    @Before
    public static void hook() throws GemException {
        DriverManager.setUpBrowser();
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
//        DriverManager.initializeChrome(options);
//        DriverAction.launchUrl(GemJarUtils.getGemJarConfigData("launchUrl"));
//        DriverAction.setImplicitTimeOut(Long.parseLong(GemJarGlobalVar.implicitTime));
//        DriverAction.setPageLoadTimeOut(Long.parseLong(GemJarGlobalVar.pageTimeout));
//        DriverAction.setScriptTimeOut(Long.parseLong(GemJarGlobalVar.scriptTimeout));
    }

    @BeforeAll
    public static void hook2() throws GemException {
        Map<String, String> envVars = System.getenv();
        for (String key : envVars.keySet()) {
            String value = envVars.get(key);
            System.out.println(key + " = " + value);
//            GemTestReporter.addTestStep("env variables", key + " = " + value, STATUS.INFO);
        }
    }

    private final static Logger logger = Logger.getLogger(String.valueOf(GemEcoUpload.class));
}
