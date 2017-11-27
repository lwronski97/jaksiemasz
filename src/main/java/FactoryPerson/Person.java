package FactoryPerson;

public class Person implements PersonInterface {

    private String name;
    private String surname;
    private String email;
    private final static CorrectString checkString = new CorrectString();

    public Person(String name, String surname, String email)  {
        this.name = checkName(name);
        this.surname = checkSurname(surname);
        this.email =  checkEmail(email);
    }

    private String checkName(String name) {
        if ( name == null || checkString.checkIfHaveNumbers(name)) {
            throw new IllegalArgumentException("Name is illegal");
        }
        return name;
    }

    private String checkSurname(String surname) {
        if ( surname == null || checkString.checkIfHaveNumbers(surname)) {
            throw new IllegalArgumentException("Surname is illegal");
        }
        return surname;
    }

    private String checkEmail(String email)  {
        if( email == null || !checkString.correctEmail(email)){
            throw new IllegalArgumentException("Email is illegal");
        }
        return email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return  "name: " + name + " surname: " + surname + " email: " + email ;
    }
}
