class Solution {
    List<String> validPairs = new ArrayList<String>();
    int n;
    public void genValidPair(int open, int close, String pat){
        if(open==close && close==n)
            validPairs.add(pat);
        if(open < n){
            genValidPair(open+1, close, pat+"(");
        }G
        if(close<open){
            genValidPair(open, close+1, pat+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        this.n = n;
        genValidPair(0,0,"");
        return validPairs;
    }
}
