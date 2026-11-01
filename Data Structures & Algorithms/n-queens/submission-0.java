class Solution {
    public boolean pos(int row, int n, int col, List<String>v){
        int dis=1;
        for(int i=row-1;i>=0;i--){
            if(v.get(i).toCharArray()[col]=='Q') return false;
            if(col-dis>=0){
                if(v.get(i).toCharArray()[col-dis]=='Q') return false;
            }
            if(col+dis<n){
                if(v.get(i).toCharArray()[col+dis]=='Q') return false;
            }
            dis++;
        }
        return true;
        
    }
    public void func(int row,int n, String s, List<String>v, List<List<String>>ans){
        if(row==n) {
            ans.add(new ArrayList<>(v));
            return ;
        }
        for(int i=0;i<n;i++){
            if(pos(row,n,i,v)){
                char[] arr = s.toCharArray();
                arr[i] = 'Q';
                String k= new String(arr);
                v.add(k);
                func(row+1,n,s,v,ans);
                v.remove(v.size()-1);
            }
        }
        return ;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans = new ArrayList<>();
        List<String>v = new ArrayList<>();
        String s = ".".repeat(n);
        func(0,n,s,v,ans);
        return ans;
    }
}
