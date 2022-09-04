import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 다익스트라_알고리즘 {

    static class Edge {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Edge>> listGraph = new ArrayList<>();
    static PriorityQueue<Edge> pQ = new PriorityQueue<>((o1, o2) -> o2.cost - o1.cost);
    static int[] dist;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            listGraph.add(new ArrayList<>());
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            listGraph.get(start).add(new Edge(end, weight));

        }

        pQ.offer(new Edge(1, 0));
        dijkstra();

        for (int i = 2; i <= N; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
            } else {
                System.out.println(i + " : " + dist[i]);
            }
        }


    }

    private static void dijkstra() {
        while (!pQ.isEmpty()) {
            Edge e = pQ.poll();
            int vex = e.vex; // 1
            int cost = e.cost; // 0

            if (cost > dist[vex]) continue;

            for (Edge edge : listGraph.get(e.vex)) {
                // (2, 12) (3, 4)
                if (dist[edge.vex] > cost + edge.cost) {
                    dist[edge.vex] = cost + edge.cost;
                    pQ.offer(new Edge(edge.vex, edge.cost + cost));
                }
            }

        }


    }


}
