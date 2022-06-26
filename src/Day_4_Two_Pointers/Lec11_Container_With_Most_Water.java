package Day_4_Two_Pointers;

/**
 * As we approach towards higher bars we may increase the area found so far.
 * So, Our Greedy Approach will be keep shifting current minimum value pointer, so it may find a better solution.
 */
public class Lec11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        // holds the max value found so far
        int maxSoFar = 0;
        // we use 2 pointer approach
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // eg : [1,8,6,2,5,4,8,3,7]
            // height[left] =  1 ; height[right] = 7
            // (area covered will be min bar i.e. left) * (number of steps in between) = min( 1, 7 ) * 7  = 7 units
            int area = Math.min(height[left], height[right]) * (right - left);
            // update max so far
            maxSoFar = Math.max(maxSoFar, area);

            // Greedy Approach -
            // 1. shift left pointer if its current minimum than right
            // 2. else shift right
            if (height[left] < height[right]) {
                left ++;
            } else if (height[right] <= height[left]) {
                right--;
            }
        }

        return maxSoFar;
    }
    public static void main(String[] args) {
        System.out.println(new Lec11_Container_With_Most_Water().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
