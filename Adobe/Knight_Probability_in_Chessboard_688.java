class Solution {
   
    Map<String,Double> map;
	
    public double knightProbability(int N, int K, int r, int c) {
	
		map = new HashMap();
       double result = prob(N,K,r,c) / Math.pow(8,K); 
        return result;
    }
    public double prob(int N,int K,int r,int c){
        if(r < 0 || r >= N || c < 0 || c >= N){
            return 0;
        }
        String key = K +"->"+r+"->"+c;
        if(K==0){
            return 1;
        } 
        if(map.containsKey(key))return map.get(key);
        double op1 = prob(N,K-1,r+2,c+1);
        double op2 = prob(N,K-1,r+2,c-1);
        double op3 = prob(N,K-1,r-2,c+1);
        double op4 = prob(N,K-1,r-2,c-1);
        double op5 = prob(N,K-1,r-1,c+2);
        double op6 = prob(N,K-1,r+1,c+2);
        double op7 = prob(N,K-1,r+1,c-2);
        double op8 = prob(N,K-1,r-1,c-2);
        
        double result = op1 + op2 + op3 + op4 + op5 + op6 + op7 + op8;
        map.put(key , result);
        return result;
    }
    
}