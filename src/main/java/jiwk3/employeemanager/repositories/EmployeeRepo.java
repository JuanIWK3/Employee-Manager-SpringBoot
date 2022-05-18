package jiwk3.employeemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import jiwk3.employeemanager.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
