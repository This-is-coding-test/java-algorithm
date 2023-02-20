import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 도시_분할_계획 {
    static class Edge {
        int v;
        int c;

        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    static int N, M;
    static PriorityQueue<Edge> pQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.c, o2.c));
    static List<ArrayList<Edge>> edges = new ArrayList<>();
    static boolean[] visited;
    static int maxCost = Integer.MIN_VALUE;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.get(a).add(new Edge(b, c));
            edges.get(b).add(new Edge(a, c));
        }

        findMinPath();

        System.out.println(result - maxCost);
    }

    private static void findMinPath() {
        pQ.offer(new Edge(1, 0));

        while (!pQ.isEmpty()) {

            Edge e = pQ.poll();

            if (visited[e.v]) continue;
            visited[e.v] = true;
            maxCost = Math.max(maxCost, e.c);
            result += e.c;

            for (Edge edge : edges.get(e.v)) {
                if (visited[edge.v]) continue;
                pQ.offer(edge);
            }
        }

    }
}
