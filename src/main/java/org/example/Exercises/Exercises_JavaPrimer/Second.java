package org.example.Exercises.Exercises_JavaPrimer;

public class Second {
    public static void main(String[] args) {
        Second second = new Second();
        second.exercise();
    }

    public void exercise(){

        GameEntry[] A = new GameEntry[5];
        A[4] = new GameEntry(100);

        GameEntry[] B = A.clone();

        B[4].setScore(550);

        System.out.println(A[4]);
        System.out.println(B[4]);

        /* Output:

            GameEntry{score=550}
            GameEntry{score=550}



            Why?: Don't forget that arrays which aren't in-built types are reference
            you have the same reference in both arrays.

            You change A also the B will change

         */

    }







    class GameEntry {
        private int score;

        public GameEntry(int score) {
            this.score = score;
        }

        public GameEntry(GameEntry gameEntry) { // prototype design pattern
            this.score = gameEntry.score;
        }

        public GameEntry clone() {//
            return new GameEntry(this);
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "GameEntry{" +
                    "score=" + score +
                    '}';
        }
    }
}