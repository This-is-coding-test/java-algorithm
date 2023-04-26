import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 택배_배송 {
    // 가는 길에 만나는 모든 소들에게 여물
    // 최소한의 소들을 만나면서 지나가고 싶다.

    // N개의 헛간, 소들의 길이 M개의 양방향 길
    // 각각의 길은 C마리의 소

    static class Edge {
        int vex, cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }

    static int N, M;
    static ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Edge(b, cost));
            adjList.get(b).add(new Edge(a, cost));
        }

        dijkstra();
        System.out.println(dist[N]);
    }

    private static void dijkstra() {
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(1, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (dist[edge.vex] < edge.cost) continue;

            for (Edge e : adjList.get(edge.vex)) {
                if (dist[e.vex] > e.cost + edge.cost) {
                    dist[e.vex] = e.cost + edge.cost;
                    queue.offer(new Edge(e.vex, dist[e.vex]));
                }
            }
        }

    }
}
