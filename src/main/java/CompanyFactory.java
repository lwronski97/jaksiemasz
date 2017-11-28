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

    public TeamManager generateCompany(int size){

        randomManager(size/3);
        hireManager(size/3);
        randomDeveloper(size);
        hireDeveloper(size);
        randomTask(size);
        assignTask(size);
        System.out.println(listRandomManager.get(0));
        return employeeFactory.randomTeamManager();
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

    private void randomManager(int size){
        for ( int i = 0; i < size; i++){
            listRandomManager.add( employeeFactory.randomTeamManager());
        }
    }

    private void randomTask(int size) {
        for ( int i = 0; i < size; i++){
            listRandomTask.add( employeeFactory.randomTask());
        }
    }

    private void randomDeveloper(int size) {
        for ( int i = 0; i < size; i++){
            listRandomDeveloper.add( employeeFactory.randomDeveloper());
        }
    }

}