package practicaltwo;

import java.text.DecimalFormat;

/**
 * This class provides static methods that calculate statistical values.
 *
 * @author Gregory M. Kapfhammer
 */
public class StatisticsCalculator {

  /**
   * Calculates the arithmetic mean of Double values in an array.
   *
   * @param timings the list of Double values from timing an algorithm
   *
   */

  // NOTE pg 28 in book
  // Widening from an integer, timings.length, to a double.
  // i = 0. As long as i is less than timings.length, then proceed with loop.
  // timings saves a value every time the loop is ran and adds it to an array
  public static Double calculateArithmeticMean(Double[] timings) {
    double runningTotal = 0.0;
    for (int i = 0; i < timings.length; i++) {
      runningTotal = runningTotal + timings[i];
    }
    Double arithMean = runningTotal / (double)timings.length;
    return arithMean;
  }
  /**
   * Calculates the variance of Double values in an array.
   *
   * @param timings the list of Double values from timing an algorithm
   *
   */

  public static Double calculateVariance(Double[] timings) {
    Double arithMean = calculateArithmeticMean(timings);
    Double runningTotal = 0.0;

    // Loop runs as long as i is less than the time it took to run the .
    for (int i = 0; i < timings.length; i++ ) {
      runningTotal += Math.pow(timings[i] - arithMean, 2);
    }
    Double variance = runningTotal / ((double)timings.length - 1);
    return variance;
  }

  /**
   * Calculates the standard deviation of Double values in an array.
   *
   * @param timings the list of Double values from timing an algorithm
   */

  public static Double calculateStandardDeviation(Double[] timings) {
    // NOTE: look for Math. methods
    Double standardDeviation = Math.sqrt(calculateVariance(timings));
    return standardDeviation;
  }

  /**
   * Create an array of double values and then calculate statistics.
   */

  public static void main(String[] args) {
    Double[] values = {12.5, 6.2, 1.5, 2.9, 10.8};
    System.out.println("Displaying the values in the array.");
    ArrayPrinter.print(values);
    Double arithMean = StatisticsCalculator.calculateArithmeticMean(values);
    Double variance = StatisticsCalculator.calculateVariance(values);
    Double standardDeviation = StatisticsCalculator.calculateStandardDeviation(values);
    DecimalFormat formatter = new DecimalFormat("#.00");
    System.out.println("Displaying the output with two decimal places.");
    System.out.println("This is the arithmetic mean: " + formatter.format(arithMean));
    System.out.println("This is the variance: " + formatter.format(variance));
    System.out.println("This is the standard deviation: " + formatter.format(standardDeviation));

    // see the README file in your GitHub repository for an output example
  }
}
