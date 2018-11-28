package za.co.tangentsolutions.employeeportal.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeDTO {

    private Long id;
    private UserDTO user;
    private PositionDTO position;
    private String email;
    private String githubUser;
    private String phoneNumber;
    private String birthDate;
    private String gender;
    private String race;
    private int yearsWorked;
    private int age;
    private int daysToBirthday;

}