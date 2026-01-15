package com.ministryoftesting.E2E;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    @Test
    public void testPageUpdatesToProjectPageAfterLogin() {

        //Arrange
        WebDriverManager.chromedriver().setup();//downloads the necessary driver library that connects our code with browser

        //WebDriver driver = new ChromeDriver(); //instantiate a new ChromeDriver object

        ChromeOptions options = new ChromeOptions();//we are still using chrome browser but it will run in the background without opening a visible window
        options.addArguments("--headless");//headless mode. headless mode allows tests to run faster and consume fewer resources since there is no need to render the browser's graphical user interface.
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://localhost:8080"); //navigate to the URL of the application

        //Act
        driver.findElement(By.name("email")).sendKeys("admin@test.com");//find the email input field by its name attribute and enter the email address
        driver.findElement(By.name("password")).sendKeys("password123");//find the password input field by its name attribute and enter the password
        driver.findElement(By.cssSelector("button")).click();//find the button element using a CSS selector and click it to submit the form

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//create a WebDriverWait object to wait for a maximum of 10 seconds for a specific condition to be met
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title")));//wait until an element

        //Assert
        String title = driver.findElement(By.cssSelector(".card-title")).getText();//get the text of the element with the class name "card-title"
        assertEquals("Projects", title);// Assert that the title of the project page is "Projects"

        driver.close();
        driver.quit();

    }
}
