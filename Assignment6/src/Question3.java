import java.util.HashMap;
import java.util.Scanner;

public class Question3 {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        char[] charsOfString1 = s.toCharArray();

        HashMap s1Map = new HashMap<Character, Integer>();

        for (char c : charsOfString1) {

            int count = 1;

            if (s1Map.get(c) != null) {
                count = (int) s1Map.get(c);
                count++;
            }

            s1Map.put(c, count);
        }

        char[] charsOfString2 = t.toCharArray();

        HashMap s2Map = new HashMap<Character, Integer>();

        for (char c : charsOfString2) {

            int count = 1;

            if (s2Map.get(c) != null) {
                count = (int) s2Map.get(c);
                count++;
            }

            s2Map.put(c, count);
        }

        if (s1Map.equals(s2Map))
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Enter strings to check if they are anagrams!");

        System.out.println("String 1 : ");

        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();

        System.out.println("String 2 : ");

        String t = scanner.next();

        Question3 q3 = new Question3();

        boolean result = q3.isAnagram(s, t);

        if (result) {
            System.out.println("Entered strings are anagrams!");
        } else {
            System.out.println("Entered strings are not anagrams!");
        }
    }
}
