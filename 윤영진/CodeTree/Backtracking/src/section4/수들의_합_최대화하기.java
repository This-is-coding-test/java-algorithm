package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수들의_합_최대화하기 {

    // 크기가 n*n인 2차원 격자 내 각 칸에 정수값
    // 이때 정확히 n개의 칸에 색칠을 하여 각 행과 열에 정확히 1개의 색칠된 칸만 오도록
    // 이러한 조건 하에서 색칠된 칸에 적힌 수들의 합 중 가능한 최댓값
    static int n;
    static int[][] map;
    static List<Integer> output = new ArrayList<>();
    static boolean[] visited;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permutation(0);
        System.out.println(result);

    }

    private static void permutation(int depth) {
        if (depth == n) {
            result = Math.max(result, calc());
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    output.add(i);
                    permutation(depth + 1);

                    output.remove(output.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static int calc() {
        int sum = 0;
        int row = 0;
        for (Integer idx : output) {
            sum += map[row++][idx];
        }

        return sum;
    }
}
