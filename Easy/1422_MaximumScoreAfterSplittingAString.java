// LeetCode 1422: Maximum Score After Splitting a String
// Problem Link: https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/


// ------------------------------------------------------------
// 📝 Approach 1: Brute Force
// ------------------------------------------------------------
// - Try all possible split positions from index 1 to n-1
// - For each split, count zeroes in the left part and ones in the right part
// - Keep track of maximum score
// ------------------------------------------------------------
// ✅ Time Complexity: O(n^2)
// ✅ Space Complexity: O(1)
// ------------------------------------------------------------

class Solution {
    public int maxScore(String s) {
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int zero = 0, one = 0;

            // Count 0s in left part
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') zero++;
            }

            // Count 1s in right part
            for (int k = i + 1; k < s.length(); k++) {
                if (s.charAt(k) == '1') one++;
            }

            max = Math.max(max, zero + one);
        }
        return max;
    }
}

// ------------------------------------------------------------
// 📝 Approach 2: Prefix Count (Optimized)
// ------------------------------------------------------------
// - Count total number of 1s in the string first.
// - Then, while traversing, maintain count of 0s seen so far.
// - At each split (from 0 to n-2), calculate: score = 0s so far + (total 1s - 1s seen so far).
// - Update max score accordingly.
// ------------------------------------------------------------
// ✅ Time Complexity: O(n)
// ✅ Space Complexity: O(1)
// ------------------------------------------------------------

class SolutionOptimized {
    public int maxScore(String s) {
        int totalOnes = 0;
        int max = 0;
        int zeroCount = 0;
        int oneSoFar = 0;

        // Count total 1s in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        // Traverse string and find max score
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            } else {
                oneSoFar++;
            }

            int score = zeroCount + (totalOnes - oneSoFar);
            max = Math.max(max, score);
        }

        return max;
    }
}

// ------------------------------------------------------------
// 📊 Summary Table:
// ------------------------------------------------------------
// | Approach                  | Time Complexity | Space Complexity | Description                     |
// |---------------------------|------------------|------------------|---------------------------------|
// | Brute Force               | O(n^2)           | O(1)             | Try all splits, count 0s & 1s   |
// | Prefix Count (Optimized) | O(n)             | O(1)             | Count 1s, then single traversal |
// ------------------------------------------------------------
