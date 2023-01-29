import java.util.Arrays;

// Problem. Leetcode 217. Contains Duplicate
// Complexity 
// 1. Using Set - O(n) Time and O(n) Set
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++)
            if(nums[i] == nums[i+1])      
                return true;
        return false;  
    }
}