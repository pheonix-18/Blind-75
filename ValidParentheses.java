class Solution {
    public boolean isOpening(char c){
        if(c=='[' || c=='{' || c=='(')
            return true;
        return false;
    }
    public boolean isValid(String s) {
       Deque<Character> Stack = new ArrayDeque<>();
       Map<Character, Character> BracketPairs = new HashMap<>();
       BracketPairs.put(']','[');
       BracketPairs.put('}','{');
       BracketPairs.put(')','(');
        for(char c: s.toCharArray()){
            if(isOpening(c))
                Stack.push(c);
            else{
                if(Stack.isEmpty() || Stack.peek()!= BracketPairs.get(c)){
                    return false;
                }else
                    Stack.pop();
                    
            }
        }
        // System.out.println(Stack.peekFirst() + " " + Stack.peekLast());
        return Stack.isEmpty();
    }
}
