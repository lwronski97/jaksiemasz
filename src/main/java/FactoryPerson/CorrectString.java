package FactoryPerson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorrectString {
    public boolean checkIfHaveNumbers(String name) {
        Pattern p = Pattern.compile("([0-9])");
        Matcher m = p.matcher(name);
        return m.find();
    }

    public boolean correctEmail(String email)  {
        Pattern p = Pattern.compile(".*@.*\\....");
        Matcher m = p.matcher(email);
        return m.find();
    }
}
