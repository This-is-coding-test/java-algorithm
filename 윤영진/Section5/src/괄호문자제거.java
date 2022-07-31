import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호문자제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (Character c : st.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(') {}
            }else {
                if (Character.isAlphabetic(c)) {
                    if (stack.isEmpty()) {
                        System.out.print(c);
                    }else {
                        stack.push(c);
                    }
                }else {
                    stack.push(c);
                }
            }


        }

    }
}
