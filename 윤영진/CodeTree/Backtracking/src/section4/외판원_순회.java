package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 외판원_순회 {
    // 1번 지점에서 출발하여 모든 지점을 정확히 딱 한 번씩만 방문하고 다시 1번 지점으로 돌아오려고 한다.
    // i번 지점에서 j번 지점으로 이동하는데 드는 비용 정보가 Aij가 주어졌을 때
    // 모든 정점을 겹치지 않게 방문하고 되돌아오는데 필요한 최소 비용의 합
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

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

        visited[0] = true;
        permutation(0, 0, 0);
        System.out.println(result);
    }

    private static void permutation(int depth, int prev, int val) {
        if (depth == n - 1) {
            if (map[prev][0] == 0)
                return;
            result = Math.min(result, val + map[prev][0]);
        } else {
            for (int i = 0; i < n; i++) {
                if (visited[i] || map[prev][i] == 0) continue;
                visited[i] = true;
                permutation(depth + 1, i, val + map[prev][i]);
                visited[i] = false;
            }
        }
    }

}

