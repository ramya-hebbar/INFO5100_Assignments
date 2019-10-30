import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question4 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap occurrenceMap = new HashMap<Character, Integer>();

        for (int i : arr) {

            int count = 1;

            if (occurrenceMap.get(i) != null) {
                count = (int) occurrenceMap.get(i);
                count++;
            }

            occurrenceMap.put(i, count);
        }

        Collection allValues = occurrenceMap.values();
        Set allValuesSet = new HashSet(occurrenceMap.values());

        if (allValues.size() == allValuesSet.size())
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Finding occurrences");

        int[] array = new int[6];
        array[0] = 1;
        array[1] = 2;
        array[2] = 2;
        array[3] = 1;
        array[4] = 1;
        array[5] = 3;

        Question4 q4 = new Question4();

        if(q4.uniqueOccurrences(array)) {
            System.out.println("Occurrences are unique!");
        }
        else {
            System.out.println("Occurrences are not unique!");
        }

        array = new int[3];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;

        if(q4.uniqueOccurrences(array)) {
            System.out.println("Occurrences are unique!");
        }
        else {
            System.out.println("Occurrences are not unique!");
        }
    }
}
