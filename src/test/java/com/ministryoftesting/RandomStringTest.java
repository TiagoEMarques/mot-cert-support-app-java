package com.ministryoftesting;

import com.ministryoftesting.service.RandomString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomStringTest {

    @Test
    public void testRandomStringCanBeCreated() {
        //Arrange
        RandomString randomString = new RandomString(10); /* instantiate the only state we need for this test, which is
        a class that is being used inside the source code of the project. So we created a new RandomString object
         when called wil create a random string with length of 10.*/

        //Act
        String createdString = randomString.nextString(); // call the method nextString() to generate a random string.

        //Assert
        assertEquals(10, createdString.length()); // Assert that the length of the generated string is 10.



    }
}
