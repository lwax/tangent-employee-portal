package za.co.tangentsolutions.employeeportal.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.tangentsolutions.employeeportal.models.EmployeeDTO;
import za.co.tangentsolutions.employeeportal.models.ProfileDTO;
import za.co.tangentsolutions.employeeportal.models.ReviewDTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponsePayload {

    private String token;
    private List<EmployeeDTO> employees;
    private ProfileDTO profile;
    private List<ReviewDTO> review;

}