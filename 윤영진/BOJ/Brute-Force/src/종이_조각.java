import java.io.*;
import java.util.*;

public class 종이_조각 {
    // 가로 1, 세로 0
    // 0000 0000 0000 0000 ~ 1111 1111 1111 1111

    static int N, M;
    static int[][] paper;
    static boolean[][] mask;

    static int result = Integer.MIN_VALUE;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        mask = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                paper[i][j] = s.charAt(j) - '0';
            }
        }

        dfs(0, 0);
        System.out.println(result);

    }

    private static void dfs(int row, int col) {
        if (row == N) {
            calc();
            return;
        }

        if (col == M) {
            dfs(row + 1, 0);
            return;
        }

        mask[row][col] = true;
        dfs(row, col + 1);

        mask[row][col] = false;
        dfs(row, col + 1);

    }

    private static void calc() {
        sum = 0;
        // 가로 계산
        rowCalc();
        // 세로 계산
        colCalc();
        result = Math.max(result, sum);
    }

    private static void colCalc() {

        // 세로 계산
        for (int i = 0; i < M; i++) {
            int colSum = 0;
            for (int j = 0; j < N; j++) {
                if (!mask[j][i]) {
                    colSum *= 10;
                    colSum += paper[j][i];
                } else {
                    sum += colSum; // 이전 계산 저장
                    colSum = 0;
                }
            }
            sum += colSum;
        }


    }

    private static void rowCalc() {

        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            for (int j = 0; j < M; j++) {
                if (mask[i][j]) {
                    rowSum *= 10;
                    rowSum += paper[i][j];
                } else {
                    sum += rowSum; // 이전 계산 저장
                    rowSum = 0;
                }
            }
            sum += rowSum;
        }

    }
}
