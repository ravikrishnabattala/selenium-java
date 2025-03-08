package org.example;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class PlaywrightTest {

    private static Page page = null;
    private static final Logger logger = LoggerFactory.getLogger(PlaywrightTest.class);

    @BeforeAll
    public static void intializeBrowsers(){
        HooksTest.initiateBrowsers();
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        new HooksTest().setUp(testInfo);
    }

    @AfterEach
    public void allClear(){
        new HooksTest().afterExecute();
    }

    @AfterAll
    public static void tearDown(){
        HooksTest.shutDownBrowsers();
    }

    public PlaywrightTest() {
        page = new HooksTest().getPage();
        if (page == null) {
            throw new RuntimeException("Page is not initialized!");
        }
    }

    //    @Description("Locator for Google Search Box")
    private Locator getSearchBox() {
        return page.locator("textarea[name='q']");
    }

    //    @Description("Locator for Google Search Button")
    private Locator getSearchButton() {
        return page.locator("input[name='btnK']");
    }

    @Test
    @DisplayName("It is a playwright test case")
    @Given("Run playwright test case")
    public void testing() {
        page.navigate("https://www.google.com/");
        randomDelay();

        getSearchBox().fill("ravikrishnabattala.netlify.app");
        getSearchBox().press("Enter");
        randomDelay();

        page.locator("h3").first();
        randomDelay(); // Add a random delay

        // Check for CAPTCHA
        logger.info("google browsing...");
        if (page.locator("text=Please show you're not a robot").isVisible()) {
            System.out.println("CAPTCHA detected. Manual intervention required.");
        }
    }

    public void randomDelay() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000) + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
