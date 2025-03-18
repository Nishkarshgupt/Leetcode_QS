// LeetCode 53: Maximum Subarray
// Problem Link: https://leetcode.com/problems/maximum-subarray/description/
// ============================================================================
// 📝 Approach 1: Brute Force (O(n³))
// ============================================================================
// - Generate all possible subarrays using three nested loops:  
//    - Outer loop → starting index of the subarray  
//    - Middle loop → ending index of the subarray  
//    - Inner loop → calculate the sum of the subarray  
// - Track the maximum sum encountered so far  
// ============================================================================
// ✅ Time Complexity: O(n³)  
// ✅ Space Complexity: O(1) (constant extra space)  
// ============================================================================

class Solution {
    public int maxSubArray(int[] nums) {
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) { // Starting index
            for (int j = i; j < nums.length; j++) { // Ending index
                int sum = 0;
                for (int k = i; k <= j; k++) { // Summing elements
                    sum += nums[k];
                }
                largest = Math.max(largest, sum);
            }
        }
        return largest;
    }
}

// ============================================================================
// 📝 Approach 2: Better Approach (O(n²))
// ============================================================================
// - Generate all possible subarrays using two nested loops:  
//    - Outer loop → starting index of the subarray  
//    - Inner loop → ending index of the subarray  
//    - Maintain a running sum while expanding the subarray  
// - Track the maximum sum encountered so far  
// ============================================================================
// ✅ Time Complexity: O(n²)  
// ✅ Space Complexity: O(1) (constant extra space)  
// ============================================================================

class Solution {
    public int maxSubArray(int[] nums) {
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) { // Starting index
            int sum = 0;
            for (int j = i; j < nums.length; j++) { // Ending index
                sum += nums[j];
                largest = Math.max(largest, sum);
            }
        }
        return largest;
    }
}

// ------------------------------------------------------------
// 📝 Approach: Kadane's Algorithm (Optimal Solution)
// ------------------------------------------------------------
// - Initialize two variables: 
//    - `sum` → to track the current sum of the subarray 
//    - `largest` → to store the maximum sum encountered so far
// - Iterate through the array: 
//    - Add the current element to `sum` 
//    - If `sum` becomes greater than `largest`, update `largest` 
//    - If `sum` becomes negative, reset it to `0` 
//    - int largest = nums[0];   ============   This is written because we may have some cases in which the elements in the entire array are negative, so we have to print the largest among them rather than 0, so we will not store negative infinity in largest 
// ------------------------------------------------------------
// ✅ Time Complexity: O(n)
// ✅ Space Complexity: O(1) (constant extra space)
// ------------------------------------------------------------

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int largest = nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            largest = Math.max(sum, largest);

            if (sum < 0) {
                sum = 0;
            }
        }
        return largest;
    }
}
// ============================================================================
// ✅ Summary of Approaches  
// ============================================================================
// | Approach                    | Time Complexity | Space Complexity | Notes |
// |---------------------------- |---------------- |------------------|-------|
// | Brute Force                 | O(n³)           | O(1)              | Generate all subarrays and calculate sum using three loops |
// | Better Approach             | O(n²)           | O(1)              | Generate all subarrays and calculate sum using two loops |
// | **Kadane's Algorithm (Best)**| **O(n)**         | **O(1)**            | Maintain running sum and reset if negative |
// ============================================================================

