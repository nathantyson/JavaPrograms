import java.util.Arrays;
import java.util.Random;

public class ShellSort {
   private static int insertionSortInterleaved(int[] numbers, int startIndex, int gap) {
      int swaps = 0;
      for (int i = startIndex + gap; i < numbers.length; i += gap) {
         int j = i;
         while (j - gap >= startIndex && numbers[j] < numbers[j - gap]) {
            swaps++;
            // Swap numbers[j] and numbers [j - 1]
            int temp = numbers[j];
            numbers[j] = numbers[j - gap];
            numbers[j - gap] = temp;
            j -= gap;
         }
      }
      return swaps;
   }
   
   private static int shellSort(int[] numbers, int[] gapValues) {
      int totalSwaps = 0;
      for (int g = 0; g < gapValues.length; g++) {
         int swapsForGap = 0;
         for (int i = 0; i < gapValues[g]; i++) {
            swapsForGap += insertionSortInterleaved(numbers, i, gapValues[g]);
         }
         System.out.printf("%s (after %d swap%s with gap=%d)\n",
            Arrays.toString(numbers), swapsForGap, 
            (swapsForGap == 1 ? "" : "s"), gapValues[g]);
         totalSwaps += swapsForGap;
      }
      return totalSwaps;
   }

   public static void main(String[] args) {
      // Create an array of numbers to sort
      Random rd = new Random();
      int[] numbers = new int[100000];
      for (int i = 0; i < numbers.length; i++) {
         numbers[i] = rd.nextInt(); 
         //System.out.println(numbers[i]); 
      }
      int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
      
      // Display the contents of the array
      System.out.println("---- Shell sort ----");
      System.out.println("UNSORTED: " + Arrays.toString(numbers));
      
      // Call the shellSort method
      int[] gapValues = { 4, 2, 1 };
      int totalSwaps = shellSort(numbers, gapValues);

      // Display sorted array and the total number of swaps
      System.out.println("SORTED: " + Arrays.toString(numbers));
      System.out.println("Total swaps: " + totalSwaps);
   }
}