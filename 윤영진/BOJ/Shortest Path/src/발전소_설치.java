import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 발전소_설치 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        int v;
        double c;

        public Edge(int v, double c) {
            this.v = v;
            this.c = c;
        }
    }

    static int N, W;
    static double M;
    static Point[] plants;
    static Double[][] dist;
    static double[] minDist;
    static boolean[] visited;
    static PriorityQueue<Edge> pQ = new PriorityQueue<>(Comparator.comparingDouble(o -> o.c));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        plants = new Point[N];
        dist = new Double[N][N];
        visited = new boolean[N];

        M = Double.parseDouble(br.readLine()); // 2.0


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            plants[i] = new Point(x, y);

            for (int j = 0; j < i; j++) {
                double d = dSquare(plants[i], plants[j]);
                if (d <= M * M) {
                    dist[i][j] = Math.sqrt(d);
                    dist[j][i] = Math.sqrt(d);
                }
            }
        }

        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            dist[s][e] = 0.0;
            dist[e][s] = 0.0;
        }

        findMinPath();

        double result = minDist[N - 1];
        System.out.println((int) (result * 1000));

    }

    private static void findMinPath() {

        minDist = new double[N];
        Arrays.fill(minDist, Double.MAX_VALUE);
        pQ.offer(new Edge(0, 0));

        while (!pQ.isEmpty()) {
            Edge e = pQ.poll(); // 0, 0
            if (visited[e.v]) continue;
            visited[e.v] = true;

            for (int i = 0; i < N; i++) {
                if (dist[e.v][i] == null) {
                    continue;
                }

                if (minDist[i] > e.c + dist[e.v][i]) {
                    minDist[i] = e.c + dist[e.v][i];
                    pQ.offer(new Edge(i, minDist[i]));
                }
            }
        }
    }

    private static double dSquare(Point p1, Point p2) {
        return Math.pow(Math.abs(p1.x - p2.x), 2) + Math.pow(Math.abs(p1.y - p2.y), 2);
    }
}
