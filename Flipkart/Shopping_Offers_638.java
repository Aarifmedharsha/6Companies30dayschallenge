class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if(special.size()==0){
            int res = 0;
            for(int i=0;i<price.size();i++) res+=price.get(i)*needs.get(i);
            return res;
        }
        List<Integer> back = new LinkedList<>(needs);
        List<Integer> tmp = new LinkedList<>(special.get(0));int max = Integer.MAX_VALUE;int cost = tmp.get(tmp.size()-1);
        for(int i=0;i<price.size();i++) if(tmp.get(i)!=0)   max = Math.min(max,needs.get(i)/tmp.get(i));
        special.remove(0);int sum = Integer.MAX_VALUE;


        for(int i=0;i<=max;i++){
            if(i!=0)
                for(int j=0;j<price.size();j++)
                    back.set(j,back.get(j)-tmp.get(j));
            int st = shoppingOffers(price,special,back);
            sum = Math.min(sum,cost*i+st);
        }

        special.add(0,tmp);
        return sum;

    }
}