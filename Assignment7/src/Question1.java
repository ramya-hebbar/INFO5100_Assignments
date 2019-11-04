import java.io.*;
import java.util.ArrayList;

public class Question1 {

    public static void main(String[] args) throws Exception{

        File inputFile = new File("question1.txt");
        FileInputStream fis = new FileInputStream(inputFile);

        String actualString = getStringFromStream(fis);
        System.out.println("Actual string from file is : " + actualString);

        String reversedString = reverseStringWordByWord(actualString);
        System.out.println("Reversed string is : " + reversedString);

        File outputFile = new File("question1Reverse.txt");
        FileOutputStream fos = new FileOutputStream(outputFile);
        fos.write(reversedString.getBytes());
        fos.close();
    }

    private static String getStringFromStream(FileInputStream fis) throws IOException {
        String finalString = new String();

        while (true) {
            int x = fis.read();
            if (x == -1)
                break;
            char c = (char) x;
            finalString = finalString + c;
        }
        fis.close();

        return finalString;
    }

    public static String reverseStringWordByWord(String enteredString) {
        char[] charsOfString = enteredString.toCharArray();

        ArrayList<Character> charactersOfOneWord = new ArrayList<Character>();

        ArrayList<String> wordsArray = new ArrayList<String>();

        for (int i = 0; i < charsOfString.length; i++) {
            char c = charsOfString[i];

            if (c != ' ') {
                charactersOfOneWord.add(c);

                if (i != charsOfString.length - 1) {
                    continue;
                }
            }

            //store the word parsed so far and add to final array

            StringBuilder builder = new StringBuilder();

            for (Character ch : charactersOfOneWord) {
                builder.append(ch);
            }

            String nextTerm = builder.toString();

            wordsArray.add(nextTerm);

            //reset to accept new values
            charactersOfOneWord = new ArrayList<Character>();
        }

        int totalWords = wordsArray.size();

        String reversedWords = "";

        for (int i = totalWords - 1; i >= 0; i--) {
            reversedWords = reversedWords + wordsArray.get(i);
            reversedWords = reversedWords + " ";
        }

        return reversedWords;
    }
}
