package za.co.tangentsolutions.employeeportal.payloads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RequestPayload {

    private String username;
    private String password;
    private EmployeeFilter employeeFilter;

}