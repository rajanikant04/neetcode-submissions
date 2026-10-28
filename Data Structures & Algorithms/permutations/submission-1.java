class Solution {
    public void func(int[] nums, boolean[] vis, List<Integer>v, List<List<Integer>> ans){
        if(v.size()==nums.length) {
            ans.add(new ArrayList<>(v));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(vis[i]==true) continue;
            v.add(nums[i]);
            vis[i]=true;
            func(nums,vis,v,ans);
            v.remove(v.size()-1);
            vis[i]=false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans= new ArrayList<>();
        List<Integer>v= new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        func(nums, vis, v, ans);
        return ans;
    }
}
