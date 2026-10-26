class Solution {
public:
    int func(int idx, vector<int>& cost, vector<int>& dp){
        if(idx<=1) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int a=1e9,b=1e9;
        if(idx-1>=0) b=cost[idx-1]+func(idx-1, cost, dp);
        if(idx-2>=0) a=cost[idx-2]+func(idx-2, cost, dp);
        return dp[idx]=min(a,b);
    }
    int minCostClimbingStairs(vector<int>& cost) {
        int n= cost.size();
        vector<int>dp(n+1, -1);
        func(n, cost, dp);
        // for(int i=0;i<n+1;i++) {
        //     cout<<dp[i]<<" ";
        // }
        return dp[n];
    }
};
