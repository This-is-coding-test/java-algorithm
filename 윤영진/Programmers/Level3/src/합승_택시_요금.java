import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 합승_택시_요금 {

    static class Edge {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }


    }

    static ArrayList<ArrayList<Edge>> listGraph = new ArrayList<>();
    static int[] together;
    static int N;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        together = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            listGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < fares.length; i++) {
            int e1 = fares[i][0];
            int e2 = fares[i][1];
            int v = fares[i][2];
            listGraph.get(e1).add(new Edge(e2, v));
            listGraph.get(e2).add(new Edge(e1, v));
        }

        together = dijkstra(s);

        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int[] alone = dijkstra(i);
            int cost = together[i] + alone[a] + alone[b];
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    private static int[] dijkstra(int start) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
//        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pQ.add(new Edge(start, 0));


        while (!pQ.isEmpty()) {
            Edge e = pQ.poll();
            int vex = e.vex; // 1
            int cost = e.cost; // 0
//            if (visited[vex]) continue;
//            visited[vex] = true;

            if (cost > distance[vex]) continue;

            for (Edge edge : listGraph.get(e.vex)) {
                // (2, 12) (3, 4)
                if (distance[edge.vex] > cost + edge.cost) {
                    distance[edge.vex] = cost + edge.cost;
                    pQ.offer(new Edge(edge.vex, edge.cost + cost));
                }
            }
        }
        return distance;
    }

}
