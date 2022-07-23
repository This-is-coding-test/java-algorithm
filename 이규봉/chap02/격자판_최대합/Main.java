package 격자판_최대합;

import java.util.Scanner;

public class Main {

    public int solution(int n, int[][] board) {
        int max = -1;
        int diag1 = 0;
        int diag2 = 0;

        for (int i = 0; i < n; i++) {
            int col = 0;
            int row = 0;

            for (int j = 0; j < n; j++) {
                // 열의 합 계산
                col += board[j][i];
                // 행의 합 계산
                row += board[i][j];
            }

            max = Math.max(max, col);
            max = Math.max(max, row);

            // 우하향 대각선 합 계산
            diag1 += board[i][i];
            // 좌하향 대각선 합 계산
            diag2 += board[i][n - 1 - i];
        }

        max = Math.max(max, diag1);
        max = Math.max(max, diag2);

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        Main main = new Main();
        int result = main.solution(n, board);
        System.out.println(result);
    }

}
