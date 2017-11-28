import helpclasses.RandomString;

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

}
