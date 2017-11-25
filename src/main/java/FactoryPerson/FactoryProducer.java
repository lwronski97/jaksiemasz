package FactoryPerson;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){

        if(choice.equalsIgnoreCase("Person")){
            return new PersonFactory();
        }

        return null;
    }
}