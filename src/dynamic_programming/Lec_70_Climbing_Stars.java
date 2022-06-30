package dynamic_programming;

import java.util.Arrays;

public class Lec_70_Climbing_Stars {
  public static void main(String[] args) {
    int result = new Lec_70_Climbing_Stars().climbStairs(45);
    System.out.println(result);
  }

  public int climbStairs(int n) {
    int[] memoryTable = new int[n];
    Arrays.fill(memoryTable, -1);
    return climbStairsUtil(n, 0, memoryTable);
  }

  private int climbStairsUtil(int target, int currentStep, int[] memoryTable) {
    // Edge case - 1
    // if current step exceeds the target step return 0;
    if (currentStep > target) return 0;
    // return match ( i.e 1 ) if we reach target
    if (currentStep == target) return 1;

    // if we have not pre-computed the table compute it
    if (memoryTable[currentStep] == -1) {
      // from current step we can either take 1 step or 2 steps
      memoryTable[currentStep] =
          climbStairsUtil(target, currentStep + 1, memoryTable)
              + climbStairsUtil(target, currentStep + 2, memoryTable);
    }

    // if we have already processed the node already return it
    return memoryTable[currentStep];
  }
}
