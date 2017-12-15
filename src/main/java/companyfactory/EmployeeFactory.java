package companyfactory;

import employee.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class EmployeeFactory {

    private static final Random RANDOM = new Random();
    private final List<String> name;
    private final List<String> surname;
    private final List<String> email;

    public EmployeeFactory() {
        this.name = Arrays.asList("Terence", "Nadia", "Scott", "Vannessa", "Jazmine", "Alexis", "Shila", "Moshe",
                "Kimber", "Zenobia", "Deanne", "Tonda", "Hilma", "Cristine", "Herman", "Tanesha", "Maragaret", "Jaquelyn", "MilissaBilly");
        this.surname = Arrays.asList("Schultze", "Gibso", "Briscoe", "Mathews", "Cusumano", "Ephraim", "Banuelos", "Youngs", "Garrison", "Goldstein",
                "Bentley", "Lefever", "Kile", "Baptist", "Colton", "Graybeal", "Giardina", "Elkins", "Lickteig", "Evan");
        this.email = Arrays.asList("gmail.com", "o2.pl", "interia.pl", "onet.pl", "agh.edu.pl");

    }

    public Developer randomDeveloper() {
        return new Developer.Builder(getName(), getSurname()).build();
    }

    public TeamManager randomTeamManager(EmployeeRole employeeType) {
        return new TeamManager.Builder(getName(), getSurname(), employeeType).
                build();
    }


    public List<Employee> randomManagerList(int size) {
        List<Employee> listRandomManager = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            listRandomManager.add(randomTeamManager(EmployeeRole.Manager));
        }
        return listRandomManager;
    }

    public List<Employee> randomDeveloperList(int size) {
        List<Employee> listRandomDeveloper = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            listRandomDeveloper.add(randomDeveloper());
        }
        return listRandomDeveloper;
    }

    private String getName() {
        return name.get(RANDOM.nextInt(name.size()));
    }

    private String getSurname() {
        return surname.get(RANDOM.nextInt(surname.size()));
    }

    private String getEmail() {
        return RandomStringUtils.randomAlphabetic(RANDOM.nextInt(8) + 3)
                + "@"
                + email.get(RANDOM.nextInt(email.size()));
    }

}
