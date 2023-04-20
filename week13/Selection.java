import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Selection {

  /**
    Swaps two elements in an array in place

    @param int j - location of first element to swap
    @param int i - location of second element to swap

  */
  public static void swap(int[] numbs, int j, int i) {
    Bubble.swap(numbs, j, i);
  }

  /**
    Finds the index of the smallest value in the list

    @param int startIdx - the starting index to consider in the list
    @param int[] list - the list to search through

    @return int - the index of the smallest value
  */
  private static int findMinIndx(int startIdx, int[] list) {
    int minIdx = startIdx;
    int minVal = list[minIdx];
    for (int i = minIdx +1; i < list.length; i++) {
      if (list[i] < minVal) {
        minVal = list[i];
        minIdx = i;
      }
    }
    return minIdx;
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
    Helper method that creates string representation of an array

    @param int startIdx
    @param int minIdx
    @param int minVal
    @param int[] numbers - array to return string of
    @return the string represents of the array
  */
  private static String toString(int startIdx, int minIdx, 
                                 int minVal, int[] numbs) {
    String out = startIdx + " | " + minIdx + " | " + minVal + " | ";
    for (int i = 0; i < numbs.length; i++)
      out += numbs[i] + "  "; 

    return out;
  }

  /**
    Sorts the list inplace using selectionSort

    @param int[] list - the array of numbers to sort
  */
  public static void selectionSort(int[] list) {
    //TODO: implement this
    // make sure to call toString() after each swap
    // so that you can see the same results as the tables
    // you just filled in
    for (int i = 0; i < list.length; i++) {
      int minIndex = findMinIndx(i, list);
      swap(list, minIndex, i);
      //System.out.println(toString(i, minIndex, list[minIndex], list));
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
    selectionSort(L);
    double end = System.currentTimeMillis()/1000.0;

    System.out.printf("Time: %.10f\n", (end-start));

  }

}
