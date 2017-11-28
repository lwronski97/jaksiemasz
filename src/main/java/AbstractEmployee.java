

public abstract class AbstractEmployee implements Employee{

    private String name;
    private EmployeeType role;
    private String indent="";


    public AbstractEmployee(String name, EmployeeType role){
        this.name = name;
        this.role = role;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public EmployeeType getRole() {
        return role;
    }

    @Override
    public void setIndent(String indent){
        this.indent = indent + "    ";
        this.indent = indent + "        ";
    }

    @Override
    public String getIndent(){
        return this.indent;
    }

}
