class Solution {
    public String getHint(String secret, String guess) {
        int freq[] =new int[10];
        int bull=0;
        int cow=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)) bull++;
            freq[secret.charAt(i)-48]++;
        }
        for(int i=0;i<guess.length();i++){
            if(freq[guess.charAt(i)-48]>0){
                cow++;
                freq[guess.charAt(i)-48]--;
            } 
        }
        String t="";
        cow=cow-bull;
        t=bull+"A"+cow+"B";
        return t;
    }
}
