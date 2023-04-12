import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Puyo_Puyo {
    // 여러 가지 색깔의 뿌요
    // R - 빨강, G - 초록, B - 파랑, P - 보라, Y - 노랑
    // 뿌요는 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다.
    // 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다.
    // 뿌요가 없어지고 다시 중력의 영향 -> 이때 또 같은 색 존재하면 터진다.
    // 연쇄가 몇 번 일어날지 계산

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map = new char[12][6];
    static int cnt = 0;
    static ArrayList<Point> points = new ArrayList<>();
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int time = 0;
        while (true) {
            boolean flag = simulate();
            if (!flag) break;
            time++;
        }
        System.out.println(time);

    }

    private static boolean simulate() {
        if (bomb()) {
            down();
            return true;
        }
        return false;
    }

    private static void down() {
        char[][] temp = new char[12][6];

        for (int j = 0; j < 6; j++) {
            int nextRow = 11;
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] != '.') {
                    temp[nextRow--][j] = map[i][j];
                }
            }
        }

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (temp[i][j] == '\0') {
                    map[i][j] = '.';
                } else {
                    map[i][j] = temp[i][j];
                }
            }
        }
    }

    private static boolean bomb() {
        visited = new boolean[12][6];
        boolean flag = false;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] != '.' && !visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    if (cnt >= 4) {
                        flag = true;
                        for (Point p : points) {
                            map[p.x][p.y] = '.';
                        }
                    }
                }
            }
        }
        return flag;
    }

    private static void bfs(int x, int y, char type) {
        visited[x][y] = true;
        points = new ArrayList<>();
        points.add(new Point(x, y));
        cnt = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {

            Point p = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (!inRange(nx, ny)) continue;
                if (!visited[nx][ny] && map[nx][ny] == type) {
                    visited[nx][ny] = true;
                    cnt++;
                    points.add(new Point(nx, ny));
                    queue.offer(new Point(nx, ny));
                }
            }
        }

    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < 12 && ny < 6;
    }
}
