package org.example.ArrayWithElements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyUtilClass {
    public static String path = "src/main/java/org/example/ArrayWithElements/unsortedNums.txt";

    public static void main(String[] args) throws IOException {
//        generateNumbersInTxt(1_000_000);
        String[] names = {"b", "b"};
        System.out.println(isSorted(names));
    }

    /**
     * @param isLessThis
     * @param comparedToThis
     * @return true, if first value is less, or equals the second -
     * false, the first value is greater than the second
     */
    public static boolean isLessOrEqualsStr(String isLessOrEqualsThis, String comparedToThis) {
        Boolean isLessOrEquals = false;

        if (isLessOrEqualsThis.trim().compareTo(comparedToThis) == 0) {//equals
            isLessOrEquals = true;
        }
        if (isLessOrEqualsThis.trim().compareTo(comparedToThis) < 0) {//less
            isLessOrEquals = true;
        }
        if (isLessOrEqualsThis.trim().compareTo(comparedToThis) > 0) {
            isLessOrEquals = false;
        }

        return isLessOrEquals;
    }


    public static void generateNumbersInTxt(int quantity) throws IOException {
        File file = new File(path);

        if (file.delete()) System.out.println("File deleted");
        if (file.createNewFile()) System.out.println("File created");

        try (FileWriter f = new FileWriter(path);) {

            for (int i = 0; i < quantity; i++)
                f.write((int) Math.floor(Math.random() * (1_000_000 - -1_000_000 + 1) + -1_000_000) + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer[] getNumsArray() {
        String fileName = path; // Replace "numbers.txt" with the path to your file
        List<Integer> numbersList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by whitespace and convert each token to an integer
                String[] tokens = line.trim().split("\\s+");
                for (String token : tokens) {
                    numbersList.add(Integer.parseInt(token));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert the list to an array
        Integer[] numbersArray = numbersList.toArray(new Integer[0]);

        return numbersArray;
    }

    public static String[] getNamesArray() {
        String fileName = path.replace("unsortedNums", "names"); // Replace "numbers.txt" with the path to your file
        List<String> names = new ArrayList<String>(30_000);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();

            while (line != null) {
                names.add(line.trim().replace(" ", ""));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return names.toArray(new String[0]);
    }

    public static boolean isSorted(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (!(arr[i - 1].equals(arr[i])) && !isLessOrEqualsStr(arr[i - 1], arr[i])) {
//                System.out.println(i + " " + arr[i - 1] + " " + arr[i]);
                return false;
            }
        }
        return true;
    }

}
