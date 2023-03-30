import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import java.lang.Math;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args){

        ArrayList<Integer> numsArr = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            int randomNumber = (int)(Math.random() * 1001);
            numsArr.add(randomNumber);
        }

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

            //Check if numsArr length is odd or even to get the Media
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
                    ArrayList<Integer> repetiu = new ArrayList<>();
                    repetiu.add(numsArr.get(it));
                    repetiu.add(numsArr.get(i));
                    modes.add(repetiu);
                }
            }
        }

        numberFormat.format(totalSum);

        String printThis = 
            "Statistic of 10 random numbers in the inclusive range of 0 to 1000:\n\n" +
            "Numbers generated:\n" + numsArr + 
            "\nMean: " + totalSum / numsArr.size() + 
            "\nMedian: " + median +
            "\nMode:" + modes +
            "\nLowest Number: " + minNumber + 
            "\nHighest Number: " + maxNumber +
            "\nCount n: " + numsArr.size() +
            "\nSum: " + totalSum +
            "\nPercentage of the current total sum to the highest sum scenario (10.000): " + (totalSum / 10000)*100 + "%";
        JOptionPane.showMessageDialog(null, printThis);
    }
}