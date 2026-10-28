class Solution {
public:
    void func(int idx, vector<int>& nums, vector<int>v, vector<vector<int>>& ans){
        if(idx==nums.size()) {
            ans.push_back(v);
            return ;
        }
        // take
        v.push_back(nums[idx]);
        func(idx+1,nums,v,ans);
        v.pop_back();
        // not_take
        func(idx+1,nums,v,ans);
        return ;
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        int n= nums.size();
        vector<vector<int>>ans;
        vector<int>v;
        func(0, nums, v, ans);
        return ans;
    }
};
