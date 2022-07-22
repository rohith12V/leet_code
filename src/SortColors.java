import java.util.Arrays;

/**
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class SortColors {
    public static void main(String[] args) {
        final SortColors colors = new SortColors();
        int[] ints = {2, 0, 2, 1, 1, 0, 1};
        colors.sortColors(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void sortColors(int[] nums) {
        int redIndex = 0;
        int blueIndex = nums.length - 1;

        while (redIndex < nums.length && nums[redIndex] == 0) {
            redIndex++;
        }
        while (blueIndex >= 0 && nums[blueIndex] == 2) {
            blueIndex--;
        }

        int currentIndex = redIndex;

        while (currentIndex <= blueIndex) {
            int element = nums[currentIndex];

            if (element == 2) {
                swap(currentIndex, blueIndex, nums);
                blueIndex--;
            } else if (element == 0) {
                swap(currentIndex, redIndex, nums);
                redIndex++;
            }
            currentIndex++;
        }
    }

    private void swap(int currentIndex, int blueIndex, int[] nums) {
        int temp = nums[currentIndex];
        nums[currentIndex] = nums[blueIndex];
        nums[blueIndex] = temp;
    }
}
