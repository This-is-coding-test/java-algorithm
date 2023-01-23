import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 컨베이어_벨트_위의_로봇 {

    // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
    // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
    // 2-1. 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
    // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
    // 4. 내구도가 0인 칸의 개수가 K개 이상이면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, K;
    static int[][] belts;
    static Queue<Point> robots = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belts = new int[2][N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                for (int j = 0; j < N; j++) {
                    belts[i][j] = Integer.parseInt(st.nextToken());
                }
            } else {
                for (int j = N - 1; j >= 0; j--) {
                    belts[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        int time = 0;
        while (K > 0) {
            time++;
            simulate();
//            print();
        }
        System.out.println(time);

    }

    private static void print() {

        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < N; j++) {
                System.out.print(belts[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void simulate() {

        // 벨트 회전
        rotateBelt();

        // 로봇 회전
        rotateRobots();

        // 로봇 이동 / 내구도 감소
        moveRobots();

        // 로봇 올리기 / 내구도 감소
        if (belts[0][0] >= 1) {
            belts[0][0] -= 1;
            if (belts[0][0] == 0) {
                K--;
            }
            robots.offer(new Point(0, 0));
        }
    }

    private static void moveRobots() {
        int len = robots.size();

        for (int i = 0; i < len; i++) {
            Point robot = robots.poll();
            Point nP = getNextPoint(robot);
            if (belts[nP.x][nP.y] >= 1 && nP.y == N - 1) {
                belts[0][N - 1] -= 1;
                if (belts[0][N - 1] == 0) K--;
                continue;
            }

            if (!collide(nP) && belts[nP.x][nP.y] >= 1) {
                belts[nP.x][nP.y] -= 1;
                if (belts[nP.x][nP.y] == 0) K--;

                robots.offer(nP);
            } else {
                robots.offer(robot);
            }

        }


    }

    private static boolean collide(Point p) {
        List<Point> r = new ArrayList<>(robots);
        for (Point point : r) {
            if (p.x == point.x && p.y == point.y) return true;
        }
        return false;
    }

    private static Point getNextPoint(Point p) {
        int nx = p.x;
        int ny = p.y + 1;

        return new Point(nx, ny);
    }

    private static void rotateRobots() {

        int len = robots.size();

        for (int i = 0; i < len; i++) {
            Point robot = robots.poll();
            Point nP = getNextPoint(robot);
            if (nP.y != N - 1) {
                robots.offer(nP);
            }

        }
    }

    private static void rotateBelt() {

        int temp1 = belts[0][N - 1]; // [0][N - 1] -> [1][N - 1]
        int temp2 = belts[1][0]; // [1][0] -> [0][0]

        for (int i = N - 1; i >= 1; i--) {
            belts[0][i] = belts[0][i - 1];
        }

        for (int i = 0; i < N - 1; i++) {
            belts[1][i] = belts[1][i + 1];
        }

        belts[1][N - 1] = temp1;
        belts[0][0] = temp2;

    }

}
