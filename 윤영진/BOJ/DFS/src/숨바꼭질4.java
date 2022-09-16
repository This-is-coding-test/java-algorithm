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
    static int[] visited = new int[100001];
    static int[] parent = new int[100001];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        queue.add(N);
        visited[N] = 1;
        BFS();

        System.out.println(visited[K] - 1);

        Stack<Integer> stack = new Stack<>();
        int idx = K;
        while (idx != N) {
            stack.push(idx);
            idx = parent[idx];
        }
        stack.push(N);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }



    }

    private static void BFS() {

        while (!queue.isEmpty()) {

            int now = queue.poll();

            if (now + 1 <= 100000 && visited[now + 1] == 0) {
                parent[now + 1] = now;
                visited[now + 1] = visited[now] + 1;
                queue.add(now + 1);

            }
            if (now - 1 >= 0 && visited[now - 1] == 0) {
                parent[now - 1] = now;
                visited[now - 1] = visited[now] + 1;
                queue.add(now - 1);
            }
            if (now * 2 <= 100000 && visited[now * 2] == 0) {
                parent[now * 2] = now;
                visited[now * 2] = visited[now] + 1;
                queue.add(now * 2);
            }

            if (visited[K] != 0) return;


        }


    }
}
