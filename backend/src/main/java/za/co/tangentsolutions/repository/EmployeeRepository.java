package za.co.tangentsolutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.tangentsolutions.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}