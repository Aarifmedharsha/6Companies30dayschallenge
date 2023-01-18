class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans=new ArrayList();
         String name[]=new String[transactions.length];
        int time[]=new int[transactions.length];
        int money[]=new int[transactions.length];
        String city[]=new String[transactions.length];
        for(int i=0;i<transactions.length;i++){
            String str[]=transactions[i].split(",");
            name[i]=str[0];
            time[i]=Integer.parseInt(str[1]);
            money[i]=Integer.parseInt(str[2]);
            city[i]=str[3];
            if(money[i]>1000){
                ans.add(transactions[i]);
                continue;
            }
            for(int j=0;j<transactions.length;j++){
                String[] str2 = transactions[j].split(",");
                if(name[i].equals(str2[0]) && !city[i].equals(str2[3]) && Math.abs(time[i] - Integer.parseInt(str2[1])) <= 60) {
                    ans.add(transactions[i]);
                    break;
                }
            }
        }
    return ans;
    }
}
