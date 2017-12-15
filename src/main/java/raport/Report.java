package raport;


import employee.EmployeeRole;

import java.util.List;

public interface Report {

    void showReport();

    int getAmountTimeOfWork();

    Report getReport();

    Report prepareReport();

    List<Report> getListReport();

    Report sortListReport();

    String getName();

    String getSurname();

    String visualize();

    EmployeeRole getRole();
}
