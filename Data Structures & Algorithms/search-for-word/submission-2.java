class Solution {
    int[] dx= {1,-1,0,0};
    int[] dy= {0,0,-1,1};
    public boolean func(int i, int j, int idx, char[][] board, boolean[][] vis,String word){
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }
        if(idx==word.length()-1){
            return true;
        }
        vis[i][j]= true;
        for(int k=0;k<4;k++){
            int ni= i+dx[k];
            int nj= j+dy[k];
            if(ni>=0 && ni<board.length && nj>=0 && nj<board[0].length && vis[ni][nj]==false && board[i][j]==word.charAt(idx)){
                if(func(ni,nj,idx+1,board,vis,word)) return true;
            }
        }
        vis[i][j]=false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m= board.length, n=board[0].length;
        boolean[][] vis= new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0) && func(i,j,0,board,vis,word)) return true;
            }
        }
        return false;
    }
}
