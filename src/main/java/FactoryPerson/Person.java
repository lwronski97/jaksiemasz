package FactoryPerson;

import com.google.common.base.Preconditions;

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
        Preconditions.checkArgument( ( name != null && !checkString.checkIfHaveNumbers(name)), "Name is illegal" );
        return name;
    }

    private String checkSurname(String surname) {
        Preconditions.checkArgument( ( surname != null && !checkString.checkIfHaveNumbers(surname)),"Surname is illegal");
        return surname;
    }

    private String checkEmail(String email)  {
        Preconditions.checkArgument( ( email != null && checkString.correctEmail(email)),"Email is illegal");
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
