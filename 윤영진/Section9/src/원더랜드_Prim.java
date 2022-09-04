import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 원더랜드_Prim {
    static class Edge {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

    }

    static List<ArrayList<Edge>> listGraph = new ArrayList<>();
    static boolean[] check;
    static PriorityQueue<Edge> pQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        check = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            listGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            listGraph.get(v1).add(new Edge(v2, cost));
            listGraph.get(v2).add(new Edge(v1, cost));

        }
        pQ.offer(new Edge(1, 0));

        Prim();

        System.out.println(answer);
    }

    private static void Prim() {

        while (!pQ.isEmpty()) {
            Edge edge = pQ.poll();

            if (check[edge.vex]) continue;
            check[edge.vex] = true;
            answer += edge.cost;

            for (Edge edge1 : listGraph.get(edge.vex)) {
                if (check[edge1.vex]) continue;
                pQ.offer(edge1);
            }

        }
    }
}
