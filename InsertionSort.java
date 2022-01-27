import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
   private static int insertionSort(int[] numbers) {
      // A variable to hold the number of item comparisons
      int comparisons = 0;
      for (int i = 1; i < numbers.length; i++) {
         int j = i;
         while (j > 0 && numbers[j] < numbers[j - 1]) {
            // Swap numbers[j] and numbers [j - 1]
            comparisons++;
            int temp = numbers[j];
            numbers[j] = numbers[j - 1];
            numbers[j - 1] = temp;
            j--;
         }
      }
      return comparisons;
   }

   public static void main(String[] args) {
      // Create an array of numbers to sort
      Random rd = new Random();
      int[] numbers = new int[100000];
      for (int i = 0; i < numbers.length; i++) {
         numbers[i] = rd.nextInt(); 
         //System.out.println(numbers[i]); 
      }
      // Display the contents of the array
      System.out.println("UNSORTED: " + Arrays.toString(numbers));
      
      // Call the insertionSort method
      //insertionSort(numbers);
      int comparisons = insertionSort(numbers);
      // Display the sorted contents of the array
      System.out.println("SORTED: " + Arrays.toString(numbers));
      System.out.println("Total comparisons: " + comparisons);
   }
}

