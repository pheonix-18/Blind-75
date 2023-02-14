class Solution {
    public int maxProfit(int[] prices) {
        int profit = Integer.MIN_VALUE, maximumSP = prices[prices.length - 1];
        int revPointer = prices.length - 1;
        while(revPointer >= 0){
            maximumSP = Math.max(maximumSP, prices[revPointer]);
            profit = Math.max(profit, maximumSP - prices[revPointer]);
            revPointer--;
        }
        return profit < 0? 0: profit;
    }
}


// Compute Max
// Find Difference between value at i and Max
// Compute Max Profit
