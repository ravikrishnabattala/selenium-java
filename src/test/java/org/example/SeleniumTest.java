package org.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SeleniumTest extends Hooks {

    private static final Logger logger = LoggerFactory.getLogger(SeleniumTest.class);
    private static WebDriver driver = null;

    @Test
    @Tags(value = {@Tag("1234"), @Tag("5678"), @Tag("9101")})
    public void function() throws InterruptedException {
        driver = getDriver();
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
        driver = getDriver();
        driver.get("https://www.facebook.com");
        logger.info("error becuase of wait");
        String str = driver.getTitle();
        logger.info(str);
        logger.debug("title equal :");
        logger.warn("warn");
        logger.trace(str);
    }

}
