import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구실3 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point obj1 = (Point) obj;
            return this.x == obj1.x && this.y == obj1.y;
        }
    }

    // 활성 바이러스가 비활성 바이러스가 있는 칸으로 가면 활성으로 변한다.

    static int[][] boards;
    static int N;
    static int M; // 활성화 바이러스 개수

    static List<Point> virus = new ArrayList<>();
    static int[] output;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = Integer.MAX_VALUE;
    static int blank;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boards = new int[N][N];
        output = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                boards[i][j] = Integer.parseInt(st.nextToken());
                if (boards[i][j] == 2) {
                    virus.add(new Point(i, j));
                } else if (boards[i][j] == 0) {
                    blank++;
                }

            }
        }
        if (blank == 0) {
            System.out.println(0);
            return;
        }

        comb(0, 0);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);


    }

    private static void comb(int start, int L) {

        if (L == M) {
            int[][] map = arrayCopy(boards);
            BFS(map, new boolean[N][N]);
            result = Math.min(getMaxValue(map), result);
        } else {
            for (int i = start; i < virus.size(); i++) {
                output[L] = i;
                comb(i + 1, L + 1);
            }
        }

    }


    private static int[][] arrayCopy(int[][] boards) {
        int[][] copyMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (boards[i][j] != 1) {
                    copyMap[i][j] = Integer.MAX_VALUE;
                } else {
                    copyMap[i][j] = -1;
                }

            }
        }
        return copyMap;

    }

    private static void BFS(int[][] map, boolean[][] visited) {

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            queue.add(virus.get(output[i]));
            map[virus.get(output[i]).x][virus.get(output[i]).y] = 0; // 바이러스 표시
            visited[virus.get(output[i]).x][virus.get(output[i]).y] = true;
        }

        while (!queue.isEmpty()) {

            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N
                        && !visited[nx][ny] && map[nx][ny] != -1) {

                    visited[nx][ny] = true;

                    if (boards[nx][ny] == 2) {
                        map[nx][ny] = map[now.x][now.y];
                        queue.add(new Point(nx, ny));
                    }

                    if (boards[nx][ny] == 0) {
                        map[nx][ny] = map[now.x][now.y] + 1;
                        queue.add(new Point(nx, ny));
                    }

                }
            }
        }


    }

    private static int getMaxValue(int[][] map) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != -1 && map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }
        return max;
    }
}
