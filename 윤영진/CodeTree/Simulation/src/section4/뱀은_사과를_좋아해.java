package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
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
        public boolean equals(Object o) {
            Point p = (Point) o;
            return (p.x == this.x && p.y == this.y);
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(x + y).hashCode();
        }
    }

    static int N, M, K;
    static int[][] map;
    static LinkedList<Point> snake = new LinkedList<>();
    public static HashSet<Point> snakePos = new HashSet<>();

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
        snakePos.add(new Point(1, 1));

        int[] dirMapper = new int[128];
        dirMapper['U'] = 0;
        dirMapper['D'] = 1;
        dirMapper['L'] = 2;
        dirMapper['R'] = 3;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            char d = st.nextToken().charAt(0);
            int p = Integer.parseInt(st.nextToken());

            if (!simulate(dirMapper[d], p)) {
                break;
            }
        }

        System.out.println(time);

    }

    private static boolean simulate(int dir, int p) {

        for (int i = 0; i < p; i++) {
            time++;

            Point head = snake.getFirst();
            int nx = head.x + dx[dir];
            int ny = head.y + dy[dir];

            // 갈 수 있는지 확인
            if (nx <= 0 || ny <= 0 || nx > N || ny > N) {
                return false;
            }
            // 뱀을 한 칸 움직임
            // 몸이 꼬였는지 확인
            if(moveSnake(nx, ny) == false)
                return false;

        }
        return true;
    }

    private static boolean moveSnake(int nx, int ny) {
        // 사과 존재?
        if (map[nx][ny] == 1) {
            map[nx][ny] = 0;
            if (!pushFront(nx, ny)) {
                return false;
            }
        } else { // 사과 존재x?
            Point tail = snake.removeLast();
            snakePos.remove(tail);

            if (!pushFront(nx, ny)) {
                return false;
            }
        }
        return true;
    }

    private static boolean pushFront(int nx, int ny) {

        if (checkCrush(nx, ny)) {
            return false;
        }

        snake.addFirst(new Point(nx, ny));
        snakePos.add(new Point(nx, ny));

        return true;
    }

    private static boolean checkCrush(int nx, int ny) {
        return snakePos.contains(new Point(nx, ny));
    }

}
