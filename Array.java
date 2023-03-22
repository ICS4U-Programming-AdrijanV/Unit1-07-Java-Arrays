// This program reads a file with numbers on it.
// It then calculates the mean, median, and range.
 
// Importing input output classes
import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.util.Arrays;
 
// Main class
public class Array {

    /**
    * This is method calculates the mean.
    *
    * @param arrayNum //
    * @return mean
    */
    public static double calcMean(int[] numArray) {
        int sum = 0;
        
        // int arrayLength = arrayNum.length;
        for (int counter = 0; numArray.length > counter; counter++) {
            sum += numArray[counter];
        }
        double mean = (double) sum / numArray.length;
        return mean;
    }

    /**
        * This is method calculates the median.
        *
        * @param numArray //
        * @return median
        */
    public static double calcMedian(int[] numArray) {
        Arrays.sort(numArray);
        double median;
        int middle = numArray.length / 2;
        if (numArray.length % 2 == 0) {
            median = (double) (numArray[middle - 1] + numArray[middle]) / 2;
        } else {
            median = numArray[middle];
        }
        return median;
    }

    public static int calcMode(int[] numArray) {
        int mode = 1;
        // int maxCount = 0;
        // int mode = numArray[0];
        // for (int element = 0; element < numArray.length; element++) {
        //     int count = 0;
        //     for (int compareElement = 0; compareElement < numArray.length; compareElement++) {
        //         if (numArray[compareElement] == numArray[currentElement]) {
        //             count++;
        //         }
        //     }
        //     if (count > maxCount) {
        //         maxCount = count;
        //         mode = numArray[currentElement];
        //     }
        // }
        return mode;
    }



 
    // main driver method
    public static void main(String[] args) throws Exception {
 
        // File path is passed as parameter
        File file = new File("Unit1-07-set1.txt");
        //FileWriter myWriter = new FileWriter("output.txt");
        Scanner sc = new Scanner(file);

        // Creating the array list
        ArrayList<Integer> numList = new ArrayList<Integer>();
 
        // Declaring a string variable
        String str;
        // Condition holds true till
        // there is character in a string

            // For loop to print the list.
            while (sc.hasNextLine()) {
                str = sc.nextLine();
            
                // adding each integer to arraylist
                numList.add(Integer.parseInt(str));
            }
            // Create array of int.
            int numArray[] = new int[numList.size()];

            // Create counter.
            int counter = 0;

            // convert any arraylist to array
            for (int number : numList) {
                

                // Put number into num array at counter position.
                numArray[counter] = number;
                counter++;
                System.out.print(number + " ");
            }
            // Call median, mode, and mean.
            final double median = calcMedian(numArray);
            final double mode = calcMode(numArray);
            final double mean = calcMean(numArray);
            // Print the mean, median, mode.
            System.out.println(" ");
            System.out.println("The median is: " + median);
            System.out.println("The mode is: " + mode);
            System.out.println("The mean is: " + mean);
    }
    //myWriter.close();
}

