import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운_최단거리 {
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
    static int[][] copyMap;
    static boolean[][] visited;
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
        visited = new boolean[N][M];
        copyMap = new int[N][M];


        Point start = new Point(-1, -1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start = new Point(i, j);
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                copyMap[i][j] = map[i][j];
//            }
//        }


        visited[start.x][start.y] = true;
        queue.offer(new Point(start.x, start.y));
//        copyMap[start.x][start.y] = 0;

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    System.out.print(copyMap[i][j] + " ");
                } else {
                    if (map[i][j] != 0) {
                        System.out.print(-1 + " ");
                    } else {
                        System.out.print(map[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }


    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {

                Point cP = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = cP.x + dx[k];
                    int ny = cP.y + dy[k];
                    if (canGo(nx, ny)) {
                        visited[nx][ny] = true;
                        copyMap[nx][ny] = copyMap[cP.x][cP.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }


    }

    private static boolean canGo(int nx, int ny) {
        return inRange(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny];
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }
}
