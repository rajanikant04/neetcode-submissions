class Solution {
public:
    bool isPali(string a){
        int n= a.length();
        for(int i=0;i<n/2;i++){
            if(a[i]!=a[n-1-i]) return false;
        }
        return true;
    }
    string longestPalindrome(string s) {
        int n= s.length();
        string ans="";
        for(int i=0;i<n;i++){
            int l=i,r=i;
            while(l>=0 && r<n){
                if(s[l]==s[r]){
                    if(r-l+1>=ans.length()){
                        ans=s.substr(l,r-l+1);
                    }
                    r++;
                    l--;
                }
                else break;
            }
        }
        for(int i=0;i<n-1;i++){
            int l=i,r=i+1;
            while(l>=0 && r<n){
                if(s[l]==s[r]){
                    if(r-l+1>=ans.length()){
                        ans=s.substr(l,r-l+1);
                    }
                    r++;
                    l--;
                }
                else break;
            }
        }
        return ans;
    }
};
