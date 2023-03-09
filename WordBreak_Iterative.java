
class Solution {
    // Sub Problem dp[i] = dp[j] + s[j: i]
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i <= s.length(); i++){
            boolean canBreak = false;
            for(String w: wordDict){
                int len = w.length();
                if(i - len >= 0 && s.substring(i - len, i).equals(w))
                    canBreak = dp[i - len];
                if(canBreak){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
