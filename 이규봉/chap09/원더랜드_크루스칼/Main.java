package 원더랜드_크루스칼;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    public int v1;
    public int v2;
    public int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int[] unf;

    // 참고: 회로가 존재하면 그래프, 존재하지 않으면 트리
    public static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        unf = new int[n + 1];
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) unf[i] = i;
        for (int i = 0; i < m; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int cost = scanner.nextInt();
            edges.add(new Edge(v1, v2, cost));
        }

        Collections.sort(edges);
        int answer = 0;

        for (Edge edge : edges) {
            int fv1 = Find(edge.v1);
            int fv2 = Find(edge.v2);
            if (fv1 != fv2) {
                answer += edge.cost;
                Union(edge.v1, edge.v2);
            }
        }

        System.out.println(answer);
    }

}
