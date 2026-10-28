class Solution {
    public void func(int idx, int[] nums, List<Integer>v, List<List<Integer>>ans){
        ans.add(new ArrayList<>(v));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;
            v.add(nums[i]);
            func(i+1, nums, v, ans);
            v.remove(v.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans= new ArrayList<>();
        List<Integer>v= new ArrayList<>();
        func(0, nums, v, ans);
        return ans;
    }
}
