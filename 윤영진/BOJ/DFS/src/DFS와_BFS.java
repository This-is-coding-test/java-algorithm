import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Comparator.*;

public class DFS와_BFS {

    static int N, M, V;
    static List<ArrayList<Integer>> graphList = new ArrayList<>();
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graphList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graphList.get(start).add(end);
            graphList.get(end).add(start);
        }

        for (int i = 1; i <= N; i++) {
            graphList.get(i).sort(comparingInt(o -> o));
        }

        visited = new boolean[N + 1];
        visited[V] = true;

        System.out.print(V + " ");
        DFS(V);
        System.out.println();

        visited = new boolean[N + 1];
        visited[V] = true;
        queue.offer(V);

        BFS();


    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            System.out.print(now + " ");

            for (Integer x : graphList.get(now)) {
                if (!visited[x]) {
                    visited[x] = true;
                    queue.offer(x);
                }
            }
        }
    }

    private static void DFS(int v) {
        for (Integer now : graphList.get(v)) {
            if (!visited[now]) {
                visited[now] = true;
                System.out.print(now + " ");
                DFS(now);
            }
        }

    }
}
