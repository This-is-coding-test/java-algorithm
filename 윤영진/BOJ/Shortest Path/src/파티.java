import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티 {
    // N명의 학생이 X번 마을에 모여서 파티
    // 총 M개의 단방향 도로
    static class Edge {
        int vex, cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }

    static int N, M, X;
    static ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
    static ArrayList<ArrayList<Edge>> reverseAdjList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
            reverseAdjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            adjList.get(A).add(new Edge(B, T));
            reverseAdjList.get(B).add(new Edge(A, T));
        }
        int[] dist1 = dijkstra(adjList);
        int[] dist2 = dijkstra(reverseAdjList);

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            int dist = 0;
            dist += dist1[i];
            dist += dist2[i];

            result = Math.max(result, dist);
        }
        System.out.println(result);

    }

    private static int[] dijkstra(ArrayList<ArrayList<Edge>> adjList) {

        PriorityQueue<Edge> pQ = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pQ.offer(new Edge(X, 0));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        while (!pQ.isEmpty()) {
            Edge e = pQ.poll();

            if (e.cost > dist[e.vex]) continue;
            for (Edge edge : adjList.get(e.vex)) {
                if (dist[edge.vex] > e.cost + edge.cost) {
                    dist[edge.vex] = e.cost + edge.cost;
                    pQ.offer(new Edge(edge.vex, dist[edge.vex]));
                }
            }
        }

        return dist;


    }
}
