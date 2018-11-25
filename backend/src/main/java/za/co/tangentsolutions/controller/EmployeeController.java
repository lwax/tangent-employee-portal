package za.co.tangentsolutions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import za.co.tangentsolutions.exceptionHandlers.EmployeeIdMismatchException;
import za.co.tangentsolutions.exceptionHandlers.EmployeeNotFoundException;
import za.co.tangentsolutions.model.Employee;
import za.co.tangentsolutions.repository.EmployeeRepository;

import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findOne(@PathVariable Long id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        employeeRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Employee updateTaxTable(@RequestBody Employee employee, @PathVariable Long id) {
        if (employee.getId() == id) {
            throw new EmployeeIdMismatchException();
        }
        employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        return employeeRepository.save(employee);
    }

}