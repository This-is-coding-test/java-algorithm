import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구실3 {
    // 바이러스는 활성 상태와 비활성 상태가 있다.
    // 처음 바이러는 비활성 상태, 활성 상태인 바이러스는 상하좌우로 인접한 모든 빈 칸으로 복제
    // M개를 활성 상태로 변경
    // 활성 바이러스가 비활성 바이러스가 있는 칸으로 가면 비활성 바이러스가 활성으로 변한다.

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static ArrayList<Point> selectedVirus = new ArrayList<>();
    static ArrayList<Point> virus = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int emptyCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new Point(i, j));
                } else if (map[i][j] == 0) emptyCnt++;
            }
        }
        backtracking(0, 0);
        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);

    }

    private static void backtracking(int depth, int start) {
        if (depth == M) {
            int result = spread();
            if (result != -1) answer = Math.min(answer, result);
        } else {
            for (int i = start; i < virus.size(); i++) {
                Point p = virus.get(i);
                selectedVirus.add(p);
                backtracking(depth + 1, i + 1);
                selectedVirus.remove(selectedVirus.size() - 1);
            }
        }
    }

    private static int spread() {

        int ret = 0;
        int cnt = 0;
        boolean[][] visited = new boolean[N][N];
        int[][] dist = new int[N][N];
        for (Point p : selectedVirus) {
            visited[p.x][p.y] = true;
        }

        Queue<Point> queue = new LinkedList<>(selectedVirus);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if (!inRange(nx, ny)) continue;
                    if (!visited[nx][ny] && map[nx][ny] != 1) {
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[p.x][p.y] + 1;
                        if (map[nx][ny] != 2) {
                            ret = Math.max(ret, dist[nx][ny]);
                            cnt++;
                        }
                    }

                }
            }
        }

        if (emptyCnt == cnt) return ret;

        return -1;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }
}
