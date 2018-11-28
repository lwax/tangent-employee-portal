package za.co.tangentsolutions.employeeportal.payloads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.tangentsolutions.employeeportal.models.StatisticsDTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OutboundPayload {

    private ResponsePayload responsePayload;
    private StatisticsDTO statistics;

}