import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 산책 {

    static class Edge {
        int v;
        int c;

        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    static int N, M;
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static int S, E;
    static boolean[] visited;
    static int[] path;
    static Queue<Edge> queue = new LinkedList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];
        path = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());

            graph.get(e1).add(e2);
            graph.get(e2).add(e1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        bfs(S, E);

        Arrays.fill(visited, false);

        int p = path[E]; // 2
        while (p != S) {
            visited[p] = true;
            p = path[p];
        }

        bfs(E, S);
        System.out.println(result);

    }

    private static void bfs(int s, int e) {
        queue.offer(new Edge(s, 0));
        visited[s] = true;

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            for (Integer vex : graph.get(edge.v)) {
                if (!visited[vex]) {
                    visited[vex] = true;
                    path[vex] = edge.v;
                    queue.offer(new Edge(vex, edge.c + 1));

                    if (vex == e) {
                        result += edge.c + 1;
                        return;
                    }
                }
            }
        }

    }
}
