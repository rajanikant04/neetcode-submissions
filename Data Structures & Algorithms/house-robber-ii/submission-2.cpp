class Solution {
public:
    int func(int idx, int end, vector<int>& nums, vector<int>& dp){
        if(idx<end) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int rob= nums[idx]+func(idx-2,end,nums,dp);
        int not_rob= func(idx-1, end, nums, dp);
        return dp[idx]= max(rob, not_rob);
    }
    int rob(vector<int>& nums) {
        int n= nums.size();
        if(n==1) return nums[0];
        // cout<<n<<endl;
        vector<int>dp1(n,-1);
        int a= func(n-1,1,nums,dp1);
        vector<int>dp2(n,-1);
        int b= func(n-2,0,nums,dp2);
        return max(a,b);
    }
};
