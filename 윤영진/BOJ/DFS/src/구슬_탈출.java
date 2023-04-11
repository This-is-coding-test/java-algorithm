import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬_탈출 {
    // 구슬 탈출은 직사각형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 빨간 구슬을 구멍을 통해 빼내는 게임이다.
    // N - 세로, M - 가로
    // 빨간 구슬 1개, 파란 구슬 1개
    // 파란 구슬은 구멍에 들어가면 안 된다.
    // 10번 이하로 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램
    static class Point {
        int rx, ry, bx, by;

        public Point(int rx, int ry, int bx, int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }
    }

    static class Marble {
        int x, y, dist;

        public Marble(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static Point sP = new Point(-1, -1, -1, -1);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'R') {
                    sP.rx = i;
                    sP.ry = j;
                }
                if (map[i][j] == 'B') {
                    sP.bx = i;
                    sP.by = j;
                }
            }
        }

        int result = bfs();
        System.out.println(result);

    }

    private static int bfs() {
        visited[sP.rx][sP.ry][sP.bx][sP.by] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(sP);

        Marble rM, bM;
        int L = 0;
        while (!queue.isEmpty()) {
            L++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {

                Point p = queue.poll();
                for (int d = 0; d < 4; d++) {
                    rM = move(p.rx, p.ry, d);
                    bM = move(p.bx, p.by, d);

                    if (map[bM.x][bM.y] == 'O') continue;
                    if (map[rM.x][rM.y] == 'O') return 1;

                    if (rM.x == bM.x && rM.y == bM.y) { // 동일한 위치에 존재하는 경우
                        if (rM.dist > bM.dist) {
                            rM.x -= dx[d];
                            rM.y -= dy[d];
                        } else {
                            bM.x -= dx[d];
                            bM.y -= dy[d];
                        }
                    }
                    if (visited[rM.x][rM.y][bM.x][bM.y]) continue;
                    visited[rM.x][rM.y][bM.x][bM.y] = true;

                    queue.offer(new Point(rM.x, rM.y, bM.x, bM.y));
                }
            }
            if (L > 10) return 0;
        }

        return 0;
    }

    private static Marble move(int x, int y, int d) {

        int nx = x;
        int ny = y;
        int dist = 0;
        while (map[nx + dx[d]][ny + dy[d]] != '#' && map[nx][ny] != 'O') {
            nx += dx[d];
            ny += dy[d];
            dist++;
        }

        return new Marble(nx, ny, dist);
    }

}
