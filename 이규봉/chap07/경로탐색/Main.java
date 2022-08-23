package 경로탐색;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visit;

    public void DFS(int v) {
        if (v == n) answer++;
        else {
            for (int nv : graph.get(v)) {
                if (!visit[nv]) {
                    visit[nv] = true;
                    DFS(nv);
                    visit[nv] = false;
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

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }

        Main main = new Main();
        visit[1] = true;
        main.DFS(1);
        System.out.println(answer);
    }

}
