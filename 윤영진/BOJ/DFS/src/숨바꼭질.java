
import java.io.*;
import java.util.*;

public class 숨바꼭질 {
    static int N, K;
    static int[] dist;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();

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

        dist = new int[100001];
        visited = new boolean[100001];
        visited[N] = true;
        q.offer(N);

        bfs();

        System.out.println(dist[K]);


    }

    private static void bfs() {

        while (!q.isEmpty()) {

            Integer now = q.poll();
            int next;

            next = now + 1;
            if(next <= 100000 && !visited[next]) {
                visited[next] = true;
                dist[next] = dist[now] + 1;
                q.offer(next);
            }

            next = now - 1;
            if(next >= 0 && !visited[next]) {
                visited[next] = true;
                dist[next] = dist[now] + 1;
                q.offer(next);
            }

            next = now * 2;
            if(next <= 100000 && !visited[next]) {
                visited[next] = true;
                dist[next] = dist[now] + 1;
                q.offer(next);
            }

            if(visited[K]) {
                return;
            }
        }

    }
}
