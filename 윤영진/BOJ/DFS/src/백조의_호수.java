import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백조의_호수 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R, C;
    static char[][] map;
    static ArrayList<Point> swan = new ArrayList<>();
    static Queue<Point> queue = new LinkedList<>();
    static Queue<Point> nextQ = new LinkedList<>();
    static Queue<Point> waterQ = new LinkedList<>();
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'L') swan.add(new Point(i, j));
                if (map[i][j] != 'X') waterQ.offer(new Point(i, j));
            }
        }

        queue.offer(new Point(swan.get(0).x, swan.get(0).y));
        visited[swan.get(0).x][swan.get(0).y] = true;

        int time = 0;
        while (true) {
            nextQ = new LinkedList<>();
            if (move()) break;
            queue = nextQ;
            bfs();
            time++;
        }

        System.out.println(time);


    }

    private static void bfs() {

        int len = waterQ.size();
        for (int i = 0; i < len; i++) {

            Point p = waterQ.poll();
            for (int d = 0; d < 4; d++) {

                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (!inRange(nx, ny)) continue;
                if (map[nx][ny] == 'X') {
                    map[nx][ny] = '.';
                    waterQ.offer(new Point(nx, ny));
                }
            }
        }
    }

    private static boolean move() {

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();
                if (p.x == swan.get(1).x && p.y == swan.get(1).y) return true;

                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if (!inRange(nx, ny) || visited[nx][ny]) continue;
                    visited[nx][ny] = true;

                    if (map[nx][ny] == 'X') {
                        nextQ.offer(new Point(nx, ny));
                        continue;
                    }
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        return false;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < R && ny < C;
    }
}
