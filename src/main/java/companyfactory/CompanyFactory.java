package companyfactory;

import employee.Employee;
import employee.EmployeeRole;
import employee.Task;
import employee.TeamManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CompanyFactory {

    private List<Employee> listRandomManager;
    private List<Employee> listRandomDeveloper;
    private List<Task> listRandomTask;
    private TeamManager ceo;
    private static final EmployeeFactory employeeFactory = new EmployeeFactory();
    private static final TaskFactory taskFactory = new TaskFactory();
    private static final Random RANDOM = new Random();

    public CompanyFactory() {
        listRandomManager = new ArrayList<>();
        listRandomDeveloper = new ArrayList<>();
        listRandomTask = new ArrayList<>();
    }

    public CompanyFactory generateCompany(int size) {
        ceo = employeeFactory.randomTeamManager(EmployeeRole.CEO);
        listRandomManager = employeeFactory.randomManagerList(size);
        hireManagers(size);
        listRandomDeveloper = employeeFactory.randomDeveloperList(size * 3);
        hireDevelopers(size);
        listRandomTask = taskFactory.randomTaskList(size);
        assignTasks(size);
        return this;
    }

    public TeamManager getCeo() {
        return ceo;
    }

    private void assignTasks(int size) {
        for (int i = 1; i < size; i++) {
            TeamManager randomManager = randomTeamManager(listRandomManager.size());
            while (!randomManager.canAssignTask()) randomManager = randomTeamManager(listRandomManager.size());
            randomManager.assign(listRandomTask.get(i));
        }
    }

    private void hireDevelopers(int size) {
        for (int i = 1; i < size; i++) {
            TeamManager randomManager = randomTeamManager(listRandomManager.size());
            while (!randomManager.canHire(listRandomDeveloper.get(i))) {
                randomManager = randomTeamManager(listRandomManager.size());
            }
            randomManager.hire(listRandomDeveloper.get(i));
        }
    }

    private void hireManagers(int size) {
        for (int i = 0; i < size; i++) {
            TeamManager randomManager = randomTeamManager(i);
            while (!randomManager.canHire(listRandomManager.get(i))) {
                randomManager = randomTeamManager(i);
            }
            randomManager.hire(listRandomManager.get(i));
        }
    }

    private TeamManager randomTeamManager(int rangeRandom) {
        int randomInt = RANDOM.nextInt(rangeRandom + 1);
        if (randomInt == 0) return ceo;
        else return (TeamManager) listRandomManager.get(randomInt - 1);
    }
}