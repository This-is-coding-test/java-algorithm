import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 모양_만들기 {

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
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int index = 1; // 덩어리 별로 매겨 줄 인덱스
    static ArrayList<Integer> list = new ArrayList<>(); // 각 덩어리(인덱스) 크기
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        Queue<Point> zeroQ = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) { // 배열 중 0인 값은 큐에 넣는다
                    zeroQ.add(new Point(i, j));
                }
            }
        }

        // 전처리
        int[][] nMap = copyMap();
        list.add(0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) { // 원본 배열에서 값이 1이고 아직 방문하지 않았다면
                    int newSize = bfs(i, j, nMap, index); // bfs를 통해 덩어리의 크기를 구하고 그 덩어리들의 값을 인덱스 값으로 바꿔줌
                    index++; // 다음 덩어리의 인덱스 값
                    list.add(newSize); // 현재 덩어리(인덱스)의 덩어리 크기를 리스트에 넣어줌
                }
            }
        }

        while (!zeroQ.isEmpty()) {
            Point p = zeroQ.poll();

            int mergeSize = mergeBfs(p.x, p.y, nMap);
            answer = Math.max(answer, mergeSize);
        }

        System.out.println(answer);
    }

    private static int mergeBfs(int x, int y, int[][] nMap) {

        HashSet<Integer> set = new LinkedHashSet<>();
        int mergeSize = 0;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (!inRange(nx, ny)) continue;

            set.add(nMap[nx][ny]);
        }

        for (Integer idx : set) {
            mergeSize += list.get(idx);
        }

        return mergeSize + 1;
    }

    private static int bfs(int x, int y, int[][] nMap, int index) {
        Queue<Point> que = new LinkedList<>();

        int size = 1; // 덩어리의 사이즈 초깃값
        que.add(new Point(x, y));
        visited[x][y] = true;
        nMap[x][y] = index; // 현재 덩어리의 값을 인덱스 값으로 바꿔줌

        while (!que.isEmpty()) {
            Point p = que.poll();

            int curX = p.x;
            int curY = p.y;

            for (int t = 0; t < 4; t++) {
                int nx = curX + dx[t];
                int ny = curY + dy[t];

                if (!inRange(nx, ny)) continue;

                if (!visited[nx][ny] && nMap[nx][ny] == 1) {
                    que.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    nMap[nx][ny] = index; // 현재 덩어리의 값을 인덱스 값으로 바꿔줌
                    size++;    // 현재 덩어리의 크기를 구함
                }
            }
        }
        return size; // 현재 덩어리의 크기를 반환
    }

    private static int[][] copyMap() {

        int[][] nMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nMap[i][j] = map[i][j];
            }
        }
        return nMap;

    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }
}
