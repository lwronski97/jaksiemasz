package visualizer;

import employee.Employee;

import java.util.List;

public class SubordinatesListVisualizer {
    private List<Employee> subordinatesList;

    public SubordinatesListVisualizer(List<Employee> subordinatesList) {
        this.subordinatesList = subordinatesList;
    }

    public String visualize() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee employee : subordinatesList) {
            stringBuilder.append("\n      " + employee.toString());
        }
        return stringBuilder.toString();
    }
}
