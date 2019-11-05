import java.util.ArrayList;
import java.util.Stack;

public class Question2 {

    public String decodeTheString(String encodedString) {
        String decodedString = new String();

        char[] allChars = encodedString.toCharArray();

        int i = 0;

        char ch = allChars[i];

        Stack<String> charactersOfFinalString = new Stack<String>();

        int n = 0;

        while (i < allChars.length - 1) {
            while (Character.isDigit(ch)) {
                n = n * 10 + Character.getNumericValue(ch);
                ch = allChars[++i];
            }

            if(n == 0) {
                n = 1;
            }

            if (ch == '[') {
                ch = allChars[++i];
            }

            while (Character.isLetter(ch)) {

                if (charactersOfFinalString.size() > 0) {
                    String existingString = charactersOfFinalString.pop();
                    existingString = existingString + Character.toString(ch);
                    charactersOfFinalString.push(existingString);
                } else {
                    charactersOfFinalString.push(Character.toString(ch));
                }

                if (i + 1 < allChars.length) {
                    ch = allChars[++i];
                }
                else {
                    ch = ']';
                }
            }

            if (ch == ']') {
                if (i + 1 < allChars.length) {
                    ch = allChars[++i];
                }

                String stringToAppend = null;

                if (charactersOfFinalString.size() > 0) {
                    stringToAppend = charactersOfFinalString.pop();

                    //construct string here
                    for (int j = 0; j < n; j++) {
                        decodedString = decodedString + stringToAppend;
                    }

                    n = 0;
                }
            } else {
                //internal string - loop with existing values
                String internalString = new String();

                while (ch != ']') {
                    internalString = internalString + Character.toString(ch);
                    ch = allChars[++i];
                }

                internalString = internalString + Character.toString(ch);

                String finalInternalString = decodeTheString(internalString);

                if (charactersOfFinalString.size() > 0) {
                    String existingString = charactersOfFinalString.pop();
                    existingString = existingString + finalInternalString;
                    charactersOfFinalString.push(existingString);
                }
            }
        }

        return decodedString;
    }

    public static void main(String[] args) {

        Question2 q2 = new Question2();
        System.out.println("Encoded string 3[a]2[bc] is decoded to : " + q2.decodeTheString("3[a]2[bc]"));
        System.out.println("Encoded string 3[a2[c]] is decoded to : " + q2.decodeTheString("3[a2[c]]"));
        System.out.println("Encoded string 2[abc]3[cd]ef is decoded to : " + q2.decodeTheString("2[abc]3[cd]ef"));
    }
}
