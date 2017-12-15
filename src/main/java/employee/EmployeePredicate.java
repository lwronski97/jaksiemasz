package employee;

import java.util.function.Predicate;


public class EmployeePredicate {

    public static Predicate<Employee> emptyPredicate() {
        return (employee) -> true;
    }

    public static Predicate<Employee> requireUniversity(String university) {
        return (employee) -> employee.getUniversity().equals(university);
    }

    public static Predicate<Employee> requireSex(Sex sex) {
        return employee -> employee.getSex() == sex;
    }


    public static Predicate<Employee> requireNationality(String nationality) {
        return (employee) -> employee.getNationality().equals(nationality);
    }

    public static Predicate<Employee> requireEmail(String email) {
        return (employee) -> employee.getEmail().contains("@" + email);
    }
}
