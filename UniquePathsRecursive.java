class Solution {
    int ways = 0;
    int M, N;
    public int findWays(int dp[][], int m, int n){
        if(m == M || n == N)
            return 0;
        if(dp[m][n] != 0)
            return dp[m][n];
        dp[m][n] = findWays(dp, m+1, n) + findWays(dp, m, n+1);
        return dp[m][n];
    }
    public int uniquePaths(int m, int n) {
        M = m+1; N = n+1;
        int dp[][] = new int[m+1][n+1];
        dp[m][n] = 1;
        return findWays(dp, 1, 1);
    }
}
