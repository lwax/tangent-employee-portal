package za.co.tangentsolutions.employeeportal.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeNextOfKin {

    private Long id;
    private String name;
    private String relationship;
    private String phoneNumber;
    private String email;
    private String physicalAddress;
    private int employeeId;

}
