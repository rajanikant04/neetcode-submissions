class Solution {
    public void func(int o, int c, int n, String s, List<String>ans){
        if(o==n && c==n) {
            ans.add(s);
            return ;
        }
        if(o<n){
            func(o+1,c,n,s+'(',ans);
        }
        if(c<o){
            func(o,c+1,n,s+')',ans);
        }
        return ;
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String s="";
        func(0,0,n,s,ans);
        return ans;
    }
}
