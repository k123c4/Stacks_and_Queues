import java.util.LinkedList;
public class InfixToPostfix {
    public static String InToPost(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                output.append(ch);
            }
            else if (ch == '(') {
                stack.addFirst(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.remove());
                }
                if (!stack.isEmpty()) {
                    stack.remove(); // remove '('
                }
            }
            else { // operator
                while (!stack.isEmpty() &&
                        stack.peek() != '(' &&
                        precedence(stack.peek()) >= precedence(ch)) {
                    output.append(stack.remove());
                }
                stack.addFirst(ch);
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.remove());
        }

        return output.toString();
    }

    public static int precedence(char op) {
        if (op == '^') return 3;
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }

    public static void main(String[] args){
        String a = "a+b*(c^d-e)^(f+g*h)-i";
        String b = "a+b*c";
        String c = "a-b+(c-d)";
        System.out.println(InToPost(a));
        System.out.println(InToPost(b));
        System.out.println(InToPost(c));
    }
}