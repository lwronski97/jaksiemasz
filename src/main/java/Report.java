import java.util.ArrayList;
import java.util.List;

public class  Report {

    private Employee employee;

    public Report(Employee employee) {
        this.employee = employee;
    }

    public String printReport(){
        return employee.toString();
    }
}