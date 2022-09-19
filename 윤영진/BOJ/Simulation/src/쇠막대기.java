import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bar = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < bar.length(); i++) {
            char c = bar.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (bar.charAt(i - 1) == '(') { // 레이저
                    answer += stack.size();
                } else { // 막대기 끝
                    answer += 1;
                }
            }

        }

        System.out.println(answer);


    }
}
