package practicaltwo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import practicaltwo.StatisticsCalculator;

//: Make sure that you understand the purpose of each test case

/**
 * A JUnit test suite for StatisticsCalculator.
 *
 * @author Gregory M. Kapfhammer
 */

public class TestStatisticsCalculator {

  //: Make sure that you understand why DELTA is needed in the tests

  /** All double values in assertions much be very close to each other.
   *  Please see the following web site for more details:
   *  http://junit.org/junit4/javadoc/latest/allclasses-frame.html */
  private static final double DELTA = 1e-15;

  @Test
  public void testCalculateUnitArithmeticMean() {
    Double[] values = {1.0, 1.0, 1.0};
    Double expectedMean = new Double((1.0 + 1.0 + 1.0) / 3);
    Double actualMean = StatisticsCalculator.calculateArithmeticMean(values);
    assertEquals(actualMean, expectedMean, DELTA);
  }

  @Test
  public void testCalculateUnitTimesTenArithmeticMean() {
    Double[] values = {10.0, 10.0, 10.0};
    Double expectedMean = new Double((10.0 + 10.0 + 10.0) / 3);
    Double actualMean = StatisticsCalculator.calculateArithmeticMean(values);
    assertEquals(actualMean, expectedMean, DELTA);
  }

  @Test
  public void testCalculateArithmeticMeanSubtraction() {
    Double[] values = {10.0, 10.0, 10.0};
    Double actualMean = StatisticsCalculator.calculateArithmeticMean(values);
    Double actualSubtraction =
        new Double(((10.0 - actualMean) + (10.0 - actualMean) + (10.0 - actualMean)));
    Double zero = new Double(0.0);
    assertEquals(actualSubtraction, zero, DELTA);
  }

  @Test
  public void testCalculateArithmeticMeanAddition() {
    Double[] values = {10.0, 10.0, 10.0};
    Double actualMean = StatisticsCalculator.calculateArithmeticMean(values);
    Double[] valuesAddition = {15.0, 15.0, 15.0};
    Double actualMeanAddition = StatisticsCalculator.calculateArithmeticMean(valuesAddition);
    assertEquals(actualMeanAddition, new Double(actualMean + 5.0), DELTA);
  }

  @Test
  public void testCalculateVarianceIsNonNegative() {
    Double[] values = {10.5, 1.0, 12.5};
    Double actualVariance = StatisticsCalculator.calculateVariance(values);
    assertTrue(actualVariance > 0);
  }

  @Test
  public void testCalculateVarianceIsZero() {
    Double[] values = {10.0, 10.0, 10.0};
    Double actualVariance = StatisticsCalculator.calculateVariance(values);
    assertEquals(actualVariance, new Double(0.0));
  }

  @Test
  public void testCalculateVarianceDoesNotVaryWithConstant() {
    Double[] values = {15.2, 11.0, 11.5};
    Double actualVariance = StatisticsCalculator.calculateVariance(values);
    Double[] valuesConstant = {16.2, 12.0, 12.5};
    Double actualVarianceConstant = StatisticsCalculator.calculateVariance(valuesConstant);
    assertEquals(actualVarianceConstant, actualVariance);
  }

  @Test
  public void testCalulateStandardDeviationIsZero() {
    Double[] values = {10.0, 10.0, 10.0};
    Double actualStandardDeviation = StatisticsCalculator.calculateStandardDeviation(values);
    Double zero = new Double(0.0);
    assertEquals(actualStandardDeviation, zero, DELTA);
  }

  @Test
  public void testCalulateStandardDeviationIsNonNegative() {
    Double[] values = {11.0, 12.0, 15.2};
    Double actualStandardDeviation = StatisticsCalculator.calculateStandardDeviation(values);
    Double zero = new Double(0.0);
    assertTrue(actualStandardDeviation > zero);
  }

}
