package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class K번_최댓값으로_이동하기 {
    static class Point {
        int x;
        int y;
        int num;

        public Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static int n, k;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, 0, -1}; // 하 우 좌 상
    static int[] dy = {0, 1, -1, 0};

    static Queue<Point> queue = new LinkedList<>();
    static List<Point> points = new ArrayList<>();
    static int r, c;

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
            }
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        while (k-- > 0) {

            points.clear();
            boolean isMoved = move();

            if (!isMoved) break;
        }


        System.out.print(r + 1);
        System.out.print(" ");
        System.out.println(c + 1);

    }

    private static boolean move() {
        visited = new boolean[n][n];
        visited[r][c] = true;
        queue.offer(new Point(r, c, 0));
        bfs(map[r][c]);

        if (points.size() == 0) return false;

        points.sort((o1, o2) -> {
            if (o1.num != o2.num) return o2.num - o1.num;
            if (o1.x != o2.x) return o1.x - o2.x;
            return o1.y - o2.y;
        });

        r = points.get(0).x;
        c = points.get(0).y;
        return true;

    }

    private static void bfs(int num) {
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point cP = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = cP.x + dx[k];
                    int ny = cP.y + dy[k];

                    if (canGo(nx, ny, num)) {
                        visited[nx][ny] = true;
                        if (max <= map[nx][ny]) {
                            max = map[nx][ny];
                            points.add(new Point(nx, ny, map[nx][ny]));
                        }
                        queue.offer(new Point(nx, ny, 0));
                    }
                }
            }

        }

    }

    private static boolean canGo(int nx, int ny, int num) {

        return isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] < num;

    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
