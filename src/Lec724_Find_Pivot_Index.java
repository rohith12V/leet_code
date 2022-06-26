import java.util.Arrays;

public class Lec724_Find_Pivot_Index {
    public static void main(String[] args) {
        System.out.println(new Lec724_Find_Pivot_Index().pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(new Lec724_Find_Pivot_Index().pivotIndex(new int[]{1,2,3}));
        System.out.println(new Lec724_Find_Pivot_Index().pivotIndex(new int[]{2,1,-1}));

    }
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = calculateSum(nums);
        for (int i = 0; i < nums.length; i++) {
            rightSum-=nums[i];
            if (rightSum == leftSum) {
                return i;
            }
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
