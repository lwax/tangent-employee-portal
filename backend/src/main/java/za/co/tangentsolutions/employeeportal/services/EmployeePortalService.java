package za.co.tangentsolutions.employeeportal.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import za.co.tangentsolutions.employeeportal.models.EmployeeDTO;
import za.co.tangentsolutions.employeeportal.models.PositionDTO;
import za.co.tangentsolutions.employeeportal.models.ReviewDTO;
import za.co.tangentsolutions.employeeportal.models.StatisticsDTO;

public class EmployeePortalService {


    public StatisticsDTO populateStatistics(List<EmployeeDTO> employees, List<ReviewDTO> review){

        StatisticsDTO statistics = new StatisticsDTO();

        statistics.setNumOfEmployees(employees.stream().count());
        statistics.setBirthdaysThisMonth(getBirthdaysThisMonth(employees));
        statistics.setPositionData(getPositionData(employees));
        statistics.setReviewData(review);
        statistics.setNumOfMales(getNumberOfMales(employees));
        statistics.setNumOfFemales(getNumberOfFemales(employees));
        statistics.setNumOfUnknownGender(getNumberOfUnknownGender(employees));

        return statistics;
    }


    private Long getNumberOfMales(List<EmployeeDTO> employees){
                return employees.stream()
                        .filter(employee -> String.valueOf(employee.getGender()).equals("M"))
                        .count();
    }

    private Long getNumberOfFemales(List<EmployeeDTO> employees) {
        return employees.stream().filter(employee -> String.valueOf(employee.getGender()).equals("F")).count();
    }



    private Long getNumberOfUnknownGender(List<EmployeeDTO> employees) {
        return employees.stream().filter(employee -> String.valueOf(employee.getGender()).equals("null")).count();
    }


    private List<PositionDTO> getPositionData(List<EmployeeDTO> employees){

        return employees.stream()
                                        .map(employee -> employee.getPosition())
                                        .collect(Collectors.toList());
    }

    private Long getBirthdaysThisMonth(List<EmployeeDTO> employees){

       return employees.stream()
                .filter(employee -> isCurrentMonthSameAsBirthMonth(employee.getBirthDate()))
                .count();
    }

    private boolean isCurrentMonthSameAsBirthMonth(String employeeBirthDate) {

        try {
            LocalDate today = LocalDate.now();
            int currentMonth = today.getMonthValue();
            
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthDate = LocalDate.parse(employeeBirthDate, df);
            int birthMonth = birthDate.getMonthValue();
            
            if (currentMonth == birthMonth) {
                return true;
            } 


        } catch (Exception ex) {
            System.out.println(ex);
        }

        return false;
       
    }

}
