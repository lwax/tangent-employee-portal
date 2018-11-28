
package za.co.tangentsolutions.employeeportal.payloads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeFilter {

    private String race;
    private String positionId;
    private String startDate;
    private String user;
    private String gender;
    private String birthDate;
    private String email;

}
