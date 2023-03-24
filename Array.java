// Importing
import java.util.Arrays;
import java.util.Scanner;

/**
* This is the public class.
*
* @author Adrijan
* @version 1.0
* @since   2023-03-22
*/
public final class Array {

    /**
     * This is a private constructor used to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private BoardFoot() {
        throw new IllegalStateException("Utility class.");
    }

    /**
    * This is method calculates the mean.
    *
    * @param numArray //
    * @return mean
    */
    public static double calcMean(int[] numArray) {
        int sum = 0;

        // For loop to add all the numbers in the array.
        for (int counter = 0; numArray.length > counter; counter++) {
            sum += numArray[counter];
        }

        // Calculate the mean.
        final double mean = (double) sum / numArray.length;

        // Return the mean.
        return mean;
    }

    /**
        * This is method calculates the median.
        *
        * @param numArray //
        * @return median
        */
    public static double calcMedian(int[] numArray) {

        // Sort the array so we can get the median.
        Arrays.sort(numArray);

        // Set median.
        final double median;

        // Find the middle of the array.
        final int middle = numArray.length / 2;

        // If statement to tell if the array has odd or even numbers.
        if (numArray.length % 2 == 0) {

            // Calculates the median if it has even number of elements.
            median = (double) (numArray[middle - 1] + numArray[middle]) / 2;

        } else {

            // Calculates the median if there is an odd number of elements.
            median = numArray[middle];
        }

        // Returns the median.
        return median;
    }

    /**
        * This is method calculates the median.
        *
        * @param numArray //
        * @return median
        */
    public static int[] calcMode(int[] numArray) {

        // Sort the array in order so we can get the mode.
        Arrays.sort(numArray);

        // This list stores the modes.
        final int[] modes = new int[numArray.length];

        // This will count the number of modes.
        int modeCount = 0;

        // This will count the highest frequency.
        int maxCount = 1;

        // This will count the current frequency.
        int currentCount = 1;

        // This will count the current element.
        int currentElement = numArray[0];

        // Check through the sorted array.
        for (int counter = 1; counter < numArray.length; counter++) {
            if (numArray[counter] == currentElement) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    modeCount = 1;
                    modes[0] = currentElement;
                } else if (currentCount == maxCount) {
                    modes[modeCount] = currentElement;
                    modeCount++;
                }

                currentCount = 1;
                currentElement = numArray[counter];
            }
        }

        // Check the last element.
        if (currentCount > maxCount) {
            modeCount = 1;
            modes[0] = currentElement;
        } else if (currentCount == maxCount) {
            modes[modeCount] = currentElement;
            modeCount++;
        }

        // Cut the modes array to the actual number of modes.
        return Arrays.copyOf(modes, modeCount);
    }

    /**
    * This is the main method.
    *
    * @param args //
    * @throws Exception //
    */
    public static void main(String[] args) throws Exception {

        // File path is passed as parameter.
        final File file = new File("Unit1-07-set3.txt");
        final FileWriter output = new FileWriter("output.txt");
        final Scanner sc = new Scanner(file);

        // Creating the array list.
        final ArrayList<Integer> numList = new ArrayList<Integer>();

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
        final int[] numArray = new int[numList.size()];

        // Create counter.
        int counter = 0;

        // convert any arraylist to array
        for (int number : numList) {

            // Put number into num array at counter position.
            numArray[counter] = number;
            counter++;
            output.write(number + "  ");
        }

        // Call median, mode, and mean.
        final double median = calcMedian(numArray);
        final int[] mode = calcMode(numArray);
        final double mean = calcMean(numArray);

        // Print the mean, median, mode.
        output.write(" ");
        output.write("The median is: " + median);

        output.write("The mode is: ");
        for (int element: mode) {
            output.write(element);
        }
        output.write("The mean is: " + mean);

        // Close the writer.
        output.close();
    }

}

