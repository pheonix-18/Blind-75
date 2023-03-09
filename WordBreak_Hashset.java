// O(N2)
class Solution {
    // Sub Problem dp[i] = dp[j] + s[j: i]
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet(wordDict);
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            boolean canBreak = false;
            for(int j = 0; j <= i; j++){
                canBreak = canBreak || (dp[j] && dict.contains(s.substring(j, i)));
            }
            dp[i] = canBreak;
        }
        return dp[s.length()];
    }
}
