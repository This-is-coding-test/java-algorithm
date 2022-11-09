import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 숨바꼭질4 {

    static int N;
    static int K;
    static int[] arr = new int[100001];
    static Queue<Integer> queue = new LinkedList<>();
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }

        queue.offer(N);
        BFS();
        System.out.println(time + 1);

        Stack<Integer> stack = new Stack<>();
        int idx = K;
        while (idx != N) {
            stack.push(idx);
            idx = arr[idx];
        }
        stack.push(N);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    private static void BFS() {

        while (!queue.isEmpty()) {

            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int next;
                Integer now = queue.poll();

                // +1
                next = now + 1;
                if (next <= 100000 && arr[next] == 0) {
                    arr[next] = now;
                    queue.offer(next);
                }

                // -1
                next = now - 1;
                if (next >= 0 && arr[next] == 0) {
                    arr[next] = now;
                    queue.offer(next);
                }
                // *2
                next = now * 2;
                if (now != 0 && next <= 100000 && arr[next] == 0) {
                    arr[next] = now;
                    queue.offer(next);
                }

                if (arr[K] != 0) return;
            }
            time++;
        }


    }

}
