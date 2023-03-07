// O(n) + O(n)
class Solution {
    int n;
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0 || s.startsWith("0"))
            return 0;
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int i_1 = 0, i_2 = 0;
            if(isStringValid(s.substring(i - 1, i)))
                i_1 = dp[i - 1];
            if(isStringValid(s.substring(i - 2, i)))
                i_2 = dp[i - 2];
            dp[i] = i_1 + i_2;
        }
        return dp[n];
    }

    public boolean isStringValid(String s){
        if(!s.startsWith("0") && Integer.parseInt(s) <=26)
            return true;
        return false;
    }
}
