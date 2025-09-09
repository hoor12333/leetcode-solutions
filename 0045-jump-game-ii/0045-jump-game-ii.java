class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;  // No jumps needed if there's only one element

        int ans = 0;
        int end = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {  // no need to process the last index
            farthest = Math.max(farthest, nums[i] + i);

            if (i == end) {
                ans++;
                end = farthest;

                if (end >= n - 1) { 
                    break;  // already can reach the end
                }
            }
        }
        return ans;
    }
}
