class Solution {
    public boolean canWinNim(int n) {
        int temp=n%4;
        if(temp==0) return false;
        return true;
    }
}