import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인내의_도미노_장인_호석 {

    // 2명이 공격과 수비
    // 공격수는 도미노를 계속 넘어뜨리고 수비수는 도미노를 계속 세우려고 한다.

    // N행 M열의 격자 -> 1이상 5이하의 높이
    // 매 라운드는 공격수가 먼저 공격하고, 수비수는 공격이 끝난 뒤에 수비
    // 공격수는 특정 격자에 놓인 도미노를 동, 서, 남, 북 원하는 방향으로 넘어뜨린다.
    // 길이가 K인 도미노가 특정 방향으로 넘어진다면, 그 방향으로 K-1 개의 도미노들 중 아직 넘어지ㅣㅈ 않은 것들이 같은 방향으로 연달아 넘어진다.
    // 이미 넘어진 도미노가 있는 칸을 공격한 경우에는 아무런 일이 일어나지 않는다.

    // 수비수는 넘어져 있는 도미노들 중에 원하는 것 하나를 다시 세울 수 있다. 넘어지지 않은 도미노를 세우려고 하면 아무 일이 일어나지 않는다.
    // 총 R라운드 -> 해당 라운드에 넘어뜨린 도미노의 개수를 세고, R라운드에 걸친 총합이 공격수의 총합

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, R;
    static int[][] map;
    static boolean[][] isFallDown;
    static int[] dx = {0, 0, 1, -1}; // E, W, S, N
    static int[] dy = {1, -1, 0, 0};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        isFallDown = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dirMapper = new int[128];
        dirMapper['E'] = 0;
        dirMapper['W'] = 1;
        dirMapper['S'] = 2;
        dirMapper['N'] = 3;

        while (R-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            if (!isFallDown[r][c]) {
                isFallDown[r][c] = true;
                cnt += attack(r, c, dirMapper[d]);
            }

            st = new StringTokenizer(br.readLine());
            int dr = Integer.parseInt(st.nextToken());
            int dc = Integer.parseInt(st.nextToken());

            defend(dr, dc);
        }

        print();
    }

    private static void print() {
        System.out.println(cnt);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (isFallDown[i][j]) {
                    System.out.print("F" + " ");
                } else {
                    System.out.print("S" + " ");
                }
            }
            System.out.println();
        }
    }

    private static void defend(int dr, int dc) {
        isFallDown[dr][dc] = false;
    }

    private static int attack(int r, int c, int d) {

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c));
        int res = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;

            int len = map[x][y];

            for (int i = 1; i < len; i++) { // 1, 2
                x += dx[d];
                y += dy[d];
                if (!inRange(x, y)) break;

                if (!isFallDown[x][y]) {
                    isFallDown[x][y] = true;
                    res++;
                    queue.offer(new Point(x, y));
                }
            }
        }
        return res;
    }

    private static boolean inRange(int nx, int ny) {
        return nx > 0 && ny > 0 && nx <= N && ny <= M;

    }
}
