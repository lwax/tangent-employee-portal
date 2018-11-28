package za.co.tangentsolutions.employeeportal.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PositionDTO {

    private Long id;
    private String name;
    private String level;
    private int sort;

}