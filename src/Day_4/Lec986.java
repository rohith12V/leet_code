package Day_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lec986 {
    public static void main(String[] args) {
//        int[][] firstList = new int[][] {
//                {0,2},
//                {5,10},
//                {13,23},
//                {24,25}
//        };
//        int[][] secondList = new int[][] {
//                {1,5},
//                {8,12},
//                {15, 24},
//                {25, 26}
//        };

        int[][] firstList = new int[][] {
                {14,16}
        };
        int[][] secondList = new int[][] {
                {7,13}, {16,20}
        };

        System.out.println(Arrays.deepToString(intervalIntersection(firstList, secondList)));
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstList_length = firstList.length;
        int secondList_length = secondList.length;
        int minLength = Math.min(firstList_length, secondList_length);
        List<int[]> result = new ArrayList<>();

        if (minLength == 0 ) {
            return new int[][]{};
        }

        int first_list_index = 0;
        int second_list_index = 0;

        while (first_list_index < firstList_length && second_list_index < secondList_length) {

            int[] a = firstList[first_list_index];
            int[] b = secondList[second_list_index];

            int a1 = a[0];
            int a2 = a[1];
            int b1 = b[0];
            int b2 = b[1];

            if (b1 >= a1 && b2 <= a2) {
                result.add(new int[]{b1, b2});
                second_list_index++;
            } else if (b1 > a1 && b1 <= a2) {
                result.add(new int[]{b1, a2});
                first_list_index++;
            } else if(b1 < a1 && b2 < a2 && a1<=b2) {
                result.add(new int[]{a1, b2});
                second_list_index++;
            } else if (a1>=b1 && a2<=b2) {
                result.add(new int[]{a1, a2});
                first_list_index++;
            } else if (b1>a2) {
                first_list_index ++;
            }
            else if (b2 < a1) {
                second_list_index ++;
            }
        }
        return result.toArray(new int[0][]);
    }
}
