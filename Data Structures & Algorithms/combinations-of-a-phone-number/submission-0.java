class Solution {
    List<String>l= Arrays.asList("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
    public void func(int idx, String digits, String s, List<String>ans){
        if(idx==digits.length()) {
            if(s.length()>0) ans.add(s);
            return ;
        }
        char ch= digits.charAt(idx);
        int val= ch-'0';
        for(char k:l.get(val-2).toCharArray()){
            func(idx+1,digits,s+k,ans);
        }
        return ;
    }
    public List<String> letterCombinations(String digits) {
        List<String>ans = new ArrayList<>();
        String s="";
        func(0,digits,s,ans);
        return ans;
    }
}
