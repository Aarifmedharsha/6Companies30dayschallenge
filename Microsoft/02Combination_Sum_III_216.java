class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> collectionofsubsets=new ArrayList<>();
        List<Integer> currsubset=new ArrayList<>();
        comb(1,9,k,n,0,collectionofsubsets,currsubset);
        return collectionofsubsets;
    }
    void comb(int s,int e,int k,int n,int sum,List<List<Integer>> collectionofsubsets,List<Integer> currsubset){
        if(k==0){
            if(sum==n){
                collectionofsubsets.add(new ArrayList(currsubset));
                return;
            }
            return;
        }
        if(s>e) return;
        if(sum>n) return;
        sum+=s;
        currsubset.add(s);
        comb(s+1,e,k-1,n,sum,collectionofsubsets,currsubset);
        sum-=s;
        currsubset.remove(currsubset.size()-1);
        comb(s+1,e,k,n,sum,collectionofsubsets,currsubset);

    }
}
