package org.example.ArrayWithElements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GenerateNumbersInTxt {
    public static String path = "/home/cristian/personal/intellij/IdeaProjects/DataStructureAndAlgorithms/src/main/java/org/example/WriteTxt/unsortedNums.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(path);

        if (file.delete()) System.out.println("File deleted");
        if (file.createNewFile()) System.out.println("File created");

        try (FileWriter f = new FileWriter(path);) {

            for (int i = 0; i < 1_000_000; i++)
                f.write(String.valueOf((int) (Math.random() * 1_000_000)) + "\n");

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

    public static boolean isSorted(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
