package FactoryPerson;

public class PersonFactory extends AbstractFactory {
    private final static RandomString randomString = new RandomString();
    @Override
    public Person getPerson() {
        return new Person(randomString.getName(), randomString.getSurname(), randomString.getEmail());
    }
}
