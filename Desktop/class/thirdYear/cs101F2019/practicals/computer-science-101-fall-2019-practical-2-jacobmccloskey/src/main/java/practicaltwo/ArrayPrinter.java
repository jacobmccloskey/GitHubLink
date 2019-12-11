package practicaltwo;

/**
 * This class provide a static methods to print out a generic array.
 *
 * @author Gregory M. Kapfhammer
 */

public class ArrayPrinter {

  private static String INDENT = "  ";

  /**
   * Displays all of the contents of an array.
   *
   * @param data the array that contains generic values
   */
  public static <T> void print(T[] data) {
    for (int i = 0; i < data.length; i++) {
      System.out.println(INDENT + data[i]);
    }
  }

}
