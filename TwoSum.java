import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> lookup = new HashMap<Integer,Integer> ();
        for(int i = 0 ; i < nums.length ; i++){
            int searchFor = target - nums[i];
            if(lookup.containsKey(searchFor))
                return new int[]{i, lookup.get(searchFor)};
            else
                lookup.put(nums[i], i);
                
        }
        return new int[]{-1, -1};
    }
}
