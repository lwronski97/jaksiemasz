import java.util.ArrayList;
import java.util.List;

public class  Report {

    private List<Employee> listTask = new ArrayList<>();

    public Report(List<Employee> listTask) {
        this.listTask = listTask;
    }

    public Integer countTimeWork() {
        Integer TimeWork = 0;
        for ( Employee employee : listTask){
            if ( employee.getRole() == EmployeeType.Developer) {
                TimeWork += countTimeDeveloper((Developer) employee);
            }
            if ( employee.getRole() == EmployeeType.Manager) {
                TimeWork += employee.reportWork().countTimeWork();
            }
        }
        return TimeWork;
    }

    private Integer countTimeDeveloper(Developer developer) {
        List<Task> listTask = developer.getlistTask();
        Integer timeWork = 0;
        for ( Task task : listTask) {
            timeWork += task.getTimeTask();
        }
        return timeWork;
    }
}