package za.co.tangentsolutions.employeeportal.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StatisticsDTO {

    private Long numOfEmployees;
    private Long birthdaysThisMonth;
    private List<PositionDTO> positionData;
    private List<ReviewDTO> reviewData;
    private Long numOfMales;
    private Long numOfFemales;
    private Long numOfUnknownGender;

    

}