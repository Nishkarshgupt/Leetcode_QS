//LeetCode 189: Rotate Array
//Problem Link: https:leetcode.com/problems/rotate-array/description/

// ------------------------------------------------------------
// 📝 Approach 1: Using Extra Array (Simple Approach)
// ------------------------------------------------------------
// - Create a new array of same size as `nums[]`.
// - Place each element at its new rotated position `(i + k) % n`.
// - Copy the new array back to `nums[]`.
// ------------------------------------------------------------
// ✅ Time Complexity: O(n)
// ✅ Space Complexity: O(n) (extra array used)
// ------------------------------------------------------------

class Solution {
    public void rotate(int[] nums, int k) {
        int newArr[] = new int[nums.length];

        // Placing elements at new position
        for (int i = 0; i < nums.length; i++) {
            newArr[(i + k) % nums.length] = nums[i];
        }

        // Copying back to original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArr[i];
        }
    }
}

// ------------------------------------------------------------
// 📝 Approach 2: In-Place Rotation using Reverse Method (Optimized)
// ------------------------------------------------------------
// - Reverse the entire array.
// - Reverse the first `k` elements.
// - Reverse the remaining `n-k` elements.
// - No extra space used (in-place).
// ------------------------------------------------------------
// ✅ Time Complexity: O(n)
// ✅ Space Complexity: O(1) (no extra array used)
// ------------------------------------------------------------

class SolutionOptimized {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n

        // Step 1: Reverse entire array
        reverse(nums, 0, n - 1);
        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);
        // Step 3: Reverse remaining elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
