package pro.sky.java.homeworks.course2.homework_10_re.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.homeworks.course2.homework_10_re.data.Employee;
import pro.sky.java.homeworks.course2.homework_10_re.service.EmployeeService;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstname") String firstName, @RequestParam("secondname") String secondName,
                        @RequestParam ("departmentId") int department, @RequestParam ("salary") int salary) {
        Employee newbie = employeeService.add(firstName, secondName, department, salary);
        return newbie;
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("secondname") String secondName) {
        Employee removed = employeeService.remove(secondName);
        return removed;
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("secondname") String secondName) {
        Employee find = employeeService.find(secondName);
        return find;
    }

    @GetMapping("/printlist")
    public Set<Employee> print() {
        return employeeService.printEmployeeList();
    }
}
