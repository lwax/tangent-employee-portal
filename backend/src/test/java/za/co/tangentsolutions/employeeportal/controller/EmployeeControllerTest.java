package za.co.tangentsolutions.employeeportal.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import za.co.tangentsolutions.employeeportal.EmployeePortalApplication;
import za.co.tangentsolutions.employeeportal.payloads.RequestPayload;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { EmployeePortalApplication.class }, webEnvironment = WebEnvironment.DEFINED_PORT)

public class EmployeeControllerTest {

    private static final String API_ROOT = "http://localhost:8085/api/employee";


    @Ignore
    @Test
    public void whenGetEmployees_thenOK() {
        Response response = RestAssured.get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Ignore
    @Test
    public void whenUsernamePassword_thenOK() {



        RequestPayload requestPayload = new RequestPayload();
        requestPayload.setUsername("test");
        requestPayload.setPassword("password");
        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(requestPayload)
         .post(API_ROOT+ "/login");

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals("1", response.jsonPath().get("token"));

    }


}