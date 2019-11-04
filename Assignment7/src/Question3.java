import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Question3 {
    private HashMap<String, String> countOfLinesData;

    public static void main(String[] args) throws Exception {

        System.out.println("Enter the names of files to count lines from - type exit once done");

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> filesList = new ArrayList<String>();

        while (true) {
            String fileName = scanner.nextLine();

            if (fileName.equals("exit"))
                break;

            filesList.add(fileName);
        }

        Question3 q3 = new Question3();
        q3.getLinesCountForFiles(filesList);
    }

    public void getLinesCountForFiles(ArrayList<String> filesList) throws Exception {
        this.countOfLinesData = new HashMap<>();

        for (String fileName: filesList) {
            File inputFile = new File(fileName);
            FileInputStream fis = null; //new FileInputStream(inputFile);
            BufferedReader reader = null;

            try {
                fis = new FileInputStream(inputFile);
                reader = new BufferedReader(new InputStreamReader(fis));

                String line = reader.readLine();

                int lineCount = 0;

                while (line != null) {
                    lineCount++;
                    line = reader.readLine();
                }

                //store the name and line count into HashMap
                countOfLinesData.put(fileName, Integer.toString(lineCount));

                reader.close();
                fis.close();
            }
            catch (FileNotFoundException fe) {
                countOfLinesData.put(fileName, "ERROR: This file does not exist.");
            }
            catch (IOException ioe) {
                countOfLinesData.put(fileName, "ERROR: Unable to read file contents.");
            }
        }

        System.out.println("Count of lines :");

        Set<String> keySet = countOfLinesData.keySet();

        for (String key: keySet) {
            String lineCount = countOfLinesData.get(key);

            if(lineCount.contains("ERROR")) {
                System.out.println(key + " " + lineCount);
            }
            else {
                System.out.println(key + " has " + lineCount + " lines");
            }
        }
    }
}
