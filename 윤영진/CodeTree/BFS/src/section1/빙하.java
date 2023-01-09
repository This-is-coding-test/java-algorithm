package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙하 {

    // 격자의 가장 바깥 부분은 항상 빙하가 아니고, 빙하를 제외한 나머지 위치에는 전부 물이 채워져 있습니다.
    // 숫자 1은 빙하, 숫자 0은 물

    // 빙하는 1초에 한 번씩 물에 닿아있는 부분들이 동시 녹는다.
    // 하지만 빙하로 둘러쌓여있는 물의 경우에는 붙어있는 빙하를 녹이지 못한다.

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static int[][] moltenMap;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {1, 0, 0, -1}; // 하 우 좌 상
    static int[] dy = {0, 1, -1, 0};
    static int meltCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        while (check()) {
            moltenMap = new int[N][M];
            visited = new boolean[N][M];
            queue.offer(new Point(0, 0));
            bfs();
            spread();
            time++;
        }

        System.out.println(time + " " + meltCount);

    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) return true;
            }
        }
        return false;
    }

    private static void spread() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (moltenMap[i][j] == -1) {
                    cnt++;
                    map[i][j] = 0;
                }
            }
        }
        meltCount = cnt;
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if (isRange(nx, ny) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if (map[nx][ny] == 0) {
                            queue.offer(new Point(nx, ny));
                        } else {
                            moltenMap[nx][ny] = -1;
                        }
                    }

                }
            }

        }

    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }
}
