package FactoryPerson;

import org.omg.CORBA.ORBPackage.InvalidName;

public class PersonFactory extends AbstractFactory {

    @Override
    public Person getPerson() throws InvalidName {
        RandomString r = new RandomString();
        return new Person(r.getName(), r.getSurname(), r.getEmail());
    }
}
