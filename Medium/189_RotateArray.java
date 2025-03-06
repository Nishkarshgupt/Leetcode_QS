class Solution {
    public void rotate(int[] nums, int k) {
        int arr1[] = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            arr1[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr1[i];
        }
    }
}
