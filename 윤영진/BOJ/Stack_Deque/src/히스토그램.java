import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class 히스토그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] histogram = new int[N];
        for (int i = 0; i < N; i++) {
            histogram[i] = Integer.parseInt(br.readLine());
        }
        long answer = 0;

        for (int i = 0; i < N; i++) {
            int height = histogram[i];
            while (!stack.isEmpty() && histogram[stack.peek()] >= height) {
                int h = histogram[stack.pop()]; // 5 -> 4
                long width = stack.isEmpty() ? i : i - 1 - stack.peek(); // 4 - 1 - 2 = 1 / 4 - 1 - 1 = 2

                answer = Math.max(answer, h * width);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int height = histogram[stack.pop()];

            long width = stack.isEmpty() ? N: N - 1 - stack.peek();
            answer = Math.max(answer, width * height);
        }

        System.out.println(answer);
    }
}
