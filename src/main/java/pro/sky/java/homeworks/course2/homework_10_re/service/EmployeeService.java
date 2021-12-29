package pro.sky.java.homeworks.course2.homework_10_re.service;

import pro.sky.java.homeworks.course2.homework_10_re.data.Employee;

import java.util.Set;

public interface EmployeeService {

//    Employee add(String fullName, int department, int salary);
//
//    Employee remove(String fullName, int department, int salary);
//
//    Employee find(String fullName, int department, int salary);

//    Employee findByName(String fullName);

    Employee add(String firstName, String secondName, int department, int salary);

//    Employee remove(String firstName, String secondName, int department, int salary);

//    Employee remove(String firstName, String secondName);

    Employee remove(String secondName);

//    Employee find(String firstName, String secondName);

    Employee find(String secondName);

    Set<Employee> printEmployeeList();

    Set<Employee> getEmployees();

}
