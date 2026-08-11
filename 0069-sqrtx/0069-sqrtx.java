class Solution {
    public int mySqrt(int x) {
        int lo=0;
        int hi=x;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            long sq=(long) mid*mid;
            if(sq==x) return mid;
            else if(sq<x){
                ans=mid;
                lo=mid+1;
            }
            else hi=mid-1;
        }
        return hi;
    }
}