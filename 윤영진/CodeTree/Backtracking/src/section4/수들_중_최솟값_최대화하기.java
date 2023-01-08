package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수들_중_최솟값_최대화하기 {
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
        int min = Integer.MAX_VALUE;
        int row = 0;
        for (Integer val : output) {
            int curr = map[row++][val];
            if (curr < min) {
                min = curr;
            }
        }
        return min;
    }

}
