import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean check = true;

            for (int j = 0; j < str.length(); j++) {

                char c = str.charAt(j);
                if (c == '(') stack.push('(');
                else {
                    if (stack.isEmpty()) {
                        check = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty() || !check) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");

        }


    }
}
