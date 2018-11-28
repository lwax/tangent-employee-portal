package za.co.tangentsolutions.employeeportal.services;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import za.co.tangentsolutions.employeeportal.EmployeePortalApplication;
import za.co.tangentsolutions.employeeportal.models.EmployeeDTO;
import za.co.tangentsolutions.employeeportal.models.PositionDTO;
import za.co.tangentsolutions.employeeportal.models.ReviewDTO;
import za.co.tangentsolutions.employeeportal.models.StatisticsDTO;
import za.co.tangentsolutions.employeeportal.models.UserDTO;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { EmployeePortalApplication.class }, webEnvironment = WebEnvironment.DEFINED_PORT)

public class EmployeePortalServiceTest {

    private EmployeePortalService employeePortalService = new EmployeePortalService();

    @Test
    public void shouldPopulateStatistics_whenGivenEmployeeAndReviewData(){

        StatisticsDTO statistics =  employeePortalService.populateStatistics(getEmployees(), getReviews());

        System.out.println("STATISTICS: " + statistics);

        assertEquals(4L, statistics.getNumOfEmployees().longValue());
        assertEquals(2L, statistics.getNumOfFemales().longValue());
        assertEquals(1L, statistics.getNumOfMales().longValue());
        assertEquals(1L, statistics.getNumOfUnknownGender().longValue());
        assertEquals(2L, statistics.getBirthdaysThisMonth().longValue());
    }





    private List<ReviewDTO> getReviews(){
        ReviewDTO review1 = createReview(9L, "2016-06-01", "100000.00", "S", 12, 4);
        ReviewDTO review2= createReview(13L, "2017-08-30", "120000.00", "P", 12, 3);

        return Arrays.asList(review1, review2);
    }


    private List<EmployeeDTO> getEmployees(){

        Map<String, Object> employee1 = new HashMap<>();
        employee1.put("user", createUser(1L, "Test1Username", "test1@email.com", "Test1FirstName","Test1LastName" ));
        employee1.put("position", createPosition(1L, "PostionName1", "Level1"));
        employee1.put("phoneNumber", "1234567890");
        employee1.put("email", "test1@email.com");
        employee1.put("githubUser", "githubUser1");
        employee1.put("birthDate", "1951-11-30");
        employee1.put("gender", "M");

        Map<String, Object> employee2 = new HashMap<>();
        employee2.put("user", createUser(2L, "Test2Username", "test2@email.com", "Test2FirstName","Test2LastName" ));
        employee2.put("position", createPosition(2L, "PostionName2", "Level2"));
        employee2.put("phoneNumber", "1234567892");
        employee2.put("email", "test2@email.com");
        employee2.put("githubUser", "githubUser2");
        employee2.put("birthDate", "1991-11-29");
        employee2.put("gender", "F");



        Map<String, Object> employee3 = new HashMap<>();
        employee3.put("user", createUser(3L, "Test3Username", "test3@email.com", "Test3FirstName","Test3LastName" ));
        employee3.put("position", createPosition(3L, "PostionName3", "Level3"));
        employee3.put("phoneNumber", "1234567893");
        employee3.put("email", "test3@email.com");
        employee3.put("githubUser", "githubUser3");
        employee3.put("birthDate", "1991-12-17");
        employee3.put("gender", "F");



        Map<String, Object> employee4 = new HashMap<>();
        employee4.put("user", createUser(2L, "Test4Username", "test4@email.com", "Test4FirstName", "Test4LastName"));
        employee4.put("position", createPosition(4L, "PostionName4", "Level4"));
        employee4.put("phoneNumber", "1234567894");
        employee4.put("email", "test4@email.com");
        employee4.put("githubUser", "githubUser4");
        employee4.put("birthDate", "1991-01-17");
        employee4.put("gender", null);

        return Arrays.asList(createEmployee(employee1), createEmployee(employee2), createEmployee(employee3),
                createEmployee(employee4));
    }

    private EmployeeDTO createEmployee(Map<String, Object> employeeData) {

        return EmployeeDTO.builder()
            .user((UserDTO)employeeData.get("user"))
            .position((PositionDTO)employeeData.get("position"))
            .phoneNumber(String.valueOf(employeeData.get("phoneNumber")))
            .email(String.valueOf(employeeData.get("email")))
            .githubUser(String.valueOf(employeeData.get("githubUser")))
            .birthDate(String.valueOf(employeeData.get("birthDate")))
            .gender(String.valueOf(employeeData.get("gender")))
            .race("B").yearsWorked(2).age(66).daysToBirthday(69).build();
    
    }

    private UserDTO createUser(Long id, String username, String email, String firstName, String lastName ){
        return UserDTO.builder()
            .id(id)
            .username(username)
            .email(email)
            .firstName(firstName)
            .lastName(lastName) 
            .isActive(Boolean.TRUE)
            .isStaff(Boolean.TRUE)
            .build();
    }

    private PositionDTO createPosition(Long id, String name, String level){
        return PositionDTO.builder()
                .id(id)
                .name(name )
                .level(level)
                .sort(0)
                .build();
    }

    private ReviewDTO createReview(Long id, String date, String salary,
                                String type, int employeeId, int positionId){
        return ReviewDTO.builder().
            id(id).date(date).salary(salary).type(type)
            .employeeId(employeeId).positionId(positionId).build();

    }

    // private String createEmployeeAsUri(Employee employee) {
    //     Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(employee)
    //             .post(API_ROOT);

    //             System.out.println("Create Employee As Uri Response: "+ response.asString());
    //     return API_ROOT + "/" + response.jsonPath().get("id");
    // }


}