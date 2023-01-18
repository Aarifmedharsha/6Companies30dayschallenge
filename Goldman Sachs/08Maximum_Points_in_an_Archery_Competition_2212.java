class Solution {
    int ans = 0;
    int[] ansbob;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] bob = new int[aliceArrows.length];
        for(int i=0;i<bob.length;i++)bob[i]=0;
        ansbob = new int[bob.length];
        func(aliceArrows,bob,numArrows,11,0);
        return ansbob;
    }
    public void func(int[] alice,int[] bob,int x,int y,int z){
        if(y==-1){
            if(x!=0){
                for(int i=0;i<bob.length;i++){
                    if(bob[i]!=0){
                        bob[i]+=x;
                        break;
                    }
                }
            }
            int temp = Math.max(ans,z);
            if(temp!=ans){
                ans = temp;
                for(int i=0;i<bob.length;i++){
                    ansbob[i]=bob[i];
                }
            }
            return;
        }
        int temp = alice[y];
        if(x>temp){
            bob[y]=temp+1;
            func(alice,bob,x-1-temp,y-1,z+y);
            bob[y]=0;
        }
        func(alice,bob,x,y-1,z);
    }
}
