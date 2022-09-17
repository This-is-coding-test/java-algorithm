import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구실 {

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
    static int result = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // 1. 벽 3개 세우기
    // 2. 바이러스 전파하기 
    // 3. 안전영역 개수 카운팅

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boards = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                boards[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 벽 3개 세우기
        makeWall(0);

        System.out.println(result);

    }

    private static void makeWall(int count) {
        if (count == 3) {

            // 바이러스 전파 -> BFS
            int[][] spreadMap = spreadVir(arrayCopy(boards));
            // 안전영역 개수
            countMap(spreadMap);
            return;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (boards[i][j] == 0) {
                        boards[i][j] = 1;
                        makeWall(count + 1);
                        boards[i][j] = 0;
                    }
                }
            }
        }


    }

    private static int[][] arrayCopy(int[][] boards) {
        int[][] copyMap = new int[N][M];

        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M; j++) {
                copyMap[i][j] = boards[i][j];
            }
        }
        return copyMap;

    }

    private static void countMap(int[][] spreadMap) {

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (spreadMap[i][j] == 0) {
                    count++;
                }
            }
        }
        result = Math.max(count, result);

    }

    private static int[][] spreadVir(int[][] spreadMap) {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (spreadMap[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && spreadMap[nx][ny] == 0) {
                    spreadMap[nx][ny] = 2;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return spreadMap;


    }
}
