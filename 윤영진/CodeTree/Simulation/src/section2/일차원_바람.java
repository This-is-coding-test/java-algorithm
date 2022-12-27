package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일차원_바람 {

    static int N, M, Q;

    static int r;
    static String d; // r은 바람에 영향을 받는 행 번호, d는 방향이 불어오는 방향
    static int[][] map;

    // 총 Q번의 바람
    // 바람은 특정 행의 모든 원소들을 왼쪽 혹은 오른쪽으로 전부 한 칸씩 밀어 shift 하는 효과
    // 이 바람에 영향을 받아 특정 행의 숫자들이 한 칸씩 밀리게 되면, 위 아래로도 영향을 미치기 시작
    // 전파가 이어질 조건은 현재 행과 나아가려는 행을 비교했을 때, 단 하나라도 같은 열에 같은 숫자가 적혀있는 경우라면 전파를 이어나간다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (Q-- > 0) {

            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            d = st.nextToken();
            int up = r - 1;
            int down = r + 1;

            shift(r, d);
            boolean upFlag = true;
            boolean downFlag = true;

            while (upFlag || downFlag) {
                if (d.equals("L")) {
                    d = "R";
                }else {
                    d = "L";
                }

                if (up >= 1 && upFlag && checkUp(up)) {
                    shift(up, d);
                    up--;
                } else {
                    upFlag = false;
                }
                if (down <= N && downFlag && checkDown(down)) {
                    shift(down, d);
                    down++;
                } else {
                    downFlag = false;
                }
            }


        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkDown(int down) {
        for (int i = 1; i <= M; i++) {
            if (map[down][i] == map[down - 1][i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkUp(int up) {

        for (int i = 1; i <= M; i++) {
            if (map[up][i] == map[up + 1][i]) {
                return true;
            }
        }
        return false;
    }

    private static void shift(int r, String d) {

        int temp;
        if (d.equals("R")) { // 오른쪽으로 밀어야 함
            temp = map[r][1];
            for (int i = 1; i < M; i++) {
                map[r][i] = map[r][i + 1];
            }
            map[r][M] = temp;

        } else { // 왼쪽으로 밀어야 함
            temp = map[r][M];

            for (int i = M; i >= 2; i--) {
                map[r][i] = map[r][i - 1];
            }
            map[r][1] = temp;
        }
    }
}
