import java.util.LinkedList;

public class BalancedSymbols {
    public static String isBalanced(String s){
        LinkedList<Character> stack = new LinkedList<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('|| ch == '[' || ch == '{' || ch == '<' || ch == '¿' ){
                stack.addFirst(ch);
            }else{
                if(stack.isEmpty()){
                    return "NO";
                }
                char top = stack.peek();
                if ((ch == ')' && top == '(') ||
                        (ch == ']' && top == '[') ||
                        (ch == '}' && top == '{') ||
                        (ch == '>' && top == '<') ||
                        (ch == '?' && top == '¿')) {
                    stack.remove();
                }else{
                    return "NO";
                }
            }


        }
        return stack.isEmpty() ? "YES" : "NO"; //Ternary Operator
    }
    public static void main() {
        String a = "{[()]}";
        String b = "{[(])}¿";
        String c = "{{[[(()<>)]]}}";
        System.out.println(isBalanced(a));
        System.out.println(isBalanced(b));
        System.out.println(isBalanced(c));
    }
}