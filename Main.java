import java.util.*;

class Solution {
    public List<Integer> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int size = nums.length;

        for (int i = 0; i < size - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) // Skip duplicate elements
                continue;

            int leftIndex = i + 1;
            int rightIndex = size - 1;

            while (leftIndex < rightIndex) {
                int currentSum = nums[i] + nums[leftIndex] + nums[rightIndex];

                if (currentSum == target) {
                    result.add(nums[i]);
                    result.add(nums[leftIndex]);
                    result.add(nums[rightIndex]);
                    return result;
                } else if (currentSum > target) {
                    rightIndex--;
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1])
                        rightIndex--; // Skip duplicate elements
                } else {
                    leftIndex++;
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1])
                        leftIndex++; // Skip duplicate elements
                }
            }
        }

        return Collections.singletonList(Integer.MIN_VALUE); // Return a singleton list with MIN_VALUE if no triplet is found
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        System.out.print("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        if (array.length < 3)
            throw new IllegalArgumentException(" Array must contain at least three numbers.");

        System.out.print("Enter the elements of array:-");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Enter the Target sum to be found:");
        int target = scanner.nextInt();

        try {
            List<Integer> result = solution.threeSum(array, target);

            if (result.get(0) != Integer.MIN_VALUE) {
                System.out.println(" Pair of Triplet found: " + result.get(0) + ", " + result.get(1) + ", " + result.get(2));
                assert result.get(0) + result.get(1) + result.get(2) == target : "Triplet does not sum up to the target.";
            } else {
                System.out.println("No triplet found that sums up to " + target);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
