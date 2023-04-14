import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇_청소기 {
    // 직사각형 방을 로봇 청소기를 이용해 청소
    // 로봇 청소기는 유저가 직접 경로를 설정할 수 있다.

    // 칸은 깨끗한 칸과 더러운 칸으로 나눠져 있다.
    // 로봇 청소기는 더러운 칸 -> 깨긋한 칸
    // 일부 칸에는 가구
    // 로봇은 한 번 움직일 때, 인접한 칸으로 이동
    // 로봇은 같은 칸을 여러 번 방문 할 수 있다.
    // 더러운 칸을 모두 깨끗한 칸으로 만드는데 필요한 이동 횟수의 최솟값
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node {
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int w, h; // w - 가로, h - 세로
    static char[][] map;
    // BFS - 거리를 구하고, DFS 탐색
    static ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
    static Point[] dustPoints;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            map = new char[h][w];
            adjList = new ArrayList<>();
            answer = Integer.MAX_VALUE;

            dustPoints = new Point[11];
            int dustIdx = 1;
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == 'o') dustPoints[0] = new Point(i, j);
                    else if (map[i][j] == '*') dustPoints[dustIdx++] = new Point(i, j);
                }
            }

            for (int i = 0; i < dustIdx; i++) {
                adjList.add(new ArrayList<>());
            }
            // 모든 최단 경로 정보 저장
            for (int i = 0; i < dustIdx; i++) {
                for (int j = i + 1; j < dustIdx; j++) {
                    int dist = bfs(dustPoints[i], dustPoints[j]);
                    if (dist == -1) continue;

                    adjList.get(i).add(new Node(j, dist));
                    adjList.get(j).add(new Node(i, dist));
                }
            }
            visited = new boolean[adjList.size()];
            visited[0] = true;
            permutation(0, 0, 0);
            if (answer == Integer.MAX_VALUE) sb.append(-1).append("\n");
            else sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void permutation(int depth, int start, int dist) {
        if (depth == adjList.size() - 1) {
            answer = Math.min(answer, dist);
        } else {
            for (Node node : adjList.get(start)) {
                if (!visited[node.v]) {
                    visited[node.v] = true;
                    permutation(depth + 1, node.v, dist + node.cost);
                    visited[node.v] = false;
                }
            }
        }
    }

    private static int bfs(Point src, Point dst) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        visited[src.x][src.y] = true;
        queue.offer(src);

        int L = 0;
        while (!queue.isEmpty()) {
            L++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if (!inRange(nx, ny)) continue;
                    if (!visited[nx][ny] && map[nx][ny] != 'x') {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            if (visited[dst.x][dst.y]) return L;
        }
        return -1;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < h && ny < w;
    }
}
