package employee;

import raport.Report;

public interface Employee {

    String getName();

    String getSurname();

    EmployeeRole getRole();

    void assign(Task task);

    Report reportWork();

    int getAmountTimeOfWork();

    boolean canAssignTask();

    String getNationality();

    String getEmail();

    String getUniversity();

    Sex getSex();

}