import java.util.Stack;
public class reversepolish {
    public static int op(String [] ans){
        Stack<Integer> s =new Stack<>();
        for(int i=0;i<ans.length;i++){
            switch (ans[i]) {
                case "+":
                s.push(s.pop() + s.pop());
                break;
                case "-":
                int n1=s.pop();
                int n2 = s.pop();
                s.push(n2-n1);
                break;   
                case "*":
                s.push(s.pop() * s.pop());
                break;
                case "/":
                int n3 = s.pop();
                int n4 = s.pop();
                s.push(n4/n3);
                break;        
                default:
                s.push(Integer.parseInt(ans[i]));
            }
        }
        return s.pop();

    }
    public static void main(String[] args) {
        String [] ans ={"2","3","*"};
        System.out.println(op(ans));

    }
    
}
