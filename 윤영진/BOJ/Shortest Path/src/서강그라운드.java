import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 서강그라운드 {

    static class Edge {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }

    static int n, m, r;
    static int[] values;
    static int[] dist;
    static boolean[] visited;
    static List<ArrayList<Edge>> listGraph = new ArrayList<>();
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        values = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            listGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            listGraph.get(a).add(new Edge(b, l));
            listGraph.get(b).add(new Edge(a, l));
        }

        for (int i = 1; i <= n; i++) {
            dist = new int[n + 1];
            visited = new boolean[n + 1];

            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;

            findMinPath(i);

            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[j] <= m) {
                    sum += values[j];
                }
            }
            result = Math.max(result, sum);
        }
        System.out.println(result);


    }

    private static void findMinPath(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pQ.offer(new Edge(v, 0));

        while (!pQ.isEmpty()) {
            Edge e = pQ.poll();

            if (visited[e.vex]) continue;
            visited[e.vex] = true;

            for (Edge edge : listGraph.get(e.vex)) {
                if (dist[e.vex] + edge.cost > m) continue;
                if (dist[edge.vex] > dist[e.vex] + edge.cost) {

                    dist[edge.vex] = dist[e.vex] + edge.cost;
                    pQ.offer(new Edge(edge.vex, dist[edge.vex]));
                }
            }
        }
    }
}
