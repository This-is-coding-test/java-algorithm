import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 크게_만들기 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 48;

            if (cnt == K) {
                stack.push(curr);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() < curr) {
                stack.pop();
                cnt++;
                if (cnt == K) break;
            }
            if (stack.size() < N - K) stack.push(curr);
        }

        StringBuilder result = new StringBuilder();
        for (Integer num : stack) {
            result.append(num);
        }

        System.out.println(result);


    }
}
