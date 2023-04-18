import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import java.lang.Math;
import java.text.DecimalFormat;

public class Main {
    static void generateRandomNumbers(int numberOfNumbers, int maxRangeNumber){
        ArrayList<Integer> numsArr = new ArrayList<>();

        //Loop to add random numbers on arraylist
        for(int i = 0; i < numberOfNumbers; i++){
            int randomNumber = (int)(Math.random() * maxRangeNumber + 1);
            numsArr.add(randomNumber);
        }

        //Sorting the numbers of the arralist
        Collections.sort(numsArr);

        int minNumber = numsArr.get(0);
        int maxNumber = numsArr.get(0);
        double totalSum = 0; 
            DecimalFormat numberFormat = new DecimalFormat("#.00");
        double median = 0;
        ArrayList<ArrayList<Integer>> modes = new ArrayList<>();

        for(int n : numsArr){
            //Min number:
            if(n < minNumber){
                minNumber = n;
            }

            //Max number:
            if(n > maxNumber){
                maxNumber = n;
            }

            //Total sum
            totalSum += n;

            //Check if numsArr length is odd or even to get the Median
            if(numsArr.size() % 2 == 1){
                int number = numsArr.get(numsArr.size() / 2);
                median = number;
            } else {
                int num01 = numsArr.get(numsArr.size() / 2 -1);
                int num02 = numsArr.get(numsArr.size() / 2 );

                median = (num01 + num02) / 2;
            }
        }

        //Getting MODE
        for(int it = 0; it < numsArr.size(); it++){
            for(int i = it + 1; i < numsArr.size(); i++){
                if (numsArr.get(it) == numsArr.get(i)){
                    ArrayList<Integer> repeated = new ArrayList<>();
                    repeated.add(numsArr.get(it));
                    repeated.add(numsArr.get(i));
                    modes.add(repeated);
                }
            }
        }

        numberFormat.format(totalSum);

        int highestScenario = (maxRangeNumber + 1) * numberOfNumbers;
        int highestScenarioToUser = maxRangeNumber * numberOfNumbers;

        String printThis = 
            "Statistic of %d random numbers in the inclusive range of 0 to %d:\n\n" +
            "Numbers generated:\n" + numsArr + 
            "\nMean: " + totalSum / numsArr.size() + 
            "\nMedian: " + median +
            "\nMode:" + modes +
            "\nLowest Number: " + minNumber + 
            "\nHighest Number: " + maxNumber +
            "\nCount n: " + numsArr.size() +
            "\nSum: " + totalSum +
            "\nPercentage of total sum to the highest sum scenario (%d): %.2f%s";
        
            JOptionPane.showMessageDialog(null, String.format(printThis, numberOfNumbers, maxRangeNumber, highestScenarioToUser, (totalSum / highestScenario)*100, "%"));

        main(null);
    }
    

    static void menu(){
        String numberOfNumbersString = JOptionPane.showInputDialog(null, "How many numbers do you want to generate?\n Type 0 to exit.");
            int numberOfNumbers = Integer.parseInt(numberOfNumbersString);
        String maxRangeString = JOptionPane.showInputDialog(null, "Type the maximun number (From zero to ...)\n Type 0 to exit.");
            int maxRange = Integer.parseInt(maxRangeString);

        if(numberOfNumbers == 0 || maxRange == 0){
            System.exit(0);
        } else {
            generateRandomNumbers(numberOfNumbers, maxRange);
        }

    }

    public static void main(String[] args){
        try {
            menu();
        } catch (NumberFormatException e) {
            main(args);
        }
    }
}