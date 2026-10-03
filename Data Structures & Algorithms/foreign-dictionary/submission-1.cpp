class Solution {
public:
    string foreignDictionary(vector<string>& words) {
        int n= words.size();
        vector<vector<bool>>adj(26, vector<bool>(26, 0));
        vector<bool>vis(26,0);
        int cnt=0;
        for(int i=0;i<n-1;i++){
            string a= words[i], b= words[i+1];
            for(int j=0;j<a.length();j++){
                if(!vis[a[j]-'a']){
                    vis[a[j]-'a']=1;
                    cnt++;
                }
            }
            for(int j=0;j<a.length();j++){
                if(j>=b.length()) return "";
                char ch1=a[j], ch2=b[j];
                if(ch1==ch2) continue;
                if(adj[ch2-'a'][ch1-'a']) return "";
                adj[ch1-'a'][ch2-'a']=1;
                break;
            }
        }
        for (char ch : words[n - 1]) {
            if (cnt == 26) break;
            int chIdx = ch - 'a';
            if (!vis[chIdx]) {
                cnt++;
                vis[chIdx] = 1;
            }
        }
        vector<int>indegree(26,0);
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i!=j && adj[i][j]) indegree[j]++;
            }
        }
        queue<int>q;
        for(int i=0;i<26;i++) {
            if(vis[i] && indegree[i]==0) q.push(i);
        }
        string ans="";
        while(!q.empty()) {
            int ch= q.front();
            q.pop();
            ans.push_back(ch+'a');
            for(int i=0;i<26;i++){
                if(i!=ch && adj[ch][i]) {
                    indegree[i]--;
                    if(indegree[i]==0) q.push(i);
                }
            }
        }
        return ans.length()==cnt ? ans: "";
    }
};
