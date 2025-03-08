// LeetCode Problem: 977. Squares of a Sorted Array
// Difficulty: Easy
// Link: https://leetcode.com/problems/squares-of-a-sorted-array/


// --------------------------------------------------------------------------------------
// ✅ Approach:
// 1. First, square all the elements of the array.
// 2. Then, use the Bubble Sort algorithm to sort the squared elements in ascending order.
// -------------------------------------------------------------------------------------
// ⏰ Time Complexity:
// - Squaring elements: O(n)
// - Sorting using Bubble Sort: O(n²)
// ➡️ Total: O(n²)
// -------------------------------------------------------------------------------------
// 💾 Space Complexity:
// - O(1) (In-place sorting)
// -------------------------------------------------------------------------------------
// 🔥 Status: ✔️ Accepted
// -------------------------------------------------------------------------------------


class Solution {
    public int[] sortedSquares(int[] nums) {
        // Step 1: Square all elements of the array
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }

        // Step 2: Sort the squared elements using Bubble Sort
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j < nums.length - 1 - i; j++){
                if(nums[j] > nums[j + 1]){
                    // Swap nums[j] and nums[j + 1]
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
