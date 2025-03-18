// LeetCode 169: Majority Element  
// Problem Link: https://leetcode.com/problems/majority-element/description/  
// ============================================================================
// 📝 Approach 1: Brute Force (O(n²))  
// ============================================================================  
// - Iterate through the array using two nested loops:  
//    - Outer loop → pick an element  
//    - Inner loop → count the occurrence of that element  
// - If the count exceeds `n/2`, return the element  
// - If no such element exists, return `-1`  
// ============================================================================  
// ✅ Time Complexity: O(n²)  
// ✅ Space Complexity: O(1) (constant extra space)  
// ============================================================================  

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) { // Pick element
            count = 1;
            for (int j = i + 1; j < nums.length; j++) { // Count occurrence
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}

// ============================================================================  
// 📝 Approach 2: Sorting Approach (O(n log n))  
// ============================================================================  
// - Sort the array  
// - Since the majority element appears more than `n/2` times,  
//   the middle element after sorting will always be the majority element  
// - Return the middle element  
// ============================================================================  
// ✅ Time Complexity: O(n log n)  
// ✅ Space Complexity: O(1) (constant extra space)  
// ============================================================================  

import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums); // Sort the array
        return nums[nums.length / 2]; // Return middle element
    }
}

// ============================================================================  
// 📝 Approach 3: HashMap Approach (O(n))  
// ============================================================================  
// - Use a HashMap to store the frequency of each element  
// - If any element’s frequency exceeds `n/2`, return that element  
// ============================================================================  
// ✅ Time Complexity: O(n)  
// ✅ Space Complexity: O(n) (for storing elements in HashMap)  
// ============================================================================  

import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }
}

// ------------------------------------------------------------
// 📝 Approach 4: Boyer-Moore Voting Algorithm (Optimal Solution)  
// ------------------------------------------------------------  
// - Initialize two variables:  
//    - `count` → to track the occurrence count  
//    - `candidate` → to store the potential majority element  
// - Iterate through the array:  
//    - If count is `0`, set the candidate to the current element  
//    - If current element = candidate → increase the count  
//    - If current element ≠ candidate → decrease the count  
// - Return the candidate as the majority element  
// ------------------------------------------------------------  
// ✅ Time Complexity: O(n)  
// ✅ Space Complexity: O(1) (constant extra space)  
// ------------------------------------------------------------  

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}

// ============================================================================  
// ✅ Summary of Approaches  
// ============================================================================  
// | Approach                        | Time Complexity | Space Complexity | Notes |  
// |--------------------------------- |---------------- |------------------|-------|  
// | Brute Force                     | O(n²)           | O(1)              | Count occurrence of each element using nested loops |  
// | Sorting Approach                | O(n log n)       | O(1)              | Sort array, return middle element |  
// | HashMap Approach                | O(n)             | O(n)              | Store element frequency using HashMap |  
// | **Boyer-Moore Voting Algorithm** | **O(n)**          | **O(1)**            | Optimal, use counting to find majority element |  
// ============================================================================  
