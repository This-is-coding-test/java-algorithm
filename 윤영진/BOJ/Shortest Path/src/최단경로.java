import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로 {
    static class Edge implements Comparable<Edge> {
        int v;
        int c;

        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }

    static int V, E;
    static int K;
    static int[] dist;
    static boolean[] visited;
    static List<ArrayList<Edge>> listGraph = new ArrayList<>();
    static PriorityQueue<Edge> pQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            listGraph.add(new ArrayList<>());
        }

        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            listGraph.get(u).add(new Edge(v, w));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        pQ.offer(new Edge(K, 0));

        findMinPath();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);

    }

    private static void findMinPath() {

        while (!pQ.isEmpty()) {

            Edge e = pQ.poll();

            if (visited[e.v]) continue;
            visited[e.v] = true;

            for (Edge edge : listGraph.get(e.v)) {
                if (dist[edge.v] > dist[e.v] + edge.c) {
                    dist[edge.v] = dist[e.v] + edge.c;
                    pQ.offer(new Edge(edge.v, dist[edge.v]));
                }
            }


        }

    }
}
