package com.ministryoftesting;

import com.ministryoftesting.api.TimesheetManagerApplication;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.Duration;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = TimesheetManagerApplication.class)
@ActiveProfiles("dev")

public class LoginTest {

@Test
    public void testPageUpdatesToProjectPageAfterLogin(){

        //Arrange

        WebDriverManager.chromedriver().setup(); //setup chromedriver to use chrome browser and downloads the necessary driver library that connects our code with our browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");//we are still using chrome browser but it will run in the background without opening a visible window
        WebDriver driver = new ChromeDriver(options); //instantiate a new ChromeDriver object
        driver.get("http://localhost:8080"); //navigate to the URL of the application

        //Act

        driver.findElement(By.name("email")).sendKeys("admin@test.com");//find the email input field by its name attribute and enter the email address
        driver.findElement(By.name("password")).sendKeys("password123");//find the password input field by its name attribute and enter the password
        driver.findElement(By.cssSelector("button")).click();//find the button element using a CSS selector and click it to submit the form

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//create a WebDriverWait object to wait for a maximum of 10 seconds for a specific condition to be met
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title")));//wait until an element
        // with the class name "card-title" is visible on the page, indicating that the login was successful and the user has been redirected to the project page

        //Assert

        String title = driver.findElement(By.cssSelector(".card-title")).getText();
        assertEquals("Projects", title); // Assert that the title of the project page is "Projects")

        driver.close();
        driver.quit();


    }
}
