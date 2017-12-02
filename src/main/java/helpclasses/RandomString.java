package helpclasses;

import java.util.Random;

public class RandomString {

    final static Random r = new Random();
    final static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private String generateString( int length ) {
        StringBuilder newString = new StringBuilder();
        for ( int i = 0; i < length; i++ ) {
            newString.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        return newString.toString();
    }

    public String getName(){
        return generateString(r.nextInt(6)+3);
    }

    public String getSurname(){
        return generateString(r.nextInt(8)+3);
    }

    public String getEmail(){
        return generateString(r.nextInt(8)+3)
                + "@"
                + generateString(r.nextInt(3)+3)
                + "."
                + generateString(3);
    }
}
