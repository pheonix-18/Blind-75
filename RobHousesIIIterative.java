class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
          return nums[0];
        return Math.max(robHouses(nums, 0, n - 1), robHouses(nums, 1, n));
    }
    int robHouses(int nums[], int start, int end){
        int n = end - start;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[start];

        for(int i = 2; i <= n; i++)
            dp[i] = Math.max(dp[i - 1], nums[++start] + dp[i - 2]);

        return dp[n];
    }
}
