package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 비를_피하기_sol {

    // 숫자 0,1,2,3로만 이루어진 nn 격자에서 사람 h명이 겹치지 않게 서 있고, 비를 피할 수 있는 공간 m개가 주어졌을 때
    // 각 사람마다 비를 피할 수 있는 가장 가까운 공간까지의 거리를 구하는 프로그램
    // 0: 이동가능한 칸, 1: 이동 X, 2: 사람, 3: 비를 피할 공간
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, h, m;
    static int[][] map;
    static int[][] countMap;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];
        countMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 3) {
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        bfs();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    if (countMap[i][j] != 0) {
                        System.out.print(countMap[i][j] + " ");
                    } else {
                        System.out.print(-1 + " ");
                    }
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }

    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point now = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];

                    if (canGo(nx, ny)) {
                        visited[nx][ny] = true;
                        countMap[nx][ny] = countMap[now.x][now.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }

                }
            }
        }
    }

    private static boolean canGo(int nx, int ny) {
        return (isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1);


    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
