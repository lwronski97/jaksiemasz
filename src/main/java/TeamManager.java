import java.util.ArrayList;
import java.util.List;

public class TeamManager extends AbstractEmployee implements Manager {

    private Integer maxNumberOfEmployee;
    private List<Employee> subordinates;

    public TeamManager(String name, EmployeeType role, Integer maxNumberOfEmployee) {
        super(name, role);
        this.maxNumberOfEmployee = maxNumberOfEmployee;
        this.subordinates = new ArrayList<>();
    }



    @Override
    public void hire(Employee employee) {
        this.subordinates.add(employee);
    }

    @Override
    public void fire(Employee employee) {
        this.subordinates.remove(employee);
    }

    @Override
    public boolean canHire() {
        return subordinates.size() < maxNumberOfEmployee;
    }

    @Override
    public void assignTask(Task task) {
        if (subordinates.size() > 0) {

            Employee temp = subordinates.get(0);
            Integer minAssignTask = subordinates.get(0).reportWork().countTimeWork();

            for (Employee employee : subordinates) {
                if (minAssignTask > employee.reportWork().countTimeWork()) {
                    temp = employee;
                }
            }
            temp.assignTask(task);
        }
    }


    @Override
    public Report reportWork() {
        return new Report(this.subordinates);
        }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder(this.getIndent() + "TeamManager: " + this.getName() + " is the boss\n");
        for ( Employee employee: this.subordinates){
            employee.setIndent(this.getIndent() + "    ");
            string.append( this.getIndent() + employee.toString());
        }
        this.setIndent("");
        return string.toString();
    }
}
