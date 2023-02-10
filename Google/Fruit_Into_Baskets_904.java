class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, maxPicked = 0;
        for (int right = 0; right < fruits.length; ++right) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            while (basket.size() > 2) 
            {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0)
                    basket.remove(fruits[left]);
                left++;
            }            
            maxPicked = Math.max(maxPicked, right - left + 1);
        }        
        return maxPicked;
    }
}