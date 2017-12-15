package employee;

import raport.ManagerReport;
import raport.Report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class TeamManager extends AbstractEmployee implements Manager {

    private Integer maxNumberOfEmployee;
    private final List<Employee> subordinates;
    private Predicate<Employee> employeePredicate;


    public TeamManager(Builder builder) {
        super(builder);
        this.maxNumberOfEmployee = builder.maxNumberOfEmployee;
        this.employeePredicate = builder.employeePredicate;
        this.subordinates = new ArrayList<>();
    }

    public List<Employee> getSubordinates() {
        return Collections.unmodifiableList(subordinates);
    }

    @Override
    public void hire(Employee employee) {
        if (canHire(employee)) {
            subordinates.add(employee);
        } else {
            throw new RuntimeException("This employee can't be hired ");
        }

    }

    @Override
    public void fire(Employee employee) {
        if (!subordinates.remove(employee)) {
            throw new RuntimeException("This employee can't be fired");
        }
        amountTimeOfWork -= employee.getAmountTimeOfWork();
    }

    @Override
    public boolean canHire(Employee employee) {
        return subordinates.size() < maxNumberOfEmployee && employeePredicate.test(employee);
    }

    public boolean canAssignTask() {
        for (Employee e : subordinates) {
            if (e.canAssignTask()) return true;
        }
        return false;
    }

    @Override
    public void assign(Task task) {
        if (subordinates.isEmpty()) throw new RuntimeException("Cannot assign employee.Task");

        Employee employee = findEmployeeWithLowestWorkOfAmount();
        employee.assign(task);
        amountTimeOfWork += task.getAmountofTimeTask();
    }

    @Override
    public Report reportWork() {
        return new ManagerReport(this).prepareReport().getReport();
    }

    private Employee findEmployeeWithLowestWorkOfAmount() {
        return subordinates.stream().filter(employee -> employee.canAssignTask()).min(Comparator.comparing(Employee::getAmountTimeOfWork)).get();
    }

    public static class Builder extends EmployeeBuilder<Builder> {

        private int maxNumberOfEmployee = 5;
        private Predicate<Employee> employeePredicate = EmployeePredicate.emptyPredicate();

        public Builder(String name, String surname, EmployeeRole employeeRole) {
            super(name, surname, employeeRole);
        }


        public Builder setMaxNumberOfEmployee(int maxNumberOfEmployee) {
            this.maxNumberOfEmployee = maxNumberOfEmployee;
            return this;
        }

        public Builder strategyInHire(Predicate<Employee> employeePredicate) {
            this.employeePredicate = employeePredicate;
            return this;
        }

        @Override
        public TeamManager build() {
            return new TeamManager(this);
        }
    }

}
