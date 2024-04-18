package org.example.Exercises.Exercises_JavaPrimer;

import java.util.Arrays;

public class Thirteenth {
    public static void main(String[] args) {
        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new CreditCard("John Bowman", "California savings", "5391 0375 9387 5309", 5000, 0);
        wallet[1] = new CreditCard("John Bowman", "California Federal", "3485 0399 3395 1954", 3500, 0);
        wallet[2] = new CreditCard("John Bowman", "California Finance", "5391 0375 9387 5309", 2500, 300);
        for (int val = 1; val <= 58; val++) { // before was 16 instead of 58
            wallet[0].charge(3 * val); // wallet[0] reach the limit with 58 loops
            wallet[1].charge(2 * val);
            wallet[2].charge(val);
        }
        System.out.println(Arrays.toString(wallet)
                .replace(",", "\n")
                .replace("{", "\n\n{")
        );

        /*  OUTPUT
                    [CreditCard

                    {customer='John Bowman'
                     bank='California savings'
                     account='5391 0375 9387 5309'
                     limit=5000
                     balance=4959.0}
                     CreditCard

                    {customer='John Bowman'
                     bank='California Federal'
                     account='3485 0399 3395 1954'
                     limit=3500
                     balance=3422.0}
                     CreditCard

                    {customer='John Bowman'
                     bank='California Finance'
                     account='5391 0375 9387 5309'
                     limit=2500
                     balance=2011.0}]
         */
    }
}