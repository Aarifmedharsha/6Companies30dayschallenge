class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set1 = new HashSet<>();
        double r=Math.pow(2,k);
        
        for(int i=0;i<s.length()-k+1;i++){
            set1.add(s.substring(i,i+k));
            //System.out.println(set1);
            if(set1.size()==r){
                //System.out.println("K");
                return true;
            }
        }
        return false;
    }
}



















