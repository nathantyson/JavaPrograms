

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
   private static int selectionSort(int[] numbers) {
      // A variable to hold the number of item comparisons
      int comparisons = 0;

      for (int i = 0; i < numbers.length - 1; i++) {
         // Find index of smallest remaining element
         int indexSmallest = i;
         for (int j = i + 1; j < numbers.length; j++) {
            comparisons++;
            if (numbers[j] < numbers[indexSmallest]) {
               indexSmallest = j;
            }
         }
         
         // Swap numbers[i] and numbers[indexSmallest]
         int temp = numbers[i];
         numbers[i] = numbers[indexSmallest];
         numbers[indexSmallest] = temp;
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
      
      // Call the selectionSort method
      int comparisons = selectionSort(numbers);
      
      // Display the sorted contents of the array
      System.out.println("SORTED:   " + Arrays.toString(numbers));
      
      System.out.println("Total comparisons: " + comparisons);
   }
}
