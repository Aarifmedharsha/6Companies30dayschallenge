public class Number_of_Substrings_Containing_All_Three_Characters_1358 {
    public static int numberOfSubstings(String s){
        int freq[] =new int[3];
        int l=0;
        int m=0;
        int res=0;
        for(m=0;m<s.length();m++){
            freq[s.charAt(m)-'a']++;
            while(freq[0]>0&&freq[1]>0&&freq[2]>0){
                freq[s.charAt(l)-'a']--;
                l++;
            }
            res+=l;
        }
        return res;
    }
    public static void main(String[] args) {
        String s ="aaacb";
        System.out.println(numberOfSubstings(s));        
    }
}
