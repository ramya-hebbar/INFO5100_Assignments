import java.util.ArrayList;

public class Question2 {

    public String decodeTheString(String encodedString) {
        String decodedString = ";";

        char[] allChars = encodedString.toCharArray();

        int i = 0;

        char ch = allChars[i];

        ArrayList<Character> charactersOfFinalString = new ArrayList<Character>();

        while (i < allChars.length) {

            int n = 0;

            while(Character.isDigit(ch)) {
                n = n*10 + Character.getNumericValue(ch);
                ch = allChars[++i];
            }

            if(ch == '[' ) {
                ch = allChars[++i];
            }

            while(Character.isLetter(ch)) {
                charactersOfFinalString.add(ch);
                ch = allChars[++i];
            }

            if(Character.isDigit(ch)) {
                //add internal string
            }
            else if(ch == ']') {
                ch = allChars[++i];

                //construct string here
            }

//            if(allChars[i+1] )

        }

        return decodedString;
    }

    public static void main(String[] args) {

    }
}
