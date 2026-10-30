class Solution {
    public boolean isPalidrome(String s){
        int n= s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-1-i)) return false;
        }
        return true;
    }
    public void func(int idx, int last, String s, List<String>v, List<List<String>>ans){
        if(idx==s.length()) {
            if(last==s.length()-1){
                ans.add(new ArrayList<>(v));
            }
            return;
        }
        String str= s.substring(last+1,idx+1);
        if(isPalidrome(str)){
            func(idx+1,last,s,v,ans);
            v.add(str);
            func(idx+1,idx,s,v,ans);
            v.remove(v.size()-1);
        }
        else{
            func(idx+1,last,s,v,ans);
        }
        return ;
    }
    public List<List<String>> partition(String s) {
        List<List<String>>ans= new ArrayList<>();
        List<String>v= new ArrayList<>();
        func(0,-1,s,v,ans);
        return ans;
    }
}
