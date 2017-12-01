
public class TeamManager extends AbstractEmployee implements Manager {

    private Integer maxNumberOfEmployee;

    public TeamManager(String name, EmployeeType role, Integer maxNumberOfEmployee) {
        super(name, role);
        this.maxNumberOfEmployee = maxNumberOfEmployee;
    }

    @Override
    public void hire(Employee employee) {
        this.subordinates.add(employee);
        employee.setParent(this);
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
        subordinates.first().assignTask(task);
    }

    @Override
    public Report reportWork() {
        return new Report(this);
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
