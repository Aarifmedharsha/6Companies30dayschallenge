class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int min=1000000;
        for(int i=0;i<cards.length;i++){
            if(map.containsKey(cards[i])){
                int temp=i-map.get(cards[i]);
                map.put(cards[i],i);
                min=Math.min(temp,min);
            }
            else{
                map.put(cards[i],i);
            }
        }
        if(min==1000000){
            return -1;
        }
        return min+1;
    }
}
