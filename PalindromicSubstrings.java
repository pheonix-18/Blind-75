//O(n^2), O(1)
// Count the number of palindromic strings in the given string
public class Solution {
    int count = 0;
    
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
}



//O(n^2) O(n^2)

class Solution {
    public int countSubstrings(String s) {
        int l = s.length();
        int PCount = l;
        int [][]dp = new int[l][l];
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
                        PCount++;
                    }
                }
            }
        }
        return PCount;
    }
}
