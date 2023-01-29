import java.util.*;

public class GroupAnagrams {
    /**
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        Map<String, List> group = new HashMap<String, List>();
        for(String s: strs){
            // Sorting a single string
            char[] strList = s.toCharArray();
            Arrays.sort(strList);
            String sortedString = String.valueOf(strList);
            if(!group.containsKey(sortedString)){
                group.put(sortedString, new ArrayList());
            }
            group.get(sortedString).add(s);
            
        }
        return new ArrayList(group.values());
    }
}
