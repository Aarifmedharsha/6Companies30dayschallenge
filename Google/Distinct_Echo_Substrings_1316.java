class Solution {
    public int distinctEchoSubstrings(String text) {
        HashSet<String> hs=new HashSet<>();
        for(int len=1;len<=(text.length()/2);len++)
        {
            int count=0;
            for(int i=0,j=len;j<text.length();i++,j++)
            {
                if(text.charAt(i)==text.charAt(j))
                {
                    count++;
                }
                else
                {
                    count=0;
                }
                if(count==len)
                {
                    String s=text.substring(i,j+1);
                    hs.add(s);
                    count--;
                }
            }
        }
        return hs.size();
    }
}