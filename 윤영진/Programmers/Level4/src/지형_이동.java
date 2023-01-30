import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 지형_이동 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

    }

    static int[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int answer = 0;
    static int N, H;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;

    static List<ArrayList<Edge>> listGraph = new ArrayList<>();
    static PriorityQueue<Edge> pQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    static boolean[] check;



    // 1. 이동한 지역 그룹핑
    // 2. 지역을 이동할 수 있는 사다리를 구하기
    // 3. 크루스칼 알고리즘으로 MST

    public int solution(int[][] land, int height) {
        map = land;
        N = land.length;
        H = height;

        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = -1;
            }
        }

        int group = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == -1) {
                    visited[i][j] = group;
                    queue.offer(new Point(i, j));
                    bfs(group);
                    group++;
                }
            }
        }

        check = new boolean[group];
        for (int i = 0; i < group; i++) {
            listGraph.add(new ArrayList<>());
        }

        initPrim();
        dist();

        return answer;
    }

    private void dist() {
        while (!pQ.isEmpty()) {
            Edge edge = pQ.poll(); // 2,12

            if (check[edge.vex]) continue;
            check[edge.vex] = true;
            answer += edge.cost;

            for (Edge edge1 : listGraph.get(edge.vex)) {
                if (check[edge1.vex]) continue;
                pQ.offer(edge1);
            }

        }
    }

    private void initPrim() {

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = x + dx[k];

                    if (!inRange(nx, ny)) continue;
                    if (visited[nx][ny] == visited[x][y]) continue;

                    int cost = Math.abs(map[x][y] - map[nx][ny]);
                    listGraph.get(visited[x][y]).add(new Edge(visited[nx][ny], cost));
                    listGraph.get(visited[nx][ny]).add(new Edge(visited[x][y], cost));
                }
            }
        }



    }

    private void bfs(int group) {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (canGo(nx, ny, map[p.x][p.y])) {
                    visited[nx][ny] = group;
                    queue.offer(new Point(nx, ny));
                }
            }

        }
    }

    private boolean canGo(int nx, int ny, int val) {
        return inRange(nx, ny) && visited[nx][ny] == -1 && Math.abs(map[nx][ny] - val) <= H;
    }

    private boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }


}