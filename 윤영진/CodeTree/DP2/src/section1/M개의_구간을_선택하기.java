package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M개의_구간을_선택하기 {

    // N개의 숫자가 주여졌을 때, 주어진 숫자들 사이에 정확히 M개의 구간을 선택해 각 구간에 있는 숫자들의 총 합이 최대
    // 선택한 구간끼리 겹쳐서는 안되고, 서로 붙어 있어서도 안된다.

    static int N, M;
    static int[] arr;
    static int[][] map;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        map = new int[N][N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for (int i = 0; i < N; i++) {
            findMaxSum(0, i, 0);
        }
        System.out.println(result);

    }

//    public static void print() {
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }

    public static void findMaxSum(int depth, int start, int total) {
        if (depth == M) {
            result = Math.max(result, total);
            return;
        }

        for (int i = start; i < N; i++) {
            findMaxSum(depth + 1, i + 2, total + map[start][i]);
        }

    }

    private static void init() {

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                for (int k = i; k <= j; k++) {
                    map[i][j] += arr[k];
                }
            }
        }
    }
}
