import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구실2 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    static int[][] boards;
    static List<Point> virous = new ArrayList<>();
    static int[] output;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = Integer.MAX_VALUE;


    // 바이러스 M개 놓기
    // 바이러스 퍼트리기

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
                    virous.add(new Point(i, j));
                }
            }
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
            for (int x : output) {
                BFS(x, map, new boolean[N][N]);
            }
            // 최대값 카운트
            result = Math.min(getMaxValue(map), result);
        } else {
            for (int i = start; i < virous.size(); i++) {
                output[L] = i;
                comb(i + 1, L + 1);
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

    private static void BFS(int idx, int[][] map, boolean[][] visited) {

        Queue<Point> queue = new LinkedList<>();
        Point vir = virous.get(idx);
        queue.offer(vir);

        map[vir.x][vir.y] = 0;

        while (!queue.isEmpty()) {

            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != 0 && map[nx][ny] != -1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = Math.min(map[nx][ny], map[now.x][now.y] + 1);
                    queue.add(new Point(nx, ny));
                }
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
}
