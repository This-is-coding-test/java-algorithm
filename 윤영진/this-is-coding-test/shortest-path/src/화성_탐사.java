import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 화성_탐사 {
    // 화성 탐사 기계가 출발 지점에서 목표 지점까지 이동할 때 항상 최적의 경로를 찾도록 개발

    static class Point {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static final int INF = 987654321;
    static int N;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            dist = new int[N][N];
            PriorityQueue<Point> pQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], INF);
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dist[0][0] = arr[0][0];
            pQ.offer(new Point(0, 0, arr[0][0]));

            while (!pQ.isEmpty()) {
                Point p = pQ.poll();
                if (p.cost > dist[p.x][p.y]) continue;

                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if (!inRange(nx, ny)) continue;
                    if (p.cost + arr[nx][ny] < dist[nx][ny]) {
                        dist[nx][ny] = p.cost + arr[nx][ny];
                        pQ.offer(new Point(nx, ny, p.cost + arr[nx][ny]));
                    }
                }

            }
            sb.append(dist[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean inRange(int nx, int ny) {
        return nx < N && ny < N && nx >= 0 && ny >= 0;
    }
}
