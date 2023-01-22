import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 톱니바퀴 {
    // 총 8개의 톱니를 가지고 있는 톱니바퀴 4개가 일렬로 놓아져 있다.
    // 톱니는 N극 또는 S극 중 하나
    // 톱니는 왼쪽부터 1번,2번,3번,4번

    // 톱니바퀴를 총 K번 회전
    // 톱니바퀴가 회전할 때, 서로 맞닿은 극에 따라서 옆에 있는 톱니바퀴를 회전시킬 수도 있고, 회전시키지 않을 수도 있다.
    // 톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전
    // 톱니가 같다면 회전X

    static int[][] map = new int[4][8];
    static int[][] nextMap = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()); // 1 시계, -1 반시계
            simulate(n, dir);
        }

        int val = 0; // 1,2,4,8
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (map[i][0] == 1) {
                score += Math.pow(2, val);
            }
            val++;
        }

        System.out.println(score);

    }

    private static void simulate(int n, int dir) {

        init();

        // 왼쪽
        int left = n - 1;
        int leftDir = -dir;
        while (left >= 0) {
            if (map[left][2] != map[left + 1][6]) {
                rotate(left, leftDir);
                left--;
                leftDir = -leftDir;
            } else {
                break;
            }
        }

        // 오른쪽
        int right = n + 1;
        int rightDir = -dir;
        while (right < 4) {
            if (map[right - 1][2] != map[right][6]) {
                rotate(right, rightDir);
                right++;
                rightDir = -rightDir;
            } else {
                break;
            }
        }

        rotate(n, dir);


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = nextMap[i][j];
            }
        }

    }

    private static void rotate(int n, int dir) {

        int tmp;

        if (dir == 1) { // 시계
            tmp = nextMap[n][7];
            for (int i = 7; i > 0; i--) {
                nextMap[n][i] = nextMap[n][i - 1];
            }
            nextMap[n][0] = tmp;
        } else { // 반시계
            tmp = nextMap[n][0];
            for (int i = 0; i < 7; i++) {
                nextMap[n][i] = nextMap[n][i + 1];
            }
            nextMap[n][7] = tmp;
        }
    }


    private static void init() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                nextMap[i][j] = map[i][j];
            }
        }

    }
}
