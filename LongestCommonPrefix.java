class Solution {
    public String longestCommonPrefix(String[] strs) {
        String refString = strs[0];
        StringBuffer lcp = new StringBuffer("");
        int curPos = 0;
        for(char ch: refString.toCharArray()){
            for(String s: strs){
                if(s.length() <= curPos || ch != s.charAt(curPos))
                    return lcp.toString();            
            }
            lcp.append(ch);
            curPos++;
        }
        return lcp.toString();
    }
}
