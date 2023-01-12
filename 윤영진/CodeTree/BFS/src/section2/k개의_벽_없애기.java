package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class k개의_벽_없애기 {
    // 숫자 0, 1로만 이루어진 nn격자
    // k개의 벽을 적절하게 없애 시작점으로부터 상하좌우 인접한 곳으로만 계속 이동하여 도착점까지 도달하는 데 걸리는 시간을 최소

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, k;
    static int[][] map;
    static boolean[][] visited;
    static int[][] countMap;
    static int r1, c1, r2, c2;

    static List<Point> wall = new ArrayList<>();
    static List<Point> selectedWall = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static Queue<Point> queue = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) wall.add(new Point(i, j));
            }
        }
        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken()) - 1;
        c1 = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken()) - 1;
        c2 = Integer.parseInt(st.nextToken()) - 1;

        findMin(0, 0);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(result);
        }


    }

    private static void findMin(int depth, int start) {
        if (depth == k) {
            init();
            bfs();
            if (visited[r2][c2]) {
                result = Math.min(result, countMap[r2][c2]);
            }

            for (int i = 0; i < selectedWall.size(); i++) {
                int x = selectedWall.get(i).x;
                int y = selectedWall.get(i).y;

                map[x][y] = 1;
            }

        } else {
            for (int i = start; i < wall.size(); i++) {
                selectedWall.add(wall.get(i));
                findMin(depth + 1, i + 1);
                selectedWall.remove(selectedWall.size() - 1);
            }
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point now = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];
                    if (canGo(nx, ny)) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                        countMap[nx][ny] = countMap[now.x][now.y] + 1;
                        if (nx == r2 && ny == c2) return;
                    }
                }
            }
        }

    }

    private static boolean canGo(int nx, int ny) {
        return (isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1);
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }

    private static void init() {
        queue.clear();
        visited = new boolean[n][n];
        countMap = new int[n][n];

        for (int i = 0; i < selectedWall.size(); i++) {
            int x = selectedWall.get(i).x;
            int y = selectedWall.get(i).y;
            map[x][y] = 0;
        }
        visited[r1][c1] = true;
        queue.offer(new Point(r1, c1));
    }
}
