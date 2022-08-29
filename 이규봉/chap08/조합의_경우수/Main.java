package 조합의_경우수;

import java.util.Scanner;

public class Main {
    // 메모이제이션을 위한 배열
    int[][] dy = new int[35][35];

    public int DFS(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        // 값 저장 후 반환
        else return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        Main main = new Main();
        int answer = main.DFS(n, r);
        System.out.println(answer);
    }

}
