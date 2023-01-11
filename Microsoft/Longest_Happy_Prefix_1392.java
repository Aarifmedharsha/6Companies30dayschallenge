class Solution {
    public String longestPrefix(String s) {
        char arr[] =s.toCharArray();
        int len=0;
        int i=1;
        int lps[] =new int[arr.length];
        lps[0]=0;
        while(i<s.length()){
            if(arr[i]==arr[len]){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return s.substring(0,lps[lps.length-1]);
    }
}
