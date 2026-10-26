class Solution {
public:
    string longestPalindrome(string s) {
        int n= s.length();
        int st=0, len=0;
        vector<vector<bool>>dp(n, vector<bool>(n, false));
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s[i]==s[j] && (j-i+1<=3 || dp[i+1][j-1])){
                    dp[i][j]=true;
                    if(j-i+1>len) {
                        len= j-i+1;
                        st=i;
                    }
                }
            }
        }
        return s.substr(st,len);
    }
};
