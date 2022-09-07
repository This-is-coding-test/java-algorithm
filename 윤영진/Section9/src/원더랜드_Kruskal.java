import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 원더랜드_Kruskal {

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    static int[] unf;
    static int V;
    static int E;
    static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        unf = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            unf[i] = i;
        }
        int answer = 0;

        for (int i = 0; i < E; i++) {

            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(v1, v2, cost));
        }

        Collections.sort(edges);

        int cnt = 0;
        for (Edge edge : edges) {

            if (cnt == V - 1) break;
            int v1 = edge.v1;
            int v2 = edge.v2;

            if (Find(v1) != Find(v2)) {
                cnt++;
                Union(v1, v2);
                answer += edge.cost;
            }

        }

        System.out.println(answer);

    }

    private static void Union(int p1, int p2) {
        int f1 = Find(p1);
        int f2 = Find(p2);

        if (f1 != f2) {
            unf[f1] = f2;
        }
    }

    private static int Find(int p) {

        if (p == unf[p]) return unf[p];
        else return unf[p] = Find(unf[p]);

    }
}
