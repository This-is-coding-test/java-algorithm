import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 전쟁 {

    // 우리 병사들은 흰색 옷
    // 적국의 병사들은 파란색 옷

    // 같은 팀의 병사들은 모이면 모일수록 강해진다
    // N명이 뭉쳐있을 때는 N^2의 위력을 낼 수 있다.

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static char[][] map;
    static boolean[][] visited;

    static int sumA = 0;
    static int sumB = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};



    static int count = 0;

    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로

        map = new char[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }


        // DFS
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count = 1;
                    visited[i][j] = true;
                    DFS(i, j, map[i][j]);

                    if (map[i][j] == 'W') {
                        sumA += Math.pow(count, 2);
                    } else {
                        sumB += Math.pow(count, 2);
                    }
                }

            }
        }
        System.out.println(sumA + " " + sumB);

        // BFS
        visited = new boolean[M][N];
        sumA = 0;
        sumB = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count = 1;
                    visited[i][j] = true;
                    queue.add(new Point(i, j));
                    BFS(map[i][j]);
                    if (map[i][j] == 'W') {
                        sumA += Math.pow(count, 2);
                    } else {
                        sumB += Math.pow(count, 2);
                    }
                }
            }
        }

        System.out.print(sumA + " " + sumB);

    }

    private static void DFS(int x, int y, char type) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny]) {
                if (map[nx][ny] == type) {
                    count++;
                    visited[nx][ny] = true;
                    DFS(nx, ny, type);
                }
            }

        }

    }

    private static void BFS(char type) {

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny]) {
                    if (map[nx][ny] == type) {
                        count++;
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }

    }
}
