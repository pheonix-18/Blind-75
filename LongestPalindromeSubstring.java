// 2D Array Version
// O(n2), O(n) Memory
class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        int PStart = l - 1, PEnd = l;
        int [][]dp = new int[l][l];
        for(int[] d: dp)
            Arrays.fill(d,0);
        int maxLength = 1;
        //Make single letters as palindromes
        for(int i = 0; i < l ; i++){
            dp[i][i] = 1;
        }
        for(int start = l - 1; start >= 0; start--){
            for(int end = l - 1; end > start; end--){
                if(s.charAt(start)==s.charAt(end)){
                    if(end - start == 1 || dp[start+1][end-1]  == 1){
                        dp[start][end] = 1;
                        if(end - start +1 > maxLength){
                            maxLength = end - start + 1;
                            PStart = start;
                            PEnd = end + 1;
                        }
                    }
                }
            }
        }
        return s.substring(PStart, PEnd);
    }
}

// O(n2) O(1)
class Solution {
    public String longestPalindrome(String s) {
        String palindrome = null;
        int maxLen = Integer.MIN_VALUE;
        
        for(int i = 0; i < s.length(); i++){
            int l = i, r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > maxLen){
                    maxLen = r - l + 1;
                    palindrome = s.substring(l, r+1);
                }
                l--;
                r++;
            }

            l = i;
            r = i+1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > maxLen){
                    maxLen = r - l + 1;
                    palindrome = s.substring(l, r+1);
                }
                l--;
                r++;
            }
        }

        return palindrome;

    }
}
