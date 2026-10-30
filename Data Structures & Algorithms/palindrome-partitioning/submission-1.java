class Solution {
    public boolean isPalidrome(String s){
        int n= s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-1-i)) return false;
        }
        return true;
    }
    public void func(int idx, String s, List<String>v, List<List<String>>ans){
        if(idx==s.length()) {
            ans.add(new ArrayList<>(v));
            return;
        }
        for(int i=idx;i<s.length();i++){
            String str= s.substring(idx,i+1);
            if(isPalidrome(str)){
                v.add(str);
                func(i+1,s,v,ans);
                v.remove(v.size()-1);
            }
        }
        return ;
    }
    public List<List<String>> partition(String s) {
        List<List<String>>ans= new ArrayList<>();
        List<String>v= new ArrayList<>();
        func(0,s,v,ans);
        return ans;
    }
}
