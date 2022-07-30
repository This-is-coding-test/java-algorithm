import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호문자제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            }else {
                if (stack.isEmpty()) System.out.print(c);
            }

        }


    }
}
