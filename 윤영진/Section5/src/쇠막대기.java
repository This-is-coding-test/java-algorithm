import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);
            if (c == '(') {
                stack.push(c);
            }else {
                stack.pop();
                if (st.charAt(i - 1) == '(') {
                    answer += stack.size();
                }else {
                    answer +=  1;
                }
            }
        }

        System.out.println(answer);

    }
}
