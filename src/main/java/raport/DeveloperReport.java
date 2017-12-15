package raport;

import employee.Developer;
import employee.Task;
import visualizer.ListTaskVisualizer;

import java.util.List;

public class DeveloperReport extends AbstractReport {

    private List<Task> taskList;

    public DeveloperReport(Developer developer) {
        super(developer);
        taskList = developer.getListTask();
    }

    @Override
    public Report prepareReport() {
        listReport.clear();
        listReport.add(this);
        return this;
    }


    @Override
    public String visualize() {
        return employee.toString() + " do:" + new ListTaskVisualizer(taskList).visualize();
    }


}
