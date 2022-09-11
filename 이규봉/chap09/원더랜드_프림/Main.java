package 원더랜드_프림;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    public int vex;
    public int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            graph.get(a).add(new Edge(b, c));
            graph.get(a).add(new Edge(a, c));
        }

        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));

        while (!pQ.isEmpty()) {
            Edge edge = pQ.poll(); // 최소 비용인 것 poll
            int ev = edge.vex; // 도착 정점
            if (ch[ev] == 0) {
                ch[ev] = 1;
                answer += edge.cost;
                for (Edge e : graph.get(ev)) {
                    if (ch[e.vex] == 0) pQ.offer(new Edge(e.vex, e.cost));
                }
            }
        }

        System.out.println(answer);
    }

}
