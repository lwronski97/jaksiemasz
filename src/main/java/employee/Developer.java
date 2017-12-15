package employee;

import raport.DeveloperReport;
import raport.Report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Developer extends AbstractEmployee {

    private final List<Task> listTask = new ArrayList<>();

    public Developer(Builder builder) {
        super(builder);
    }

    @Override
    public void assign(Task task) {
        listTask.add(task);
        amountTimeOfWork += task.getAmountofTimeTask();
    }

    @Override
    public Report reportWork() {
        return new DeveloperReport(this);
    }

    public List<Task> getListTask() {
        return Collections.unmodifiableList(listTask);
    }


    @Override
    public boolean canAssignTask() {
        return true;
    }

    public static class Builder extends EmployeeBuilder<Builder> {

        public Builder(String name, String surname) {
            super(name, surname, EmployeeRole.Developer);
        }

        @Override
        public Developer build() {
            return new Developer(this);
        }
    }

}

