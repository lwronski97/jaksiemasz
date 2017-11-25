package FactoryPerson;

import org.omg.CORBA.ORBPackage.InvalidName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person implements PersonInterface {

    private String name;
    private String surname;
    private String email;

    public Person(String name, String surname, String email) throws InvalidName {
        checkIfHaveNumbers(name);
        checkIfHaveNumbers(surname);
        checkEmail(email);
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    private void checkEmail(String email) throws InvalidName {
        Pattern p = Pattern.compile(".*@.*\\....");
        Matcher m = p.matcher(email);
        if(!m.find()){
            throw new InvalidName(email);
        }

    }

    private void  checkIfHaveNumbers(String name) throws InvalidName {
        Pattern p = Pattern.compile("([0-9])");
        Matcher m = p.matcher(name);

        if(m.find()){
            throw new InvalidName(name);
        }
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
