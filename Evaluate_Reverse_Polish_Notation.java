import java.util.Stack;
public class Evaluate_Reverse_Polish_Notation {
    public static int evalRPN(String [] tokens){
        Stack<Integer> s =new Stack<>();
        for(int i=0;i<tokens.length;i++){
            switch (tokens[i]) {
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
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.pop();

    }
    public static void main(String[] args) {
        String [] ans ={"2","3","*"};
        System.out.println(evalRPN(ans));
    }
    
}
