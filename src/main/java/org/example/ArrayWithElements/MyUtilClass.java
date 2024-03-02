package org.example.ArrayWithElements;

import org.example.DataStructure.LinkedList.LinkedList;
import org.example.DataStructure.LinkedList.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyUtilClass {
    public static String path = "src/main/java/org/example/ArrayWithElements/unsortedNums.txt";

    public static void main(String[] args) throws IOException {
//        generateNumbersInTxt(100_000);
        String[] values = {"a", "a s", "a c", "b"};
        System.out.println(
                isSorted(values));

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
                names.add(line.trim());
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return names.toArray(new String[0]);
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1].compareTo(arr[i]) > 0) {//arr[i - 1] > arr[i]
                System.out.println("Previous: " + arr[i - 1] + " Current: " + arr[i]+" index: "+i);
                return false;
            }

        return true;
    }

    public static <T extends Comparable<T>> boolean isSorted(LinkedList<T> arr) {
        if (arr.size() <= 1) return true;

        Node<T> current = arr.getHead();
        while (current.getNext() != null) {
            if (current.getData().compareTo(current.getNext().getData()) > 0) //current.getData() > current.getNext().getData()
                return false;
            current = current.getNext();
        }

        return true;
    }


}
