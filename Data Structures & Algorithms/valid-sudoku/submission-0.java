class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch= board[i][j];
                if(board[i][j]!='.'){
                    for(int k=0;k<9;k++){
                        if(k!=j){
                            if(board[i][k]==ch) return false;
                        }
                        if(k!=i){
                            if(board[k][j]==ch) return false;
                        }
                    }
                    for(int m=3*(i/3);m<3*((i+3)/3);m++){
                        for(int n=3*(j/3);n<3*((j+3)/3);n++){
                            if(m==i && n==j) continue;
                            if(board[m][n]==ch) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
