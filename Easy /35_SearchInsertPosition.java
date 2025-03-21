// LeetCode 35: Search Insert Position
// Problem Link: https://leetcode.com/problems/search-insert-position/description/
// ============================================================================
// 📝 Approach 1: Brute Force (O(n))
// ============================================================================
// - Linearly search through the array:  
//    - If the element matches the target → return the index  
//    - If the element is greater than the target → insert before this element  
// - If the target is greater than all elements → insert at the end  
// ============================================================================
// ✅ Time Complexity: O(n)  
// ✅ Space Complexity: O(1) (constant extra space)  
// ============================================================================

class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}

// ============================================================================
// 📝 Approach 2: Better Approach (Using Binary Search) — O(log n)
// ============================================================================
// - Use binary search:  
//    - If `nums[mid] == target` → return `mid`  
//    - If `nums[mid] < target` → search in the right half  
//    - If `nums[mid] > target` → search in the left half  
// - If element not found → `start` will hold the correct insert position  
// ============================================================================
// ✅ Time Complexity: O(log n)  
// ✅ Space Complexity: O(1) (constant extra space)  
// ============================================================================

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return start;
    }
}

// ------------------------------------------------------------
// 📝 Approach 3: Optimal Approach (Binary Search with Reduced Comparisons)
// ------------------------------------------------------------
// - Same as binary search but reducing unnecessary comparisons:  
//    - Directly return `start` at the end instead of keeping track  
// - Fewer comparisons → slightly faster execution  
// ------------------------------------------------------------
// ✅ Time Complexity: O(log n)
// ✅ Space Complexity: O(1) (constant extra space)
// ------------------------------------------------------------

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while (start < end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return (nums[start] < target) ? start + 1 : start;
    }
}
// ============================================================================
// ✅ Summary of Approaches  
// ============================================================================
// | Approach                        | Time Complexity | Space Complexity | Notes |
// |----------------------------------|-----------------|------------------|-------|
// | Brute Force                     | O(n)            | O(1)              | Linear search through the array |
// | Better Approach                 | O(log n)         | O(1)              | Binary search with mid-point comparison |
// | Optimal Approach                | O(log n)         | O(1)              | Binary search with fewer comparisons |
// ============================================================================
