package pro.sky.java.homeworks.course2.homework_10_re.data;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String secondName;
    private int department;
    private int salary;

    public Employee(String firstName, String secondName, int department, int salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.department = department;
        this.salary = salary;
    }

//    public Employee(String firstName, String secondName) {
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.department = 0;
//        this.salary = 0;
//    }

    public Employee(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Employee(String secondName) {
        this.secondName = secondName;
    }

//    public String getFullName() {
//        return firstName +" "+ secondName;
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && firstName.equals(employee.firstName) &&
                secondName.equals(employee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, department, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}

