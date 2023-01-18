package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 정수_사각형_최장_증가_수열 {

    // n x n 크기의 격자 정보
    // 시작점을 적절하게 잡아 상하좌우로 인접한 칸으로 계속 칸에 적혀있는 정수값이 커지도록 이동
    // 밝고 지나갈 수 있는 최대 칸의 수

    static class Cell implements Comparable<Cell> {
        int num;
        int x;
        int y;

        public Cell(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Cell o) {
            return this.num - o.num;
        }
    }

    static int n;
    static int[][] map;
    static int[][] dp;
    static List<Cell> cellList = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 각 칸에 적혀있는 수들 중 작은값부터 dp 값을 갱신

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cellList.add(new Cell(map[i][j], i, j));
            }
        }
        Collections.sort(cellList);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        update();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);

    }

    private static void update() {

        for (Cell cell : cellList) {

            int x = cell.x;
            int y = cell.y;
            int num = cell.num;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (inRange(nx,ny) && num < map[nx][ny]) {
                    dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
                }
            }
        }
    }


    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
