import java.util.Comparator;
import java.util.TreeSet;

public abstract class AbstractEmployee implements Employee{

    private String name;
    private EmployeeType role;
    private String indent="";
    private Integer timeWork;
    private Employee parent;
    public TreeSet<Employee> subordinates;


    public AbstractEmployee(String name, EmployeeType role){
        this.name = name;
        this.role = role;
        this.timeWork = 0;
        this.subordinates = createTreeSetWithComparate();
    }

    @Override
    public Integer getTimeWork() { return timeWork; }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public EmployeeType getRole() {
        return role;
    }

    @Override
    public void setIndent(String indent){ this.indent = indent; }

    @Override
    public void setParent(Employee employee) {
        this.parent = employee;
    }

    @Override
    public String getIndent(){ return this.indent; }

    @Override
    public void updateTimeWork( Integer timeWork){
        this.timeWork += timeWork;
        if ( this.getRole() != EmployeeType.Leader ) {
            parent.updateTimeWork(timeWork);
            TeamManager parent = (TeamManager) this.parent;
            TreeSet<Employee> temp = createTreeSetWithComparate();
            for ( Employee e : parent.subordinates){
                temp.add(e);
            }
            parent.subordinates = temp;
        }
    }

    private TreeSet<Employee> createTreeSetWithComparate(){
        return new TreeSet<>((e1, e2) -> {
            if (e1.getTimeWork() >= e2.getTimeWork()) return 1;
            return -1;
        });
    }
}
