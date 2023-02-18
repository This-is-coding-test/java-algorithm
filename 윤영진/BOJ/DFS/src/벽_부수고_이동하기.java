import java.util.*;
import java.io.*;

public class 벽_부수고_이동하기 {

    static class Point {
        int x;
        int y;
        int c;

        public Point(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    static int N, M;
    static int[][] map;
    static int[][] countMap;
    static boolean[][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    static Queue<Point> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        countMap = new int[N][M];
        visited = new boolean[2][N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        visited[0][0][0] = true;
        countMap[0][0] = 1;
        queue.offer(new Point(0, 0, 0));

        bfs();
        if (visited[0][N - 1][M - 1] || visited[1][N - 1][M - 1]) {
            System.out.println(countMap[N - 1][M - 1]);
        } else {
            System.out.println(-1);
        }

    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (!inRange(nx, ny)) continue;
                if (visited[p.c][nx][ny]) continue;

                if (map[nx][ny] == 0) {
                    visited[p.c][nx][ny] = true;
                    countMap[nx][ny] = countMap[p.x][p.y] + 1;
                    queue.offer(new Point(nx, ny, p.c));
                } else if (map[nx][ny] == 1 && p.c == 0) {
                    visited[1][nx][ny] = true;
                    countMap[nx][ny] = countMap[p.x][p.y] + 1;
                    queue.offer(new Point(nx, ny, 1));
                }
            }
            if (visited[0][N - 1][M - 1] || visited[1][N - 1][M - 1]) return;
        }
    }

    public static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }


}