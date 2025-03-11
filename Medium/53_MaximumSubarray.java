// LeetCode 53: Maximum Subarray
// Problem Link: https://leetcode.com/problems/maximum-subarray/description/

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
