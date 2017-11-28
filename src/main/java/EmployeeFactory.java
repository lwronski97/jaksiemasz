import helpclasses.RandomString;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Random;

public class EmployeeFactory {

    private static final RandomString randomString = new RandomString();
    private static final Random RANDOM = new Random();

    public Developer randomDeveloper(){
        return new Developer(randomString.getName(),EmployeeType.Developer);
    }

    public TeamManager randomTeamManager() {
        return new TeamManager(randomString.getName(), EmployeeType.Manager, RANDOM.nextInt(10) +1 );
    }

    public Task randomTask() {
        return new Task(randomString.getName(), RANDOM.nextInt(30) +1);
    }

    public List<Employee> randomManagerList(int size){
        List<Employee> listRandomManager = new ArrayList<>();
        for ( int i = 0; i < size; i++){
            listRandomManager.add(randomTeamManager());
        }
        return listRandomManager;
    }

    public List<Task> randomTaskList(int size) {
        List<Task> listRandomTask = new ArrayList<>();
        for ( int i = 0; i < size; i++){
            listRandomTask.add(randomTask());
        }
        return listRandomTask;
    }

    public List<Employee> randomDeveloperList(int size) {
        List<Employee> listRandomDeveloper = new ArrayList<>();
        for ( int i = 0; i < size; i++){
            listRandomDeveloper.add(randomDeveloper());
        }
        return listRandomDeveloper;
    }

}
