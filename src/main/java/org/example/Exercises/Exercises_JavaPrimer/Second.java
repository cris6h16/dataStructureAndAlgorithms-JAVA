package org.example.Exercises.Exercises_JavaPrimer;

public class Second {
    public static void main(String[] args) {

        GameEntry[] A = new GameEntry[5];
        A[4] = new GameEntry(100);

        GameEntry[] B = A.clone();



    }







    static class GameEntry {
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
    }
}