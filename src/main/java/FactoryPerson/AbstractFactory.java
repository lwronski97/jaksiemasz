package FactoryPerson;

import org.omg.CORBA.ORBPackage.InvalidName;

public abstract class AbstractFactory {
    public abstract Person getPerson() throws InvalidName;
}
