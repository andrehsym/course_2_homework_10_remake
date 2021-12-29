package pro.sky.java.homeworks.course2.homework_10_re.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.homeworks.course2.homework_10_re.data.Employee;
import pro.sky.java.homeworks.course2.homework_10_re.exceptions.BadRequestException;
import pro.sky.java.homeworks.course2.homework_10_re.exceptions.EmployeeAlreadyExistsException;
import pro.sky.java.homeworks.course2.homework_10_re.exceptions.EmployeeNotFoundException;
import pro.sky.java.homeworks.course2.homework_10_re.service.EmployeeService;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Set<Employee> employees = new HashSet<>();

    private String correctNames(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    private void correctNames(Employee employee) {
        employee.setFirstName(correctNames(employee.getFirstName()));
        employee.setSecondName(correctNames(employee.getSecondName()));
    }

    @Override
    public Employee add(String firstName, String secondName, int department, int salary) {
        Employee newbie = new Employee(firstName, secondName, department, salary);
        correctNames(newbie);
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(secondName)) {
            throw new BadRequestException();
        } else if (employees.contains(newbie)) {
            throw new EmployeeAlreadyExistsException();
        }
            employees.add(newbie);
            return newbie;
    }

    @Override
    public Employee remove(String secondName) {
        Employee removed = new Employee(secondName);
        for (Employee employee : employees) {
            if (employee.getSecondName().equals(secondName)) {
                employees.remove(employee);
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String secondName) {
        Employee find = new Employee(secondName);
        for (Employee employee : employees) {
            if (employee.getSecondName().equals(secondName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Set<Employee> printEmployeeList() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        return employees;
    }

    @Override
    public Set<Employee> getEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        return employees;
    }
}
