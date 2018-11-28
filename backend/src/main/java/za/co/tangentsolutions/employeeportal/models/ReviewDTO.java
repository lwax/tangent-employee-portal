package za.co.tangentsolutions.employeeportal.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReviewDTO {

    private Long id;
    private String date;
    private String salary;
    private String type;
    private int employeeId;
    private int positionId;

}
