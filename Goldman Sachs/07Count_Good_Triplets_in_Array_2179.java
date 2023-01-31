class Solution {
   public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] val1 = new int[n];
        for (int i = 0; i < n; i++) {
        	val1[nums1[i]] = i;
        }
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
        	pos[val1[nums2[i]]] = i;
        }
        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();
        for (int i = 0; i < n; i++) 
            right.add(i);
        long count = 0;
        for (int i = 0; i < n - 1; i++) {
        	int now = pos[i];
        	int rPos = Collections.binarySearch(right, now);
        	right.remove(rPos);
        	int g = right.size() - rPos;
        	int lPos = Collections.binarySearch(left, now);
        	if (lPos < 0) 
        		lPos = -1 - lPos;
        	left.add(lPos, now);
        	int l = lPos;
        	count += (long) g * l;
        }
        return count;
    }
}
