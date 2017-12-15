package employee;

public abstract class AbstractEmployee implements Employee {

    private String name;
    private String surname;
    private String university;
    private Sex sex;
    private String nationality;
    private String email;
    private EmployeeRole role;
    protected int amountTimeOfWork;


    public AbstractEmployee(EmployeeBuilder employeeBuilder) {
        this.name = employeeBuilder.name;
        this.surname = employeeBuilder.surname;
        this.university = employeeBuilder.university;
        this.sex = employeeBuilder.sex;
        this.nationality = employeeBuilder.nationality;
        this.email = employeeBuilder.email;
        this.role = employeeBuilder.role;
        this.amountTimeOfWork = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public EmployeeRole getRole() {
        return role;
    }

    @Override
    public int getAmountTimeOfWork() {
        return amountTimeOfWork;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getUniversity() {
        return university;
    }

    @Override
    public Sex getSex() {
        return sex;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {

        return "Role: " + role +
                " Name: " + name +
                " Surname " + surname +
                (sex != Sex.None ? " Sex: " + sex.toString() : "") +
                (university != "" ? " University: " + university : "") +
                (nationality != "" ? " Nationality: " + nationality : "") +
                (email != "" ? " Email: " + email : "");
    }


    public static abstract class EmployeeBuilder<T extends EmployeeBuilder<T>> {
        private String name;
        private String surname;
        private String university = "";
        private Sex sex = Sex.None;
        private String nationality = "";
        private String email = "";
        private EmployeeRole role;

        public EmployeeBuilder(String name, String surname, EmployeeRole employeeRole) {
            this.name = name;
            this.surname = surname;
            this.role = employeeRole;
        }

        public T setAcademy(String university) {
            this.university = university;
            return (T) this;
        }

        public T setSex(Sex sex) {
            this.sex = sex;
            return (T) this;
        }

        public T setNationality(String nationality) {
            this.nationality = nationality;
            return (T) this;
        }

        public T setEmail(String email) {
            this.email = email;
            return (T) this;
        }


        public abstract Employee build();

    }

}
