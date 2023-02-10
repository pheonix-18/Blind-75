import java.util.*;
// Keep the elements in a set, Start with lowest element of a sequence. Remove the elements in a 
// Sequence. 
class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n:nums)
            set.add(n);
        int maxLen = 1;
        int curLen = 1;
        for(int n: set){
            curLen = 1;
            if(!set.contains(n-1)){
                while(set.contains(n+curLen)){
                    set.remove(n+curLen);
                    curLen++;
                }
                maxLen = Math.max(maxLen, curLen);
        }
    }
        return maxLen;
    }
}