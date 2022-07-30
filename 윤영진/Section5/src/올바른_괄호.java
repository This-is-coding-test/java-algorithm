import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class 올바른_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();

        Stack<Character> stack = new Stack<>();
        boolean check = true;

        for (int i = 0; i < st.length(); i++) {

            char c = st.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    check = false;
                    break;
                }else {
                    stack.pop();

                }
            }
        }
        if (!stack.isEmpty()) check = false;

        System.out.println(check ? "YES" : "NO");


    }
}
