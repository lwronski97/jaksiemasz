package visualizer;

import employee.Developer;

public class DeveloperVisualizer {

    private Developer developer;

    public DeveloperVisualizer(Developer developer) {
        this.developer = developer;
    }

    public String visualize() {
        return visualize("");
    }

    public String visualize(String indent) {
        StringBuilder stringVisualizeDeveloper = new StringBuilder();
        Developer employeeDeveloper = developer;
        employeeDeveloper.getListTask().forEach(task -> stringVisualizeDeveloper.append(indent + indent + task.toString() + "\n"));
        return stringVisualizeDeveloper.toString();
    }

}
