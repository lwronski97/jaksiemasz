
public class TeamManager extends AbstractEmployee implements Manager {

    private Integer maxNumberOfEmployee;

    public TeamManager(String name, EmployeeType role, Integer maxNumberOfEmployee) {
        super(name, role);
        this.maxNumberOfEmployee = maxNumberOfEmployee;
    }

    @Override
    public void hire(Employee employee) {
        this.getSubordinates().add(employee);
        employee.setParent(this);
    }

    @Override
    public void fire(Employee employee) {
        this.getSubordinates().remove(employee);
    }

    @Override
    public boolean canHire() {
        return this.getSubordinates().size() < maxNumberOfEmployee;
    }

    @Override
    public void assignTask(Task task) {
        if ( this.getSubordinates().size() > 0 ) { this.getSubordinates().first().assignTask(task); }
    }

    @Override
    public Report reportWork() {
        return new Report(this);
        }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder(this.getIndent() + "TeamManager: " + this.getName() + " is the boss\n");
        for ( Employee employee: this.getSubordinates()){
            employee.setIndent(this.getIndent() + "    ");
            string.append( this.getIndent() + employee.toString());
        }
        this.setIndent("");
        return string.toString();
    }
}
