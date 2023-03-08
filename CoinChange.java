// Recursive
class Solution {
    int dp[];
    int k = 0;
    public int coinChangeHelper(int[] coins, int amount){
        // System.out.println(k++ + " " + amount);
        if(amount < 0)
            return -1;
        if(amount == 0)
            return 0;
        else if(dp[amount] != 0)
            return dp[amount];
        else{
            int min = Integer.MAX_VALUE;
                for(int coin : coins) {
                    int res = coinChangeHelper(coins, amount-coin);
                    if(res>=0 && res < min)
                        min = 1+res;
                }
            dp[amount] = (min == Integer.MAX_VALUE? -1: min);
        }
        return dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        dp[0] = 0;
        return coinChangeHelper(coins, amount);
    }
}
