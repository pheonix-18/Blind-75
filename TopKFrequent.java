import java.util.*;
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> itemFreq = new HashMap<Integer, Integer> ();
        for(int n : nums){
            itemFreq.put(n, itemFreq.getOrDefault(n,0)+1);
        }
        List<Integer> freqItems[] = new ArrayList[nums.length+1];
        
        for(int key: itemFreq.keySet()){
            int v = itemFreq.get(key);
            if(freqItems[v]==null){
                freqItems[v] = new ArrayList();
            }
            freqItems[v].add(key);
        }
        int ans[] = new int[k];
        for(int i = freqItems.length-1; i>0 && k>0; i--){
            if(freqItems[i]==null)
                continue;
            
            List<Integer> values = freqItems[i];
            for(int v: values){
                ans[k-1] = v;
                k--;
            } 
        }
        return ans;
    }
}