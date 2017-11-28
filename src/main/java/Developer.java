import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Developer extends AbstractEmployee {

    private List<Task> listTask = new ArrayList<>();

    public Developer(String name, EmployeeType role) {
        super(name, role);
    }

    public List<Task> getlistTask() {
        return this.listTask;
    }

    @Override
    public void assignTask(Task task) {
        listTask.add(task);
        System.out.println("Developer: " + this.getName() + " realize: " + task.getNameTask());
    }

    @Override
    public Report reportWork() {
        return new Report(Arrays.asList(this));
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

