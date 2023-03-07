class Solution {
    int dp[];
    // Valid if doesn't start with 0 and less than 27
    public boolean stringValid(String s){
        if(!s.startsWith("0") && Integer.parseInt(s)<=26)
            return true;
        return false;
    }
    public int dpHelper(int index, int[] dp, String s){
        // System.out.println(index);
        if(index >= s.length())
            return 1;
        if(dp[index] != 0)
            return dp[index];
        if(stringValid(s.substring(index, index+1)))
            dp[index] += dpHelper(index+1, dp, s);
        if(index + 2 <= s.length() && stringValid(s.substring(index, index+2)))
            dp[index] += dpHelper(index+2, dp, s);
        return dp[index];
    }
    public int numDecodings(String s) {
        int n = s.length();
        if(s.startsWith("0"))
            return 0;
        dp = new int[n];
        return dpHelper(0, dp, s);
    }
}
