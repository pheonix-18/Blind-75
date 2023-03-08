class Solution {
    public int maxProduct(int[] nums) {
        int prefixProduct = 0, suffixProduct = 0, maxProduct = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            prefixProduct = prefixProduct == 0? 1: prefixProduct;
            suffixProduct = suffixProduct == 0? 1: suffixProduct;
            prefixProduct *= nums[i];
            suffixProduct *= nums[nums.length - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));
        }
        return maxProduct;
        
    }
}
