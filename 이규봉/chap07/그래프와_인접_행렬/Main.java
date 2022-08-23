package 그래프와_인접_행렬;

import java.util.Scanner;

public class Main {
    static int n, m, answer = 0;
    static int[][] graph;
    static boolean[] visit;

    public void DFS(int v) {
        if (v == n) answer++;
        else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    DFS(i);
                    visit[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
        }

        Main main = new Main();
        visit[1] = true;
        main.DFS(1);
        System.out.println(answer);
    }

}
