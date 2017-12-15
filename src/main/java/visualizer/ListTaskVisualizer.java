package visualizer;

import employee.Task;

import java.util.List;

public class ListTaskVisualizer {

    private List<Task> taskList;

    public ListTaskVisualizer(List<Task> taskList) {
        this.taskList = taskList;
    }

    public String visualize() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Task task : taskList) {
            stringBuilder.append("\n      TASK:  " + task.toString());
        }
        return stringBuilder.toString();
    }
}
