package visualizer;

import employee.Developer;
import employee.Employee;
import employee.EmployeeRole;
import employee.TeamManager;

public class CompanyVisualizer {

    private Employee employee;
    private EmployeeRole employeeRole;

    public CompanyVisualizer(Employee employee) {
        this.employee = employee;
        this.employeeRole = employee.getRole();
    }

    public String visualize() {
        return visualize("");
    }

    public String visualize(String indent) {
        StringBuilder stringVisualizeCompany = new StringBuilder(indent + employee.getRole() + employee.getName() + " realize\n");
        if (employeeRole == EmployeeRole.CEO || employeeRole == EmployeeRole.Manager) {
            stringVisualizeCompany.append(new MenagerVisualizer((TeamManager) employee).visualize(indent));
        }
        if (employeeRole == EmployeeRole.Developer) {
            stringVisualizeCompany.append(new DeveloperVisualizer((Developer) employee).visualize(indent));
        }
        return stringVisualizeCompany.toString();
    }


}
