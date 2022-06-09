package three_sum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Lec15_3_Sum {
    public static void main(String[] args) throws IOException {
        int[] nums = readFile();

        long startMillis = System.currentTimeMillis();
        System.out.println(threeSumO3(nums).size());
        long endMillis = System.currentTimeMillis();
        System.out.println("Total Time Taken in millis O(n^3)  " + (endMillis - startMillis) + "ms");

        startMillis = System.currentTimeMillis();
        System.out.println(threeSumO2LogN(nums).size());
        endMillis = System.currentTimeMillis();
        System.out.println("Total Time Taken in millis O(N^2*Logn)  " + (endMillis - startMillis) + "ms");


        startMillis = System.currentTimeMillis();
        System.out.println(threeSumO2(nums).size());
        endMillis = System.currentTimeMillis();
        System.out.println("Total Time Taken in millis O(N^2)  " + (endMillis - startMillis) + "ms");
    }

    private static List<List<Integer>> threeSumO2LogN(int[] nums) {
        final HashMap<Integer, Integer> hshMap = new HashMap<>();
        final Set<List<Integer>> resultSet = new HashSet<>();
        for (int num : nums) {
            if (hshMap.containsKey(num)) {
                hshMap.put(num, hshMap.get(num) + 1);
            } else {
                hshMap.put(num, 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            hshMap.put(nums[i], hshMap.get(nums[i]) - 1);
            for (int j = i + 1; j < nums.length; j++) {
                hshMap.put(nums[j], hshMap.get(nums[j]) - 1);
                int c = -(nums[i] + nums[j]);
                if (hshMap.containsKey(c) && hshMap.get(c) > 0) {
                    int[] temp = new int[]{nums[i], nums[j], c};
                    Arrays.sort(temp);
                    resultSet.add(Arrays.stream(temp).boxed().toList());
                }
                hshMap.put(nums[j], hshMap.get(nums[j]) + 1);
            }
            hshMap.put(nums[i], hshMap.get(nums[i]) + 1);
        }
        return new ArrayList<>(resultSet);
    }

    private static List<List<Integer>> threeSumO2(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i ==0 || (i>=1 && nums[i] != nums[i-1])) {
                int lowIndex = i + 1;
                int highIndex = nums.length - 1;

                while (lowIndex < highIndex) {
                    int b = nums[lowIndex];
                    int c = nums[highIndex];

                    if (nums[i] + b + c < 0) {
                        lowIndex++;
                    } else if (nums[i] + b + c > 0) {
                        highIndex--;
                    } else {
                        result.add(List.of(nums[i], b, c));
                        while (lowIndex < highIndex && nums[lowIndex] == nums[lowIndex+1]) lowIndex++;
                        while (lowIndex < highIndex && nums[highIndex] == nums[highIndex-1]) highIndex--;
                        lowIndex++;
                        highIndex--;
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumO3(int[] nums) {
        final Set<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (
                            nums[i] + nums[j] + nums[k] == 0
                    ) {
                        int[] temp = new int[]{nums[i], nums[j], nums[k]};
                        Arrays.sort(temp);
                        resultSet.add(Arrays.stream(temp).boxed().toList());
                    }
                }
            }
        }
        return new ArrayList<>(resultSet);
    }

    private static int[] readFile() throws IOException {
        String file = "C:\\Users\\Rohit Reddy\\Documents\\Ds-and-Algo\\src\\three_sum\\input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        final List<String> myList = reader.lines().toList();
        int[] integers = new int[myList.size()];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(myList.get(i));
        }
        return integers;
    }
}
