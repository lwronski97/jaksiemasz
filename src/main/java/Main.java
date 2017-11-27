import FactoryPerson.AbstractFactory;
import FactoryPerson.FactoryProducer;
import FactoryPerson.Person;
import com.google.common.collect.Ordering;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Main {



    public static void main(String[] args)  {

        AbstractFactory pearsonFactory = FactoryProducer.getFactory("Person");
        List<Person> toSort = new ArrayList<>();
        Integer listSize = 1000;

        for ( int i = 0; i < listSize; i++ ) {
            Person newpearson = pearsonFactory.getPerson();
            toSort.add(newpearson);
        }

        Ordering<Person> byLength = Ordering.natural().lexicographical().onResultOf(new com.google.common.base.Function<Person, Iterable<Comparable>>() {
            @Nullable
            @Override
            public Iterable<Comparable> apply(@Nullable Person input) {
                String names[] = {input.getName(),input.getSurname(),input.getEmail()};
                Iterable<Comparable> iterable = Arrays.asList(names);
                return iterable;
            }
        });
        Collections.sort(toSort, byLength);

        for ( Person person : toSort){
            System.out.println(person);
        }

    }

}
