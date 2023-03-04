class Solution {
    public int robHelper(int i , int dp[], int nums[]){
        if(i < 0)
            return 0;
        if(dp[i] != -1)
            return dp[i];
        dp[i] = Math.max(robHelper(i - 1, dp, nums), nums[i] + robHelper(i - 2, dp, nums));
        return dp[i];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return robHelper(n-1, dp, nums);
    }
}
