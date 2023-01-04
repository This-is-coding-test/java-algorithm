package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 강력한_폭발 {

    // 0, 1로 구성된 n*n 크기의 격자판
    // 1은 폭탄

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int[][] bombed;
    static int[][] bombType;
    static int cnt = 0;
    static Point[][] bombShape = new Point[][]{
            {new Point(-2, 0), new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(2, 0)},
            {new Point(-1, 0), new Point(1, 0), new Point(0, 0), new Point(0, -1), new Point(0, 1)},
            {new Point(-1, -1), new Point(-1, 1), new Point(0, 0), new Point(1, -1), new Point(1, 1)},
    };
    static List<Point> bombPos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        bombed = new int[n][n];
        bombType = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int bomb = Integer.parseInt(st.nextToken());
                if (bomb > 0) {
                    bombPos.add(new Point(i, j));
                }
            }
        }

        findMaxArea(0);

        System.out.println(cnt);

    }

    private static void findMaxArea(int depth) {

        if (depth == bombPos.size()) {
            cnt = Math.max(cnt, calc());
            return;
        } else {
            for (int i = 1; i <= 3; i++) {
                int x = bombPos.get(depth).x;
                int y = bombPos.get(depth).y;

                bombType[x][y] = i;
                findMaxArea(depth + 1);
                bombType[x][y] = 0;
            }

        }
    }

    private static int calc() {

        bombed = new int[n][n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bombType[i][j] > 0) {
                    bomb(i, j, bombType[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bombed[i][j] > 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void bomb(int x, int y, int type) { // 1

        for (int i = 0; i < 5; i++) {
            int nx = x + bombShape[type - 1][i].x;
            int ny = y + bombShape[type - 1][i].y;

            if (isRange(nx, ny)) {
                bombed[nx][ny] = 1;
            }

        }


    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }

}
