import java.util.ArrayList;
import java.util.List;

public class Developer extends AbstractEmployee {

    private List<Task> listTask = new ArrayList<>();

    public Developer(String name, EmployeeType role) {
        super(name, role);
    }

    @Override
    public void assignTask(Task task) {
        listTask.add(task);
        updateTimeWork(task.getTimeTask());
        System.out.println("Developer: " + this.getName() + " realize: " + task.getNameTask());
    }

    @Override
    public Report reportWork() {
        return new Report(this);
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder(this.getIndent() + "Developer: " + this.getName() + " realize\n");
        for ( Task task: listTask){
            string.append(this.getIndent() + this.getIndent() +  task.toString() + "\n") ;
        }
        this.setIndent("");
        return string.toString();
    }

}

