// LeetCode 977: Squares of a Sorted Array  
// Problem Link: https://leetcode.com/problems/squares-of-a-sorted-array/description/
// ============================================================================  
// 📝 Approach 1: Brute Force (Square + Bubble Sort)  
// ============================================================================  
// - Step 1: Square all elements of the array  
// - Step 2: Use Bubble Sort to sort the squared array  
// - Step 3: Return the sorted array  
// ============================================================================  
// ✅ Time Complexity: O(n²) → Bubble Sort takes O(n²) time  
// ✅ Space Complexity: O(1) → Sorting is done in place  
// ============================================================================  

class Solution {
    public int[] sortedSquares(int[] nums) {
        // Step 1: Square all elements
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        // Step 2: Bubble Sort the squared elements
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // Swap elements
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        // Step 3: Return the sorted array
        return nums;
    }
}

// ============================================================================  
// 📝 Approach 2: Using Arrays.sort() (Better Approach)  
// ============================================================================  
// - Step 1: Square all elements of the array  
// - Step 2: Use `Arrays.sort()` to sort the squared array  
// - Step 3: Return the sorted array  
// ============================================================================  
// ✅ Time Complexity: O(n log n) → Arrays.sort() uses Dual-Pivot QuickSort  
// ✅ Space Complexity: O(1) → Sorting is done in place  
// ============================================================================  

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums); // Sort using Java's built-in sorting
        return nums;
    }
}

// ------------------------------------------------------------  
// 📝 Approach 3: Two Pointers (Optimal Solution)  
// ------------------------------------------------------------  
// - Use two pointers → left and right  
// - Compare absolute values at both ends  
// - Fill the result array from the back  
// - This works because the largest square will be at either end  
// ------------------------------------------------------------  
// ✅ Time Complexity: O(n) → Single pass through the array  
// ✅ Space Complexity: O(n) → Extra space for result array  
// ------------------------------------------------------------  

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int index = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }
        return result;
    }
}

// ============================================================================  
// ✅ Summary of Approaches  
// ============================================================================  
// | Approach                      | Time Complexity | Space Complexity | Notes |  
// |--------------------------------|-----------------|------------------|-------|  
// | Brute Force (Bubble Sort)      | O(n²)           | O(1)              | Square + Bubble Sort |  
// | Arrays.sort() (Better)         | O(n log n)       | O(1)              | Square + Built-in Sort |  
// | **Two Pointers (Best)**         | **O(n)**           | **O(n)**            | Use two pointers to fill from the back |  
// ============================================================================  
