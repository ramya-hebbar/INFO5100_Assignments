import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Course {
    private int courseId;
    private String courseName;
    private int maxCapacity;
    private int professorId;
    private int credits;
    private int[] studentIds;

    private int studentCounter;

    //Constructors

    public Course(int courseId) {
        if (courseId > 0) {

            System.out.println("Initialising new course with course ID : " + courseId);

            this.courseId = courseId;
        } else {
            System.out.print("Invalid course ID");
        }
    }

    public Course(int courseId, int professorId) {
        int profIdLength = String.valueOf(professorId).length();

        if (courseId > 0 && profIdLength == 6) {

            System.out.println("Initialising new course with course ID : " + courseId + "and professor ID : " + professorId);

            this.courseId = courseId;
            this.professorId = professorId;
        } else {
            System.out.print("Course ID or Professor ID not matching criteria");
        }
    }

    public Course(int courseId, int professorId, int credits) {
        int profIdLength = String.valueOf(professorId).length();
        int creditLength = String.valueOf(credits).length();

        if (courseId > 0 && profIdLength == 6 && credits > 0 && creditLength == 1) {

            System.out.println("Initialising new course with course ID : " + courseId +
                    "and professor ID : " + professorId +
                    "and credits :" + credits);

            this.courseId = courseId;
            this.professorId = professorId;
            this.credits = credits;
        } else {
            System.out.print("Course ID or Professor ID or Credits not matching criteria");
        }
    }

    //Getters

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getProfessorId() {
        return professorId;
    }

    public int getCredits() {
        return credits;
    }

    public int[] getStudentIds() {
        return studentIds;
    }

    public int getStudentCounter() {
        return studentCounter;
    }

    //Setters

    public void setCourseId(int courseId) {
        if (courseId > 0) {
            this.courseId = courseId;
        } else {
            System.out.println("Course ID not matching criteria");
        }
    }

    public void setCourseName(String courseName) {
        int courseLength = courseName.length();

        if (courseLength >= 10 && courseLength <= 60) {
            this.courseName = courseName;
        } else {
            System.out.println("Course name not matching criteria");
        }
    }

    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity >= 10 && maxCapacity <= 100) {
            this.maxCapacity = maxCapacity;
        } else {
            System.out.println("Maximum capacity not matching criteria");
        }
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setStudentIds(int[] studentIds) {
        this.studentIds = studentIds;
    }

    public void setStudentCounter(int studentCounter) {
        this.studentCounter = studentCounter;
    }

    //Functions

    /* Question 1 */

    public void registerStudent(int studentId) {
        int currentCount = getStudentCounter();

        studentIds[currentCount] = studentId;
        setStudentCounter(currentCount + 1);
    }

    /* Question 3 */

    public int[] removeDuplicates(int[] studentIds) {

        ArrayList<Integer> mutableStudentIds = new ArrayList<Integer>();

        for (int studentId : studentIds) {
            if (studentId > 0) { //picking only entered student IDs and not default integer array values
                mutableStudentIds.add(studentId);
            }
        }

        System.out.println("Mutable student IDs : " + mutableStudentIds);

        ArrayList<Integer> finalStudentIds = new ArrayList<Integer>();

        for (int i = 0; i < mutableStudentIds.size(); i++) {
            if (finalStudentIds.contains(mutableStudentIds.get(i))) {
                System.out.println("Duplicate ID - let's continue");
                continue;
            }
            finalStudentIds.add(mutableStudentIds.get(i));
        }

        System.out.println("Final student IDs : " + finalStudentIds + " of size " + finalStudentIds.size());

        int[] cleanStudentIds = new int[finalStudentIds.size()];

        for (int i = 0; i < finalStudentIds.size(); i++) {
            System.out.println("Value = " + finalStudentIds.get(i).intValue());

            cleanStudentIds[i] = finalStudentIds.get(i).intValue();

            System.out.println("Value in final array = " + cleanStudentIds[i]);
        }

        return cleanStudentIds;
    }

    /* Question 4 */
    public int groupsOfStudents(int[] studentIds) {
        int count = 0;

        ArrayList<Integer> mutableStudentIds = new ArrayList<Integer>();

        for (int studentId : studentIds) {
            if (studentId > 0) { //picking only entered student IDs and not default integer array values
                mutableStudentIds.add(studentId);
            }
        }

        for (int i = 0; i < mutableStudentIds.size(); i++) {
            for (int j = i + 1; j < mutableStudentIds.size(); j++) {
                if ((mutableStudentIds.get(i) + mutableStudentIds.get(j)) % 2 == 0) {
                    count++;

                    System.out.println("Current count is :" + count);
                }
            }

        }

        return count;
    }

    /* Question 5 */
    public String countAndSay(int n) {

        ArrayList<String> countAndSaySequence = new ArrayList<String>();

        countAndSaySequence.add(0, "1"); //1st element is always one

        for (int i = 1; i < n; i++) {

            //logic to churn out the sequence
            String prevTerm = countAndSaySequence.get(i - 1);

            char[] charactersOfPrevTerm = prevTerm.toCharArray();

            ArrayList<Character> charactersOfNextTerm = new ArrayList<Character>();

            int characterCount = 1;

            for (int j = 0; j < charactersOfPrevTerm.length; j++) {

                if (j + 1 < charactersOfPrevTerm.length && charactersOfPrevTerm[j] == charactersOfPrevTerm[j + 1]) {
                    characterCount++;
                } else {
                    //change in character - store value and reset counter
                    charactersOfNextTerm.add(Character.forDigit(characterCount, 10));
                    charactersOfNextTerm.add(charactersOfPrevTerm[j]);

                    characterCount = 1;
                }
            }

            //building final string from characters
            StringBuilder builder = new StringBuilder();

            for (Character c : charactersOfNextTerm) {
                builder.append(c);
            }

            String nextTerm = builder.toString();

            countAndSaySequence.add(nextTerm);
        }

        String sequenceRequested = countAndSaySequence.get(n - 1);

        return sequenceRequested;
    }

    /* Question 6 */

    public void reverseStringWordByWord(String enteredString) {
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

        System.out.println("Final reverse : " + reversedWords);
    }

    /* Question 7 */
    public int[] spiralOrder(int[][] matrix) {

        int i = 0;
        int j = 0;

        int m = matrix[0].length;
        int n = matrix[1].length;

        //to eliminate boundaries upon spiraling
        int a = 0;
        int b = 0;

        int[] spiralOrderArray = new int[m * n];

        //to hold final array index
        int x = 0;

        do {
            while (j < n) {
                spiralOrderArray[x++] = matrix[i][j]; // first row
                j++;
            }

            j--;
            i++;

            while (i < m) {
                spiralOrderArray[x++] = matrix[i][j]; // last column
                i++;
            }

            i--;
            j--;

            while (j >= b) {
                spiralOrderArray[x++] = matrix[i][j]; // last row in reverse
                j--;
            }

            j++;
            i--;

            while (i > a) {
                spiralOrderArray[x++] = matrix[i][j]; // first column in reverse
                i--;
            }

            i++;
            j++;

            //decrease row & column to eliminate outer border
            m--;
            n--;
            a++;
            b++;
        } while (i < m && j < n);

        for (int k = 0; k < spiralOrderArray.length; k++) {
            System.out.println(spiralOrderArray[k]);
        }

        return spiralOrderArray;
    }

    /*Question 8*/
    String convert(String s, int numRows) {

        int lengthOfInputString = s.length();

        char[][] finalMatrix = new char[numRows][lengthOfInputString];

        char[] charactersOfString = s.toCharArray();

        int i = 0; //for rows
        int j = 0; //for columns

        boolean shouldDecrement = false;

        do {
            finalMatrix[i][j] = charactersOfString[j];
            j++;

            if (i == numRows - 1) {
                shouldDecrement = true;
            }

            if(i == 0) {
                shouldDecrement = false;
            }

            if(shouldDecrement) {
                i--;
            }
            else {
                i++;
            }

        } while (j < lengthOfInputString);

        ArrayList<Character> charactersOfZigZagPattern = new ArrayList<Character>();

        for (int k = 0; k < numRows; k++) {
            for (int l = 0; l < lengthOfInputString; l++) {

                char ch = finalMatrix[k][l];

                if(ch != 0) {
                    charactersOfZigZagPattern.add(ch);
                }
            }
        }

        StringBuilder builder = new StringBuilder();

        for (Character ch : charactersOfZigZagPattern) {
            builder.append(ch);
        }

        String finalZigZagString = builder.toString();

        System.out.println("Final zigzag pattern is : " + finalZigZagString);

        return finalZigZagString;
    }

    /* Theory questions

    Q9. Explain Encapsulation with an example. (Write at least 30-40 words).

        Encapsulation means to contain the elements of an object in order to keep them together and keep them protected.
        Bundling a bunch of variables, methods and data together is done in order to restrict certain components of the objects.
        The importance of encapsulation is for the object to not allow anything about itself accessible except for things which are absolutely necessary for other parts of the program to work.

        Example: In the current class Course, all the variables are declared with the access specifier "private" to ensure that the scope of that variable is limited only to the parts of the current class.
        In case there are other parts of the program which require an access to the values of those variables, they can fetch the same information by using the getter and setter methods.

    Q10. What is the difference between Encapsulation and Abstraction?

        Encapsulation is to ensure that the access to a particular object is limited or restricted in order to keep them protected from other parts of the program manipulating them.


        Abstraction means the concept of something. It is basically concentrating on the overall picture rather than giving attention to detail. It is not attached to any specific instance.
        Ex: A class named Fruit can be considered as an abstract class.
        It can contain information such as name, weight, colour etc. which are common attributes not specifically attached to anything.
    */

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //For testing

    public static void main(String[] args) {
        Course course = new Course(5100);
        course.studentIds = new int[100]; //initializing with max capacity

        course.setStudentCounter(0);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 6 student IDs");

        for (int i = 0; i < 6; i++) {
            int enteredStudentId = scanner.nextInt();

            course.registerStudent(enteredStudentId);
        }

        /*Q3-DONE*/
        int[] duplicatesRemoved = course.removeDuplicates(course.studentIds);

        System.out.println("Final set of students are : \n");

        for (int i = 0; i < duplicatesRemoved.length; i++) {
            System.out.println(duplicatesRemoved[i]);
        }

        /*Q4-DONE*/
        System.out.println("Number of even pairs : " + course.groupsOfStudents(course.studentIds));

        /*Q5-DONE
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter integer for count-and-say sequence");

        int enteredInteger = scanner.nextInt();
        String sequenceString = course.countAndSay(enteredInteger);

        System.out.println("Returned value is : " + sequenceString);*/

        /*Q6-DONE*/
        course.reverseStringWordByWord("the sky is blue");

        /*Q7-DONE*/
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; //3X3
//        int[][] matrix = {{1, 2, 3, 100}, {4, 5, 6, 200}, {7, 8, 9, 300}, {10, 11, 12, 400}}; //4X4
//        int[][] matrix = {{1, 2, 3, 100, 600}, {4, 5, 6, 200,700}, {7, 8, 9, 300,800}, {10, 11, 12, 400,900}, {13,14,15,500,1000}}; //5X5
        System.out.println("Matrix rows = " + matrix[0].length + " Matrix columns = " + matrix[1].length);
        course.spiralOrder(matrix);

        /*Q8-DONE*/
        course.convert("PAYPALISHIRING", 4);
    }
}
