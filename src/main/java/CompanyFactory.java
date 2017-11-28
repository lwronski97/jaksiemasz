import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CompanyFactory {

    private List<Employee> listRandomManager;
    private List<Employee> listRandomDeveloper;
    private List<Task> listRandomTask;
    private static final EmployeeFactory  employeeFactory = new EmployeeFactory();
    private static final Random RANDOM = new Random();

    public CompanyFactory() {
        listRandomManager = new ArrayList<>();
        listRandomDeveloper = new ArrayList<>();
        listRandomTask = new ArrayList<>();
    }

    public Employee generateCompany(int size){

        listRandomManager = employeeFactory.randomManagerList(size/3);
        hireManager(size/3);
        listRandomDeveloper = employeeFactory.randomDeveloperList(size);
        hireDeveloper(size);
        listRandomTask = employeeFactory.randomTaskList(size);
        assignTask(size);
        return listRandomManager.get(0);
    }

    private void assignTask(int size) {
        for ( int i = 1; i < size; i++) {
            TeamManager randomManager = (TeamManager) listRandomManager.get(RANDOM.nextInt(listRandomManager.size()));
            randomManager.assignTask(listRandomTask.get(i));
        }
    }

    private void hireDeveloper(int size) {
        for ( int i = 1; i < size; i++) {
            TeamManager randomManager = (TeamManager) listRandomManager.get(RANDOM.nextInt(listRandomManager.size()));
            randomManager.hire(listRandomDeveloper.get(i));
        }
    }


    private void hireManager(int size) {
        for ( int i = 1; i < size; i++) {
            TeamManager randomManager = (TeamManager) listRandomManager.get(RANDOM.nextInt(i));
            randomManager.hire(listRandomManager.get(i));
        }
    }

}