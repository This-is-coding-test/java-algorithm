package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두명의_도둑_sol2 {

    static int N, M, C;
    static int[][] map;

    // 전처리를 진행할 배열
    static int[][] bestValue;
    static int result = Integer.MIN_VALUE;
    static int[] a;
    static int maxValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        bestValue = new int[N][N];
        a = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int sx = 0; sx < N; sx++) {
            for (int sy = 0; sy < N; sy++) {
                if (sy + M - 1 < N) {
                    bestValue[sx][sy] = findMax(sx, sy);
                }
            }
        }

        // 도둑 선택
        for (int sx1 = 0; sx1 < N; sx1++) {
            for (int sy1 = 0; sy1 < N; sy1++) {
                for (int sx2 = 0; sx2 < N; sx2++) {
                    for (int sy2 = 0; sy2 < N; sy2++) {
                        if (isPossible(sx1, sy1, sx2, sy2)) {
                            // 선택된 도둑마다 가장 많은 무게 합
                            result = Math.max(result, bestValue[sx1][sy1] + bestValue[sx2][sy2]);
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }

    private static int findMax(int sx1, int sy1) {

        for (int i = sy1; i < sy1 + M; i++) {
            a[i - sy1] = map[sx1][i];
        }

        maxValue = 0;
        findMaxValue(0, 0, 0);
        return maxValue;

    }

    private static void findMaxValue(int depth, int weight, int value) {

        if (depth == M) {
            if (weight <= C) {
                maxValue = Math.max(maxValue, value);
            }
        } else {
            // 현재 물건 선택 X
            findMaxValue(depth + 1, weight, value);

            // 현재 물건 선택 O
            findMaxValue(depth + 1, weight + a[depth], value + a[depth] * a[depth]);

        }

    }

    private static boolean isPossible(int sx1, int sy1, int sx2, int sy2) {

        // 격자를 벗어난 경우
        if (sy1 + M - 1 >= N || sy2 + M - 1 >= N) {
            return false;
        }

        // 행이 다른 경우 상관 x
        if (sx1 != sx2) return true;

        // 행이 같은 경우 -> 겹치는지 확인
        if (intersect(sy1, sy1 + M - 1, sy2, sy2 + M - 1)) {
            return false;
        }

        return true;


    }

    private static boolean intersect(int a, int b, int c, int d) {
        //  !(겹치지 않는 경우)
        return !(b < c || d < a);
    }
}
