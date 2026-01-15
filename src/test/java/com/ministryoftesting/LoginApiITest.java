package com.ministryoftesting;

import static io.restassured.RestAssured.given;

import com.ministryoftesting.api.TimesheetManagerApplication;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = TimesheetManagerApplication.class)
@ActiveProfiles("dev")
public class LoginApiITest {

@Test
    public void testCheckLoginReturnsPositiveResult() {
        //Arrange
        AuthPayLoad authPayLoad = new AuthPayLoad("admin@test.com", "password123");
        //Act
        Response response = given()
                .body(authPayLoad)
                .contentType("application/json")
                .post("http://localhost:8080/v1/auth/login");
        //Assert
        assertEquals(200, response.getStatusCode());
    }
}

