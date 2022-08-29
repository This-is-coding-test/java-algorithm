package 최대점수_구하기;

import java.util.Scanner;

public class Main {
    static int n, m, answer = Integer.MIN_VALUE;

    public void DFS(int L, int T, int sum, int[] score, int[] time) {
        if (T > m) return;
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, T + time[L], sum + score[L], score, time);
            DFS(L + 1, T, sum, score, time);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] time = new int[n];
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = scanner.nextInt();
            time[i] = scanner.nextInt();
        }

        Main main = new Main();
        main.DFS(0, 0, 0, score, time);
        System.out.println(answer);
    }

}
