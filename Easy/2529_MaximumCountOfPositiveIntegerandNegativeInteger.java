// LeetCode 2529: Maximum Count of Positive Integer and Negative Integer  
// Problem Link: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/
// ============================================================================
// 📝 Approach 1: Brute Force (O(n²))  
// ============================================================================  
// - Iterate through all possible subarrays using two nested loops:  
//    - Outer loop → starting index of the subarray  
//    - Inner loop → ending index of the subarray  
//    - Count positive and negative numbers for each subarray  
// - Track the maximum count of positive and negative integers encountered.  
// ============================================================================  
// ✅ Time Complexity: O(n²)  
// ✅ Space Complexity: O(1) (constant extra space)  
// ============================================================================  

class Solution {
    public int maximumCount(int[] nums) {
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) { // Starting index
            int pos = 0;
            int neg = 0;

            for (int j = i; j < nums.length; j++) { // Ending index
                if (nums[j] < 0) {
                    neg++;
                } else if (nums[j] > 0) {
                    pos++;
                }
                maxCount = Math.max(maxCount, Math.max(pos, neg));
            }
        }
        return maxCount;
    }
}

// ============================================================================  
// 📝 Approach 2: Counting Approach (Optimal Solution)  
// ============================================================================  
// - Initialize two counters:  
//    - `pos` → to count positive integers  
//    - `neg` → to count negative integers  
// - Iterate through the array:  
//    - If element is greater than zero → increment `pos`  
//    - If element is less than zero → increment `neg`  
// - Return the maximum value between `pos` and `neg`.  
// ============================================================================  
// ✅ Time Complexity: O(n)  
// ✅ Space Complexity: O(1) (constant extra space)  
// ============================================================================  

class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;

        for (int num : nums) {
            if (num < 0) {
                neg++;
            } else if (num > 0) {
                pos++;
            }
        }

        // Return the maximum between positive and negative count
        return Math.max(pos, neg);
    }
}

// ============================================================================  
// ✅ Summary of Approaches  
// ============================================================================  
// | Approach                   | Time Complexity | Space Complexity | Notes |  
// |--------------------------- |---------------- |------------------|-------|  
// | Brute Force                | O(n²)           | O(1)              | Check all subarrays and count positive & negative elements |  
// | **Counting Approach (Best)**| **O(n)**         | **O(1)**            | Directly count positive and negative elements using a single pass |  
// ============================================================================  
