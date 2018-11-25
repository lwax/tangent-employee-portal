package za.co.tangentsolutions.controller;

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
import za.co.tangentsolutions.Application;
import za.co.tangentsolutions.model.Employee;
import za.co.tangentsolutions.model.Position;
import za.co.tangentsolutions.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = WebEnvironment.DEFINED_PORT)

public class EmployeeControllerTest {

    private static final String API_ROOT = "http://localhost:8085/api/employee";

    @Test
    public void whenGetEmployees_thenOK() {
        Response response = RestAssured.get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Ignore
    @Test
    public void whenEmployeeById_thenOK() {

        Employee employee = createEmployee();
        String location = createEmployeeAsUri(employee);
        Response response = RestAssured.get(location);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(employee.getUser().getFirstName(),response.jsonPath().get("user"));

    }

    private Employee createEmployee() {
        return Employee.builder()
            .id(1L)
            .user(createUser())
            .position(createPosition())
            .phoneNumber("0828899987")
            .email("pravin@axedmps.co")
            .githubUser("PravG")
            .birthDate("1951-12-12")
            .gender("M")
            .race("B")
            .yearsWorked(2)
            .age(66)
            .daysToBirthday(69)
            .build();
    
    }

    private User createUser(){
        return User.builder()
            .id(12L)
            .username("pravin.gordhan")
            .email("pravin@axedmps.com")
            .firstName("Pravin")
            .lastName("Gordhan")
            .isActive(Boolean.TRUE)
            .isStaff(Boolean.TRUE)
            .build();
    }

    private Position createPosition(){
        return Position.builder()
                .id(3L)
                .name("Project Manager")
                .level("Senior")
                .sort(0)
                .build();
    }

    private String createEmployeeAsUri(Employee employee) {
        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(employee)
                .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }

}