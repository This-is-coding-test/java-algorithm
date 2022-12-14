import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 두_동전 {
    // NxM 크기의 보드와 4개의 버튼
    // 두 개의 빈 칸에는 동전이 하나씩 놓여져 있고, 두 동전의 위치는 다르다.
    // 버튼은 왼쪽, 오른쪽, 위, 아래 -> 버튼을 누르면 두 동전이 버튼에 쓰여 있는 방향으로 동시에 이동

    // 동전이 이동하려는 칸이 벽이면, 동전은 이동 X
    // 동전이 이동하려는 방향에 칸이 없으면 동전은 보드 바깥으로 떨어진다.
    // 그 외의 경우에는 이동하려는 방향으로 한 칸 이동한다.

    // 두 동전 중 하나만 보드에서 떨어뜨리기 위해 버튼을 최소 몇 번 눌러야하는지

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static char[][] map;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int time = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        Point[] coin = new Point[2];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'o') {
                    coin[cnt++] = new Point(i, j);
                }
            }
        }

        DFS(coin[0], coin[1], 0);
        if (time != Integer.MAX_VALUE) {
            System.out.println(time);
        } else {
            System.out.println(-1);
        }

    }

    private static void DFS(Point coin1, Point coin2, int depth) {
        if (depth > 10) {
            return;
        }

        if (!check(coin1) && !check(coin2)) {
            return;
        }

        if ((check(coin1) && !check(coin2)) || (!check(coin1) && check(coin2))) {
            time = Math.min(time, depth);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int c1x = coin1.x + dx[i];
            int c1y = coin1.y + dy[i];
            int c2x = coin2.x + dx[i];
            int c2y = coin2.y + dy[i];

            if (check(new Point(c1x, c1y)) && map[c1x][c1y] == '#') {
                c1x = coin1.x;
                c1y = coin1.y;
            }
            if (check(new Point(c2x, c2y)) && map[c2x][c2y] == '#') {
                c2x = coin2.x;
                c2y = coin2.y;
            }

            DFS(new Point(c1x, c1y), new Point(c2x, c2y), depth + 1);
        }
    }

    private static boolean check(Point coin) {

        if (coin.x >= 0 && coin.y >= 0 && coin.x < N && coin.y < M) {
            return true;
        }
        return false;
    }


}
