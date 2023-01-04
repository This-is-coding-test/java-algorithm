package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방향에_맞춰_최대로_움직이기 {

    static class Pair {
        int num;
        int dir;

        public Pair(int num) {
            this.num = num;
        }

        public void setDir(int dir) {
            this.dir = dir;
        }
    }

    static int n;
    static Pair[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int r;
    static int c;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new Pair[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = new Pair(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j].setDir(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        backtracking(0, r, c);
        System.out.println(result);

    }

    private static void backtracking(int depth, int x, int y) {
//        System.out.println(x + " " + y);
        result = Math.max(depth, result);

        int dir = map[x][y].dir;
        int nx = x, ny = y; // 3, 3
        for (int i = 0; i < n; i++) {
            if (isRange(nx, ny) && map[nx][ny].num > map[x][y].num) {
                backtracking(depth + 1, nx, ny);
            }
            nx += dx[dir];
            ny += dy[dir];

        }
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 1 && ny >= 1 && nx <= n && ny <= n;
    }
}
