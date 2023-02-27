import java.io.*;
import java.util.*;

public class 로봇 {
    // 두 가지 명령어
    // 1. Go k -> k는 1,2,3 -> 현재 향하고 있는 방향으로 k칸 만큼 이동
    // 2. Turn dir -> dir은 left 또는 right이며, 각각 왼쪽 또는 오른쪽으로 90도 회전
    // 0은 로봇이 갈 수 있는 지점, 1은 로봇이 갈 수 없는 지점

    static class Robot {
        int x;
        int y;
        int d;
        int t;

        public Robot(int x, int y, int d, int t) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.t = t;
        }


    }

    static int M, N;
    static int[][] map;
    static int sr, sc, sd;
    static int er, ec, ed;
    static boolean[][][] visited;
    static Queue<Robot> queue = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1}; // 동 서 남 북
    static int[] dy = {1, -1, 0, 0};
    // d : 0,1,2,3 -> 동, 서, 남, 북
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[4][M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        sd = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        er = Integer.parseInt(st.nextToken()) - 1;
        ec = Integer.parseInt(st.nextToken()) - 1;
        ed = Integer.parseInt(st.nextToken()) - 1;
        visited[sd][sr][sc] = true;
        queue.offer(new Robot(sr, sc, sd, 0));

        bfs();


    }

    private static void bfs() {

        while (!queue.isEmpty()) {

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Robot r = queue.poll();
                if (r.x == er && r.y == ec && r.d == ed) {
                    System.out.println(r.t);
                    return;
                }

                // 해당 방향으로 3번 이동 가능
                for (int k = 1; k <= 3; k++) {
                    int nx = r.x + dx[r.d] * k;
                    int ny = r.y + dy[r.d] * k;
                    if (!inRange(nx, ny) || map[nx][ny] != 0) break;

                    if (!visited[r.d][nx][ny]) {
                        visited[r.d][nx][ny] = true;
                        queue.offer(new Robot(nx, ny, r.d, r.t + 1));
                    }
                }

                // 4방향 회전
                int left = rotateLeft(r.d);
                int right = rotateRight(r.d);

                if (!visited[left][r.x][r.y]) {
                    visited[left][r.x][r.y] = true;
                    queue.offer(new Robot(r.x, r.y, left, r.t + 1));
                }
                if (!visited[right][r.x][r.y]) {
                    visited[right][r.x][r.y] = true;
                    queue.offer(new Robot(r.x, r.y, right, r.t + 1));
                }
            }
        }


    }

    private static int rotateLeft(int d) {
        if (d == 0) {
            return 3;
        } else if (d == 1) {
            return 2;
        } else if (d == 2) {
            return 0;
        } else {
            return 1;
        }
    }

    private static int rotateRight(int d) {
        if (d == 0) {
            return 2;
        } else if (d == 1) {
            return 3;
        } else if (d == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < M && ny < N;
    }
}
