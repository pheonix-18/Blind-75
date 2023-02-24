// 211. Design Add and Search Words Data Structure
class TrieNode{
    boolean isEnd;
    Map<Character, TrieNode> childNodes;
    TrieNode(){
        isEnd = false;
        childNodes = new HashMap<>();
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode temp = root;
        for(Character ch: word.toCharArray()){
            if(!temp.childNodes.containsKey(ch))
                temp.childNodes.put(ch, new TrieNode());
            temp = temp.childNodes.get(ch);
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word, TrieNode base) {
        TrieNode temp = base;
        for(int i = 0; i < word.length(); i++){
            Character ch = word.charAt(i);
            if(ch.equals('.')){
                boolean found = false;
                for(Character key: temp.childNodes.keySet()){
                    TrieNode node = temp.childNodes.get(key);
                    if(search(word.substring(i+1), node))
                        return true;
                }
                return false;
            }
            if(!temp.childNodes.containsKey(ch))
                return false;
            temp = temp.childNodes.get(ch);
        }
        return temp.isEnd == true;
    }
    public boolean search(String word) {
        return search(word, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
