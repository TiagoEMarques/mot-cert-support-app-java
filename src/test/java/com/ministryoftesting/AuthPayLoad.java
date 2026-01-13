package com.ministryoftesting;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthPayLoad {
//Declare the variables for the class that match the key names in the JSON payload
    @JsonProperty
    private String email;
    @JsonProperty
    private String password;

//constructor to pass an email and password parameters taht will be stored in the object
    public AuthPayLoad(String email, String password) {
        this.email = email;
        this.password = password;
    }

/* when the HTTP request is sent, our tooling will convert this class into a JSON object. To allow our tooling to do that,
we need to provide ‘getter’ methods. So that the tooling can extract the values we provided. */
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
