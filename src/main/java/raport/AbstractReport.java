package raport;

import employee.Employee;
import employee.EmployeeRole;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractReport implements Report {

    protected Employee employee;
    protected List<Report> listReport;

    public AbstractReport(Employee employee) {
        this.employee = employee;
        this.listReport = new ArrayList<>();
    }

    @Override
    public String getName() {
        return employee.getName();
    }

    @Override
    public String getSurname() {
        return employee.getSurname();
    }

    @Override
    public EmployeeRole getRole() {
        return employee.getRole();
    }

    @Override
    public int getAmountTimeOfWork() {
        return employee.getAmountTimeOfWork();
    }

    @Override
    public List<Report> getListReport() {
        return Collections.unmodifiableList(listReport);
    }

    @Override
    public Report sortListReport() {

        Comparator<Report> byFirstName = Comparator.comparing(raport -> raport.getName());
        Comparator<Report> bySurname = Comparator.comparing(raport -> raport.getSurname());
        Comparator<Report> byEmployeeRole = Comparator.comparing(raport -> raport.getRole().name());
        Comparator<Report> byAmountTimeOfWork = Comparator.comparing(raport -> raport.getAmountTimeOfWork());

        listReport = new ArrayList<Report>(listReport).stream().sorted(byFirstName.
                thenComparing(bySurname.
                        thenComparing(byEmployeeRole).
                        thenComparing(byAmountTimeOfWork))).
                collect(Collectors.toList());
        return this;
    }


    @Override
    public void showReport() {
        for (Report report : listReport) {
            System.out.println(report.visualize());
        }
    }

    @Override
    public Report getReport() {
        return this;
    }

}
