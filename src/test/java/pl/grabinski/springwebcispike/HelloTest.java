package pl.grabinski.springwebcispike;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.junit.Assert.*;

public class HelloTest {

    @Test
    public void checkWelcomePageContent() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("google-chrome-stable");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-debugging-port=9222");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:8080"), capabilities);

        driver.navigate().to("localhost:8080");
        assertEquals("hello Bob!", driver.findElement(By.tagName("body")).getText());

        driver.quit();
    }
}
