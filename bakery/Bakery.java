package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public boolean remove(String name) {
        return employees.removeIf(e -> e.getName().equals(name));
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public Employee getOldestEmployee() {
        Employee employee = null;

        for (Employee e : employees) {
            if (employee == null || employee.getAge() < e.getAge()) {
                employee = e;
            }

        }
        return employee;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {

            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder out = new StringBuilder();

        out.append(String.format("Employees working at Bakery %s:", this.name));
        out.append(System.lineSeparator());
        for (Employee employee : employees) {
            out.append(employee.toString()).append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}