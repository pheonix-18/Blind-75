//208. Implement Trie (Prefix Tree)
class TrieNode{
    boolean isEnd;
    Map<Character, TrieNode> childNodes;
    TrieNode(){
        isEnd = false;
        childNodes = new HashMap<>();
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for(Character ch: word.toCharArray()){
            if(!temp.childNodes.containsKey(ch))
                temp.childNodes.put(ch, new TrieNode());
            temp = temp.childNodes.get(ch);
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        for(Character ch: word.toCharArray()){
            if(!temp.childNodes.containsKey(ch))
                return false;
            temp = temp.childNodes.get(ch);
        }
        return temp.isEnd == true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(Character ch: prefix.toCharArray()){
            if(!temp.childNodes.containsKey(ch))
                return false;
            temp = temp.childNodes.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
