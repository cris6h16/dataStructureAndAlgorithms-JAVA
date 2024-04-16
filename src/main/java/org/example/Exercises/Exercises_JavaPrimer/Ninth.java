package org.example.Exercises.Exercises_JavaPrimer;

public class Ninth {
    public static void main(String[] args) {
        System.out.println(removePunctuation("Hello!, I'm from Ecuador!!")); // Hello Im from Ecuador
    }

    private static String removePunctuation(String s) {
        StringBuilder sb = new StringBuilder(s); // is mutable, the major diff with String
        int count = 0;
        while (count <= sb.length()) {
            int idx1 = sb.indexOf("\'");
            int idx2 = sb.indexOf("!");
            int idx3 = sb.indexOf(",");

            if (idx1 != -1) sb.deleteCharAt(idx1);
            if (idx2 != -1) sb.deleteCharAt(idx2);
            if (idx3 != -1) sb.deleteCharAt(idx2);

            count++;
        }

        return sb.toString();
    }
}
