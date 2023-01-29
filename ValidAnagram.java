import java.util.HashMap;

// TC : O(m + n + c) => O(m + n) SC: O(c)
public class ValidAnagram {
    public boolean isAnagram(String s, String t){
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        for(char ch: s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }

        for(char ch: t.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) - 1);
        }
        
        for(char ch: freqMap.keySet()){
            if(freqMap.get(ch)!=0)
                return false;
        }
        return true;
    }
}
