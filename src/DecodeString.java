import javax.swing.text.AttributeSet;
import java.util.Stack;
public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();


        StringBuilder current = new StringBuilder();
        int num = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if (Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            else if (ch == '['){
                counts.push(num);
                strings.push(current);

                num = 0;
                current = new StringBuilder();
            } else if (ch == ']') {
                int repeat = counts.pop();
                StringBuilder previous = strings.pop();
                for (int j = 0; j < repeat; j++){
                    previous.append(current);
                }
                current = previous;
            }
            else{
                current.append(ch);
            }
        }
        return current.toString();
    }
    public static void main(){
        String a = "3[a]2[bc]";
        String b = "3[a2[c]]";
        String c = "2[abc]3[cd]ef";
        System.out.println(decodeString(a));
        System.out.println(decodeString(b));
        System.out.println(decodeString(c));
    }
}
