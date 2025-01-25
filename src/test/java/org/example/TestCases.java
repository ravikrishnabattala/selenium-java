package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCases {

    private static final Logger logger = LoggerFactory.getLogger(TestCases.class);
    private static WebDriver driver;

    @BeforeAll
    public static void start() {
        logger.info("WebDriver Loaded");
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("latest");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        Duration duration = Duration.of(2, ChronoUnit.SECONDS);
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("hhtps");
//        options.setProxy(proxy);
        options.setScriptTimeout(duration);
        driver = new ChromeDriver(options);
        driver.getWindowHandle();
        ((JavascriptExecutor) driver).executeScript("window.open();");
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
//        ((JavascriptExecutor) driver).executeScript("window.open('', '_blank', 'width=800,height=600');");
        MDC.put("testCaseId", (String) testInfo.getTags().toArray()[0]);
    }

    @Test
    @Tags(value = {@Tag("1234"), @Tag("5678"), @Tag("9101")})
    public void function() throws InterruptedException {
        driver.get("https://www.google.com");
        logger.info("error becuase of wait");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q"))); // Wait for search box to be present
        logger.error("Search box found after wait");
        String str = driver.getTitle();
        logger.info(str);
        logger.debug("title equal :");
        logger.warn("warn");
        logger.trace(str);
        By ele = RelativeLocator.with(By.className("s")).near(By.className("s"));
        assertEquals(str, "Google");
    }

    @Test
    @Tags(value = {@Tag("12345"), @Tag("5678"), @Tag("9101")})
    public void function1() throws InterruptedException {
        driver.get("https://www.facebook.com");
        logger.info("error becuase of wait");
        String str = driver.getTitle();
        logger.info(str);
        logger.debug("title equal :");
        logger.warn("warn");
        logger.trace(str);
    }

    @AfterEach
    public void afterExecute() {
        MDC.clear();
        if(driver!=null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void stop() {
        logger.info("Wenb Driver Removed");
    }
}
