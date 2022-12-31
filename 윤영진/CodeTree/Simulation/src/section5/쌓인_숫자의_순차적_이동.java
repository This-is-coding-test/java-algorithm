package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 쌓인_숫자의_순차적_이동 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;


    public static ArrayList<Integer>[][] map;

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j].add(Integer.parseInt(st.nextToken()));
            }
        }

        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int moveNum = Integer.parseInt(st.nextToken());
            simulate(moveNum);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].size() == 0)
                    System.out.print("None");
                else {
                    for (int k = map[i][j].size() - 1; k >= 0; k--) {
                        System.out.print(map[i][j].get(k) + " ");
                    }
                }
                System.out.println();
            }

        }


    }

    private static void simulate(int num) {

        Point p = getPos(num);
        Point nP = getNextPos(p);

        if (nP.x != -1) {
            move(p, nP, num);
        }


    }

    private static void move(Point p, Point nP, int num) {

        // Step1. (x, y) 위치에 있던 숫자들 중
        // moveNum 위에 있는 숫자들을 전부 옆 위치로 옮겨줍니다.

        boolean movable = false;
        for (int i = 0; i < map[p.x][p.y].size(); i++) {
            if (map[p.x][p.y].get(i) == num) {
                movable = true;
            }

            if (movable) {
                map[nP.x][nP.y].add(map[p.x][p.y].get(i));
            }

        }

        // Step2. (x, y) 위치에 있던 숫자들 중
        // 움직인 숫자들을 전부 비워줍니다.
        while (map[p.x][p.y].get(map[p.x][p.y].size() - 1) != num) {
            map[p.x][p.y].remove(map[p.x][p.y].size() - 1);
        }
        map[p.x][p.y].remove(map[p.x][p.y].size() - 1);
    }

    private static Point getNextPos(Point p) {

        int max = Integer.MIN_VALUE;
        int targetX = -1;
        int targetY = -1;
        for (int i = 0; i < 8; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            for (int j = 0; j < map[nx][ny].size(); j++) {
                if (map[nx][ny].get(j) > max) {
                    max = map[nx][ny].get(j);
                    targetX = nx;
                    targetY = ny;
                }
            }
        }
        return new Point(targetX, targetY);
    }

    private static Point getPos(int num) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < map[i][j].size(); k++) {
                    if (map[i][j].get(k) == num) return new Point(i, j);
                }
            }
        }

        return null;


    }
}
