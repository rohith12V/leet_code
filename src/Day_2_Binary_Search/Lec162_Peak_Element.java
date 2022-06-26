package Day_2_Binary_Search;

public class Lec162_Peak_Element {
    public static void main(String[] args) {
        final Lec162_Peak_Element obj = new Lec162_Peak_Element();
        System.out.println(obj.findPeakElement(new int[] {5,4,3,2,1}));
    }
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        // base - conditions - 1
        if (nums.length == 1) {
            return 0;
        }
        // base - conditions - 2
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }

        // exit condition
        while(low <= high) {
            int mid = (low + high) / 2 ;
            // condition - 1  [2,1,4,5]  mid == 0 arr[0] > arr[1] return 0 index, which is mid.
            // condition - 2  [1,2,3,4] mid == 3 && arr[3] > arr[2] return 3, which is also mid.
            // condition - 3  [1,2,3,6,4,3,2,1] mid == 3 arr[2] < arr[3] > arr[4] return index 3, which is also mid
            if ((mid == 0 && nums[mid + 1] < nums[mid])
                    || (mid == nums.length - 1 && nums[mid-1] < nums[mid])
                    || (mid+1 < nums.length && mid - 1 >=0 && nums[mid] > nums[mid+1] && nums[mid] > nums[mid - 1])
            ) {
                return mid;
            }

            // if above conditions does not match shift the pointers
            // right or left depends upon the increasing side ( which has a probability of getting a local max )
            if (mid + 1 < nums.length && nums[mid] < nums[mid+1]) {
                // shift low towards mid + 1 as arr[mid+1] is > arr[mid] which has an increasing sequence, and probably we find peak element
                low = mid + 1;
            } else {
                // shift high towards mid - 1 as arr[mid-1] is > arr[mid] which has an increasing sequence, and probably we find peak element
                high = mid - 1;
            }
        }
        // return if you don't find anything
        return - 1;
    }
}
