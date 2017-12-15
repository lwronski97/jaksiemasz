package raport;

import employee.Employee;
import employee.TeamManager;
import visualizer.SubordinatesListVisualizer;

import java.util.List;

public class ManagerReport extends AbstractReport {

    private List<Employee> subordinatesList;

    public ManagerReport(TeamManager teamManager) {
        super(teamManager);
        subordinatesList = teamManager.getSubordinates();
    }


    @Override
    public Report getReport() {
        return this;
    }

    @Override
    public Report prepareReport() {
        listReport.clear();
        for (Employee employee : subordinatesList) {
            for (Report report : employee.reportWork().prepareReport().getListReport()) {
                listReport.add(report.sortListReport());
            }
        }
        listReport.add(this);
        return this;
    }


    @Override
    public String visualize() {
        return employee.toString() + " hire:" + new SubordinatesListVisualizer(subordinatesList).visualize();
    }
}
