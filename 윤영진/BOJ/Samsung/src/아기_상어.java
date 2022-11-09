
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기_상어 {


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[][] map;
    static int sharkX;
    static int sharkY;
    static int sharkSize = 2;
    static int[][] dist;
    static int d = Integer.MAX_VALUE;
    static int minX = Integer.MAX_VALUE;
    static int minY = Integer.MAX_VALUE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int eatCount = 0;
    static int answer = 0;

    // 물고기 M마리와 아기 상어 1마리가 있다.
    // 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.

    // 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }


        while (true) {
            dist = new int[N][N];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            d = Integer.MAX_VALUE;

            BFS();

            if (minX == Integer.MAX_VALUE && minY == Integer.MAX_VALUE) {
                break; // 먹을 물고기가 없는 경우
            }
            answer += d;
            map[minX][minY] = 0;

            sharkX = minX;
            sharkY = minY;

            eatCount++;

            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(answer);


    }

    private static void BFS() {

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(sharkX, sharkY));

        while (!queue.isEmpty()) {

            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && dist[nx][ny] == 0) {
                    if (map[nx][ny] > sharkSize) continue;

                    dist[nx][ny] = dist[now.x][now.y] + 1;

                    if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
                        if (d > dist[nx][ny]) {
                            d = dist[nx][ny];
                            minX = nx;
                            minY = ny;
                        } else if (d == dist[nx][ny]) {
                            if (nx == minX) { // 가장 왼쪽
                                if (minY > ny) {
                                    minX = nx;
                                    minY = ny;
                                }
                            } else if (nx < minX) { // 가장 위
                                minX = nx;
                                minY = ny;
                            }
                        }
                    }
                    queue.add(new Point(nx, ny));


                }
            }

        }

    }
}
