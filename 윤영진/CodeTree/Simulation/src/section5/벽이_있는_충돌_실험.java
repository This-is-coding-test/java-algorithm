package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 벽이_있는_충돌_실험 {

    static class Point {
        int x;
        int y;
        int d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }


    }

    static int T;
    static int N, M;
    static int[][] count;

    static int[] dx = {-1, 0, 0, 1}; // 상우좌하 -> 대칭 처리
    static int[] dy = {0, -1, 1, 0};
    static List<Point> marbles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());


        int[] dirMapper = new int[128];
        dirMapper['U'] = 0;
        dirMapper['R'] = 1;
        dirMapper['L'] = 2;
        dirMapper['D'] = 3;


        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            count = new int[N + 1][N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                char d = st.nextToken().charAt(0);

                marbles.add(new Point(x, y, dirMapper[d]));
            }
            for (int i = 1; i <= 2 * N; i++) {
                simulate();
            }

            sb.append(marbles.size()).append("\n");
        }
        System.out.println(sb);
    }

    private static void removeDuplicateMarbles() {
        ArrayList<Point> tempVector = new ArrayList<>();

        // count 배열 clear
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                count[i][j] = 0;
            }
        }

        for (int i = 0; i < marbles.size(); i++) {
            int x = marbles.get(i).x;
            int y = marbles.get(i).y;
            count[x][y]++;
        }

        for (int i = 0; i < marbles.size(); i++)
            if (!duplicateMarbleExist(i))
                tempVector.add(marbles.get(i));

        marbles = tempVector;

    }

    private static boolean duplicateMarbleExist(int idx) {
        int targetX = marbles.get(idx).x;
        int targetY = marbles.get(idx).y;

        return count[targetX][targetY] >= 2;
    }

    private static void simulate() {

        // Step1
        // 구슬을 전부 한 번씩 움직여 봅니다.
        moveAll();

        // Step2
        // 움직임 이후에 충돌이 일어나는 구슬들을 골라 목록에서 지워준다.
        removeDuplicateMarbles();
    }

    private static void moveAll() {
        for (int i = 0; i < marbles.size(); i++) {
            Point nP = move(marbles.get(i));
            marbles.set(i, nP);
        }
    }

    private static Point move(Point p) {
        int nx = p.x + dx[p.d];
        int ny = p.y + dy[p.d];

        if (nx <= 0 || ny <= 0 || nx > N || ny > N) { // 벽 O
            int newDir = 3 - p.d;
            return new Point(p.x, p.y, newDir);
        } else {
            return new Point(nx, ny, p.d);
        }
    }


}
