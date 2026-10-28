class Solution {
    void func(int idx, int[] candidates, int target, List<Integer>v, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(v));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            v.add(candidates[i]);
            func(i+1,candidates, target-candidates[i], v, ans);
            v.remove(v.size()-1);
        }
        return ;        
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> v = new ArrayList<>();;
        func(0, candidates, target, v, ans);
        return ans;
    }
}
