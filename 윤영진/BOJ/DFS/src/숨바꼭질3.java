import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3 {

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    static int N, K;
    static int result = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];

    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        queue.add(new Node(N, 0));
        BFS();

        System.out.println(result);


    }

    private static void BFS() {

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                visited[node.x] = true;
                if (node.x == K) {
                    result = Math.min(result, node.time);
                }
                int next;

                // -1
                next = node.x - 1;
                if (next >= 0 && !visited[next]) {
                    queue.offer(new Node(next, node.time + 1));
                }
                // +1
                next = node.x + 1;
                if (next <= 100000 && !visited[next]) {
                    queue.offer(new Node(next, node.time + 1));
                }
                // *2
                next = node.x * 2;
                if (next <= 100000 && !visited[next]) {
                    queue.offer(new Node(next, node.time));
                }
            }

        }
    }
}
