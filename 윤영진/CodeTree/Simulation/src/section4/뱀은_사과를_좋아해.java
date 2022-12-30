package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 뱀은_사과를_좋아해 {
    // N: 격자 크기
    // M: 사과의 개수
    // K: 뱀의 방향 변환 횟수

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

    static int N, M, K;
    static int[][] map;
    static LinkedList<Point> snake = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }

        snake.add(new Point(1, 1));
        int[] dirMapper = new int[128];
        dirMapper['U'] = 0;
        dirMapper['D'] = 1;
        dirMapper['L'] = 2;
        dirMapper['R'] = 3;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            char d = st.nextToken().charAt(0);
            int p = Integer.parseInt(st.nextToken());

            simulate(dirMapper[d], p);
        }

        System.out.println(time);

    }

    private static void simulate(int dir, int p) {

        for (int i = 0; i < p; i++) {
            time++;

            Point head = snake.getFirst();
            int nx = head.x + dx[dir];
            int ny = head.y + dy[dir];

            if (nx <= 0 || ny <= 0 || nx > N || ny > N) {
                System.out.println(time);
                System.exit(0);
            }



            // 사과 존재?
            if (map[nx][ny] == 1) {
                if (checkCrush(nx, ny)) {
                    System.out.println(time);
                    System.exit(0);
                }
                map[nx][ny] = 0;
            } else { // 사과 존재x?
                snake.removeLast();
                if (checkCrush(nx, ny)) {
                    System.out.println(time);
                    System.exit(0);
                }
            }
            snake.addFirst(new Point(nx, ny));

        }
    }

    private static boolean checkCrush(int nx, int ny) {
        for (Point p : snake) {
            if (nx == p.x && ny == p.y) {
                return true;
            }
        }
        return false;
    }

}
