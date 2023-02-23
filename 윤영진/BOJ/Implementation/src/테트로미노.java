import java.util.*;
import java.io.*;

public class 테트로미노 {
    // 정사각형은 서로 겹치면 안 된다.
    // 도형은 모두 연결되어 있어야 한다.
    // 정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안된다.

    // 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램

    static int[][][] tetriminos = new int[][][]{
            {{1, 1, 1, 1},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}},
            {{1, 0, 0, 0},
                    {1, 0, 0, 0},
                    {1, 0, 0, 0},
                    {1, 0, 0, 0}},
            {{1, 1, 0, 0},
                    {1, 1, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}},
            {{1, 0, 0, 0},
                    {1, 0, 0, 0},
                    {1, 1, 0, 0},
                    {0, 0, 0, 0}},
            {{1, 1, 1, 0},
                    {1, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}},
            {{1, 1, 0, 0},
                    {0, 1, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 0, 0}},
            {{0, 0, 1, 0},
                    {1, 1, 1, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}},
            {{1, 0, 0, 0},
                    {1, 1, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 0, 0}},
            {{0, 1, 1, 0},
                    {1, 1, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}},
            {{1, 1, 1, 0},
                    {0, 1, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}},
            {{0, 1, 0, 0},
                    {1, 1, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 0, 0}},
            {{0, 1, 0, 0},
                    {1, 1, 1, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}},
            {{1, 0, 0, 0},
                    {1, 1, 0, 0},
                    {1, 0, 0, 0},
                    {0, 0, 0, 0}},


            {{0, 1, 0, 0},
                    {0, 1, 0, 0},
                    {1, 1, 0, 0},
                    {0, 0, 0, 0}},
            {{1, 0, 0, 0},
                    {1, 1, 1, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}},
            {{1, 1, 0, 0},
                    {1, 0, 0, 0},
                    {1, 0, 0, 0},
                    {0, 0, 0, 0}},
            {{1, 1, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}},
            {{0, 1, 0, 0},
                    {1, 1, 0, 0},
                    {1, 0, 0, 0},
                    {0, 0, 0, 0}},
            {{1, 1, 0, 0},
                    {0, 1, 1, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}},
    };

    static int N, M;
    static int[][] map;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result = Math.max(result, calc(i, j));
            }
        }
        System.out.println(result);

    }

    private static int calc(int x, int y) {
        int maxSum = 0;

        for (int k = 0; k < 19; k++) {

            boolean isPossible = true;
            int sum = 0;

            for (int dx = 0; dx < 4; dx++) {
                for (int dy = 0; dy < 4; dy++) {
                    if (tetriminos[k][dx][dy] == 0) continue;
                    if (dx + x >= N || dy + y >= M) {
                        isPossible = false;
                    } else {
                        sum += map[x + dx][y + dy];
                    }
                }
            }
            if (isPossible) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }




}
