class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // normalize k in case k > n

        // Step 1: reverse whole array
        reverse(nums, 0, n - 1);
        // Step 2: reverse first k elements
        reverse(nums, 0, k - 1);
        // Step 3: reverse remaining n-k elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--; // \U0001f525 this was missing
        }
    }
}
