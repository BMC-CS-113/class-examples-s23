import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bubble {

  /**
    Swaps two elements in an array in place

    @param int j - location of first element to swap
    @param int i - location of second element to swap

  */
  public static void swap(int[] numbs, int j, int i) {
      int tmp = numbs[i];
      numbs[i] = numbs[j];
      numbs[j] = tmp;
  }

  /**
    Helper method that creates string representation of an array

    @param int[] numbers - array to return string of
    @return the string represents of the array
  */
  private static String toString(int[] numbs) {
    String out = "";
    for (int i = 0; i < numbs.length; i++)
      out += numbs[i] + "  "; 

    return out;
  }

  /**
    Sorts the list inplace using bubbleSort

    @param int[] list - the array of numbers to sort
  */
  public static void bubbleSort(int[] list) {
    for (int len = list.length; len>0; len--) {
      for (int j = 1; j < len; j++) {
        if (list[j] < list[j-1]) {
          swap(list, j, j-1);
        }
        //System.out.println(len + "| " + j + " | " + toString(list));
      }
    }
  }

  public static void main(String[] args) throws FileNotFoundException {

    Scanner sc = new Scanner(new File(args[0]));
    int[] L = new int[Integer.parseInt(sc.nextLine())];

    System.out.println(L.length);
    int i = 0;
    while (sc.hasNextLine() && i < L.length) {
      L[i] = sc.nextInt();
      i++;
    }

    double start = System.currentTimeMillis()/1000.0; // converts to seconds
    bubbleSort(L);
    double end = System.currentTimeMillis()/1000.0;

    System.out.printf("Time: %.10f\n", (end-start));
  }

}
