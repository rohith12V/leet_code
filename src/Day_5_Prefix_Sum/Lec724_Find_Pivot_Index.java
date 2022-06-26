package Day_5_Prefix_Sum;

public class Lec724_Find_Pivot_Index {
    public static void main(String[] args) {
        System.out.println(new Lec724_Find_Pivot_Index().pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(new Lec724_Find_Pivot_Index().pivotIndex(new int[]{1,2,3}));
        System.out.println(new Lec724_Find_Pivot_Index().pivotIndex(new int[]{2,1,-1}));
    }
    public int pivotIndex(int[] nums) {
        // initial Left Sum will be 0
        int leftSum = 0;
        // initial Right Sum will be total sum
        int rightSum = calculateSum(nums);
        for (int i = 0; i < nums.length; i++) {
            // as pivot element should not be included while comparison.
            // remove current pivot sum from right side
            rightSum-=nums[i];
            // check match
            if (rightSum == leftSum) {
                return i;
            }
            // add to leftSum because we move pointer to next
            leftSum+=nums[i];
        }
        return -1;
    }

    private int calculateSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
          sum+=num;
        }
        return sum;
    }
}
