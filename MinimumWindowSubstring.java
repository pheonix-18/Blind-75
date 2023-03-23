//Time Complexity O(|s| + |t|) , Space; O(|s| + |t|)
// LC Hard

class Node{
    Character ch;
    Integer pos;
    Node(Character ch, Integer pos){
        this.ch = ch;
        this.pos = pos;
    }
}

public class Solution {
    public String minWindow(String s, String t) {
        int seenString = 0;
        int wS = 0, wE = 0;
        Queue<Node> q = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        String minString = null;

        for(Character ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int index = wS; index < s.length(); index++){
            Character key = s.charAt(index);
            if(!map.containsKey(key))
                continue;
            q.add(new Node(key, index));
            if(seenString == 0){
                    wS = index;
            }
            if(map.get(key)>0)
                seenString++;
            map.put(key, map.get(key)-1);
            while(seenString == t.length()){
                wE = index;
                if(minString == null || wE - wS + 1 < minString.length()){
                    minString = s.substring(wS, wE + 1);
                }
                Node top = q.poll();
                if(q.isEmpty())
                    break;
                if(map.get(top.ch) >= 0)
                    seenString--;
                map.put(top.ch, map.get(top.ch)+1);
                wS = q.peek().pos;
            }
        }
        return minString==null? "" : minString;
    }
}
