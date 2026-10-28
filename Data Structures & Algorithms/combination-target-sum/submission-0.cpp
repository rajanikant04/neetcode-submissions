class Solution {
public:
    void func(int idx, vector<int>& nums, int target, vector<int>v, vector<vector<int>>& ans){
        if(idx==nums.size()) {
            if(target==0) {
                ans.push_back(v);
                return;
            }
            return ;
        }
        // take
        if(nums[idx]<= target){
            v.push_back(nums[idx]);
            func(idx, nums, target-nums[idx], v, ans);
            v.pop_back();
        }
        // not_take
        func(idx+1, nums, target, v, ans);
        return;
    }
    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        vector<vector<int>>ans;
        vector<int>v;
        func(0, nums, target, v, ans);
        return ans;
    }
};
