class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallestOdd=Integer.MAX_VALUE;
        int smallest=Integer.MAX_VALUE;
        int oddCount=0;
        for(int i=0;i<nums1.length;i++){
            smallest=Math.min(smallest,nums1[i]);      
            if(nums1[i]%2!=0){
                oddCount++;
                smallestOdd=Math.min(smallestOdd,nums1[i]);      
            }
        }
        if(oddCount==0 || oddCount==nums1.length) return true;
        if(smallestOdd==smallest || smallestOdd<smallest) return true;
        return false; 
    }
}