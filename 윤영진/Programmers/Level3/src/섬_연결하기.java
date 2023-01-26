import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 섬_연결하기 {
    static class Edge {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }

    static int N;
    static int answer = 0;
    static PriorityQueue<Edge> pQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    static List<ArrayList<Edge>> listGraph = new ArrayList<>();
    static boolean[] visited;


    public int solution(int n, int[][] costs) {
        N = n;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            listGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < costs.length; i++) {
            int e1 = costs[i][0];
            int e2 = costs[i][1];
            int c = costs[i][2];
            listGraph.get(e1).add(new Edge(e2, c));
            listGraph.get(e2).add(new Edge(e1, c));
        }
        pQ.offer(new Edge(0, 0));

        prim();

        return answer;
    }

    private void prim() {

        while (!pQ.isEmpty()) {
            Edge e = pQ.poll();

            if (visited[e.vex]) continue;
            visited[e.vex] = true;
            answer += e.cost;

            for (Edge edge : listGraph.get(e.vex)) {
                if (visited[edge.vex]) continue;
                pQ.offer(edge);
            }

        }


    }

}
