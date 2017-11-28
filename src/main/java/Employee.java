public interface Employee {

    String getName();
    EmployeeType getRole();
    void assignTask(Task task);
    Report reportWork();
    void setIndent(String indent);
    String getIndent();
}
