package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 우리는_하나 {
    // n * n 크기의 격자로 이루어져 있는 나라의 정보
    // 각 칸마다 하나의 도시가 있고, 각 도시마다 높이 정보가 주어진다.
    // 이때 k개의 도시를 겹치지 않게 적절하게 골라, 골라진 k개의 도시로부터 갈 수 있는 서로 다른 도시의 수를 최대화
    // 이때 이동은 인접한 도시간의 이동만 가능하며, 그 중에서도 두 도시간의 높이의 차가 u 이상 d 이하

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, k, u, d;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] visitedMap;
    static List<Point> selectedPos = new ArrayList<>();
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {1, 0, 0, -1}; // 하 우 좌 상
    static int[] dy = {0, 1, -1, 0};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        select(0);
        System.out.println(result);
    }

    private static void select(int depth) {
        if (depth == k) {
            init();
            bfs();
            result = Math.max(result, count());

        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        selectedPos.add(new Point(i, j));
                        select(depth + 1);
                        selectedPos.remove(selectedPos.size() - 1);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    private static int count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedMap[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void init() {
        visitedMap = new boolean[n][n];

        for (Point p : selectedPos) {
            visitedMap[p.x][p.y] = true;
            queue.offer(p);
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (canGo(nx, ny, map[p.x][p.y])) {
                        visitedMap[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }

                }
            }
        }


    }

    private static boolean canGo(int nx, int ny, int tall) {
        return (isRange(nx, ny) && !visitedMap[nx][ny] && movable(nx, ny, tall));
    }

    private static boolean movable(int nx, int ny, int tall) {
        int t = map[nx][ny];
        return u <= Math.abs(t - tall) && d >= Math.abs(t - tall);
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
