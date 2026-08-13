class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxProft=0;
        int buy=prices[0];
        for(int i=1;i<n;i++){
            int sell=prices[i];
            if(sell<buy) buy=sell;
            int currProft=sell-buy;
            maxProft=Math.max(maxProft,currProft);
        }
        return maxProft;
    }
}