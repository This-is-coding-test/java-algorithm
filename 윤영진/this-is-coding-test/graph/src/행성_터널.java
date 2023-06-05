import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 행성_터널 {
    static class Point {
        int num, x, y, z;

        public Point(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

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

    static int N;
    static List<Edge> edges = new ArrayList<>();
    static int[] unf;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        unf = new int[N];
        for (int i = 0; i < N; i++) {
            unf[i] = i;
        }
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            points[i] = new Point(i, x, y, z);
        }

        Arrays.sort(points, (p1, p2) -> p1.x - p2.x);

        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(points[i].x - points[i + 1].x);
            edges.add(new Edge(points[i].num, points[i + 1].num, cost));
        }

        Arrays.sort(points, (p1, p2) -> p1.y - p2.y);

        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(points[i].y - points[i + 1].y);
            edges.add(new Edge(points[i].num, points[i + 1].num, cost));
        }

        Arrays.sort(points, (p1, p2) -> p1.z - p2.z);

        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(points[i].z - points[i + 1].z);
            edges.add(new Edge(points[i].num, points[i + 1].num, cost));
        }

        Collections.sort(edges);

        kruskal();
        System.out.println(answer);


    }

    private static void kruskal() {
        int cnt = 0;
        for (Edge edge : edges) {

            if (cnt == N - 1) break;
            int v1 = edge.v1;
            int v2 = edge.v2;

            if (Find(v1) != Find(v2)) {
                cnt++;
                Union(v1, v2);
                answer += edge.cost;
            }

        }
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

