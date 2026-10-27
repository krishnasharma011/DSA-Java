class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        char[][] arr = new char[m][n];

        for(int i=0;i<(n/2);i++){
            arr[0][i] = '.';
        }
        for(int i=0;i<m;i++){
            arr[i][(n/2)]='.';
        }
        for(int i=((n/2)+1);i<n;i++){
            arr[m-1][i]='.';
        }
        for(int i=0;i<m;i++){
            String temp="";
            for(int j=0;j<n;j++){
                if(arr[i][j]!='.') arr[i][j] = '#';
                temp+=arr[i][j];
            }
            ans[i] = temp;
        }
        return ans;
    }
}