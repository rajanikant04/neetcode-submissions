class Solution {
public:
    int func(int idx, vector<int>& dp){
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx]=func(idx-1,dp)+ func(idx-2,dp);
    }

    int climbStairs(int n) {
        vector<int>dp(n+1,-1);
        dp[0]=1; 
        return func(n,dp);
    }
};
