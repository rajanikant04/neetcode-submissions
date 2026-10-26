class Solution {
public:
    int func(int idx, vector<int>& nums, vector<int>& dp){
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int rob= nums[idx];
        rob+= func(idx-2, nums, dp);
        int not_rob= func(idx-1, nums, dp);
        return dp[idx]= max(rob, not_rob);
    }
    int rob(vector<int>& nums) {
        int n= nums.size();
        if(n==1) return nums[0];
        vector<int>dp(n,-1);
        return func(n-1, nums, dp);
    }
};