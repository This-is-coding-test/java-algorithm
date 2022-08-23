package 그래프_최단거리;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visit;
    static int[] dis;

    public void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        visit[v] = true;
        dis[v] = 0;
        Q.offer(v);

        while (!Q.isEmpty()) {
            int cv = Q.poll();
            for (int nv : graph.get(cv)) {
                if (!visit[nv]) {
                    visit[nv] = true;
                    Q.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new ArrayList<>();
        visit = new boolean[n + 1];
        dis = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }

        Main main = new Main();
        main.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }

}
