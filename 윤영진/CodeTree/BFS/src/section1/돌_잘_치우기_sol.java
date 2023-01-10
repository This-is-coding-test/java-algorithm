package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 돌_잘_치우기_sol {

    // 0, 1로만 이루어진 map
    // 주어진 돌 중 m개의 돌만 적절하게 치워 k개의 시작점으로부터 상하좌우 인접한 곳으로만 이동하여 도달 가능한 칸의 수를 최대로
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, k, m;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int result = Integer.MIN_VALUE;
    static List<Point> initPoints = new ArrayList<>();

    static List<Point> stonePos = new ArrayList<>();
    static List<Point> selectedStones = new ArrayList<>();

    static int[] dx = {1, 0, 0, -1}; // 하 우 좌 상
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) stonePos.add(new Point(i, j));
            }
        }
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            initPoints.add(new Point(r, c));
        }

        cleanUp(0, 0);
        System.out.println(result);
    }

    private static void cleanUp(int depth, int start) {
        if (depth == m) {
            init();

            result = Math.max(result, count());
        } else {

            for (int i = start; i < stonePos.size(); i++) {
                selectedStones.add(stonePos.get(i));
                cleanUp(depth + 1, i + 1);
                selectedStones.remove(selectedStones.size() - 1);
            }

        }
    }

    private static void init() {
        visited = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            int x = selectedStones.get(i).x;
            int y = selectedStones.get(i).y;
            map[x][y] = 0;
        }

        initQueue();
        bfs();

        for (int i = 0; i < m; i++) {
            int x = selectedStones.get(i).x;
            int y = selectedStones.get(i).y;
            map[x][y] = 1;
        }

    }

    private static int count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) cnt++;
            }
        }
        return cnt;

    }

    private static void initQueue() {
        for (Point p : initPoints) {
            visited[p.x][p.y] = true;
            queue.offer(p);
        }
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if (canGo(nx, ny)) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }

            }

        }


    }

    private static boolean canGo(int nx, int ny) {
        return (isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0);
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
