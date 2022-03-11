package hw1;

import java.util.Arrays;

public class Summ {

  private static int[] twoSum(int[] nums, int target) {

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == target - nums[i]) {
          return new int[] {i, j};
        }
      }
    }

    return null;
  }

  public static void check() {
    int[] array  = {4, 7, 3, 5, 6};
    int target = 10;
    System.out.println("Sum " + Arrays.toString(twoSum(array, target)) + " = " + target);
    System.out.println("");
  }

}
