import java.util.TreeSet;

public interface Employee {

    String getName();
    EmployeeType getRole();
    void assignTask(Task task);
    Report reportWork();
    void setIndent(String indent);
    String getIndent();
    Integer getTimeWork();
    void setParent(Employee employee);
    void updateTimeWork(Integer timeWork);
    TreeSet<Employee> getSubordinates();
    void setSubordinates(TreeSet<Employee> subordinates);
}
