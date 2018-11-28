package za.co.tangentsolutions.employeeportal.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProfileDTO {

    private Long id;
    private UserDTO user;
    private PositionDTO position;
    private EmployeeNextOfKin employeeNextOfKin;
    private ReviewDTO reviewDTO;
    private String idNumber;
    private String phoneNumber;
    private String physicalAddress;
    private String taxNumber;
    private String email;
    private String personalEmail;
    private String githubUser;
    private int birthDate;
    private PositionDTO startDate;
    private String endDate;
    private String idDocument;
    private int visaDocument;
    private boolean isEmployed;
    private boolean isForeigner;
    private String gender;
    private String race;
    private int yearsWorked;
    private int age;
    private String nextReview;
    private int daysToBirthday;
    private String leaveRemaining;

}