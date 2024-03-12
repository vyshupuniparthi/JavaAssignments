package assignfive;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueIntegerFinder {

    public static int findUniqueInteger(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Find the unique integer
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // If no unique integer found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int uniqueInteger = findUniqueInteger(nums);
        if (uniqueInteger != -1) {
            System.out.println("The unique integer is: " + uniqueInteger);
        } else {
            System.out.println("No unique integer found in the array.");
        }
        scanner.close();
    }
}
