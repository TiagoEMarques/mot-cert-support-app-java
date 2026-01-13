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
public class LoginApiTest {

@Test
    public void testCheckLoginReturnsPositiveResult() {

        //Arrange
        AuthPayLoad authPayLoad = new AuthPayLoad("admin@test.com", "password123");

        //Act

        Response response = given()//Given  brings in rest-assured library that we will access t create and send our request
                .body(authPayLoad)// where we pass the authPayLoad object we created above
                .contentType("application/json")//as we are sending JSON object we have to add in a Content-Type header
                .post("http://localhost:8080/v1/auth/login");// We send a post request to specify the URL we want to send it to

        //Assert
        assertEquals(200, response.getStatusCode()); // Assert that the status code is 200


    }


}
