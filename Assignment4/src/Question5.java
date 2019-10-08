import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter input string for permutation output");

        Question5 q5 = new Question5();

        int[] permutationArray = q5.getPermutationForString(scanner.next());

        System.out.println("Permutation array is : [");

        for (int i = 0; i < permutationArray.length; i++) {
            if(i == permutationArray.length-1) {
                System.out.println(permutationArray[i]);
            }
            else {
                System.out.println(permutationArray[i] + ", ");
            }
        }

        System.out.println("]");
    }

    public int[] getPermutationForString(String s) {

        int n = s.length();

        ArrayList<Integer> itemsArray = new ArrayList<Integer>();

        for (int i = 0; i <= n; i++) {
            itemsArray.add(i);
        }

        char[] charsOfString = s.toCharArray();

        ArrayList<Integer> permutationArray = new ArrayList<>();

        int i = 0;
        int j = n;

        int k = 0;

        while(i != j) {

            char ch = charsOfString[k++];

            if(ch == 'I') {
                permutationArray.add(itemsArray.get(i++));
            }
            else {
                permutationArray.add(itemsArray.get(j--));
            }
        }

        permutationArray.add(itemsArray.get(i));

        int[] finalArray = new int[permutationArray.size()];

        for (int z = 0; z < permutationArray.size(); z++) {
            finalArray[z] = permutationArray.get(z).intValue();
        }

        return finalArray;
    }
}
