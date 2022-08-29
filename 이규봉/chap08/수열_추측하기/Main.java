package 수열_추측하기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, f;
    static int[] b, p;
    static boolean[] visit;
    boolean flag = false;
    int[][] dy = new int[35][35];

    public int combi(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    public void DFS(int L, int sum) {
        if (flag) return;
        if (L == n) {
            if (sum == f) {
                Arrays.stream(p).forEach(e -> System.out.print(e + " "));
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    p[L] = i;
                    DFS(L + 1, sum + (p[L] * b[L]));
                    visit[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        f = scanner.nextInt();
        b = new int[n];
        p = new int[n];
        visit = new boolean[n + 1];

        Main main = new Main();

        for (int i = 0; i < n; i++) {
            b[i] = main.combi(n - 1, i);
        }

        main.DFS(0, 0);
    }

}
