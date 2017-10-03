package pl.grabinski.springwebcispike;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;

public class HelloTest {

    @Test
    public void checkWelcomePageContent() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("localhost:8080");
        assertEquals("hello Bob!", driver.findElement(By.tagName("body")).getText());

        driver.quit();
    }
}
