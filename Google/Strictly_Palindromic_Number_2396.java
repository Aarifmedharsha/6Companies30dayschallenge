class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for(int i=2;i<=n-2;i++)
        {
            if(!task(n,i))
                return false;
        }
        return true;
    }
    public boolean task(int n, int i)
    {
        StringBuilder nm=new StringBuilder();
        while(n!=0)
        {
            nm.append(n%i);
            n/=i;
        }
        return nm.toString().equals(nm.reverse().toString()); 
    }
}