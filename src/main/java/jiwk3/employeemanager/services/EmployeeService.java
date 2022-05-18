package jiwk3.employeemanager.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jiwk3.employeemanager.errors.UserNotFoundException;
import jiwk3.employeemanager.models.Employee;
import jiwk3.employeemanager.repositories.EmployeeRepo;

@Service
public class EmployeeService {
  private final EmployeeRepo employeeRepo;

  @Autowired
  public EmployeeService(EmployeeRepo employeeRepo) {
    this.employeeRepo = employeeRepo;
  }

  public Employee addEmployee(Employee employee) {
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return employeeRepo.save(employee);
  }

  public List<Employee> findAllEmployees() {
    return employeeRepo.findAll();
  }

  public Employee findEmployeeById(Long id) {
    return employeeRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User by id" + id + " not found"));
  }

  public Employee updateEmployee(Employee employee) {
    return employeeRepo.save(employee);
  }

  public void deleteEmployee(Long id) {
    employeeRepo.deleteById(id);
  }

}
