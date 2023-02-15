class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
       Map<Character, Integer> IndexMap = new HashMap<>();
       int left = 0, right = 1, longestLen = 1;
       IndexMap.put(s.charAt(left), left);
        while(right < s.length()){
            char ch = s.charAt(right);
            if(IndexMap.containsKey(ch)){
                int pos = IndexMap.get(ch);
                if(pos >= left){
                    //Repeating character
                    longestLen = Math.max(longestLen, right - left);
                    left = IndexMap.get(ch) + 1;
                }
            }
            IndexMap.put(ch, right);
            right++;
        }
        return Math.max(longestLen, right - left);
    }
}
