package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이차원_폭발_게임 {
    static int N, M, K;
    static int[][] bombs;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bombs = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                bombs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            while (bomb()) {
                push();
            }
            rotate();
            push();
        }

        while (bomb()) {
            push();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (bombs[i][j] > 0) count++;
            }
        }

        System.out.println(count);

    }

    private static void push() {

        int[][] temp = new int[N][N];

        for (int j = 0; j < N; j++) {
            int nextRow = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (bombs[i][j] > 0)
                    temp[nextRow--][j] = bombs[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bombs[i][j] = temp[i][j];
            }
        }

    }

    private static boolean bomb() {
        boolean flag = false;

        for (int col = 0; col < N; col++) { // 열
            for (int currIdx = 0; currIdx < N; currIdx++) { // 행
                // 각 위치마다 그 뒤로 폭탄이 m개 이상 있는지 확인합니다.

                // 이미 터지기로 예정되어있는 폭탄은 패스합니다.
                if (bombs[currIdx][col] == 0) {
                    continue;
                }
                // currIdx로부터 연속하여 같은 숫자를 갖는 폭탄 중
                // 가장 마지막 위치를 찾아 반환합니다.
                int endIdx = getEndIdxOfExplosion(currIdx, col, bombs[currIdx][col]);

                if (endIdx - currIdx + 1 >= M) {
                    // 연속한 숫자의 개수가 m개 이상인 경우 폭탄이 터졌음을 기록해줍니다.
                    bomb(currIdx, col, endIdx);
                    flag = true;
                }
            }

        }

        return flag;
    }

    private static void bomb(int start, int col, int end) {
        for (int i = start; i <= end; i++) {
            bombs[i][col] = 0;
        }
    }

    public static int getEndIdxOfExplosion(int startIdx, int col, int currNum) {
        int endIdx = startIdx + 1;
        while (endIdx < N) {
            if (bombs[endIdx][col] == currNum)
                endIdx++;
            else {
                break;
            }
        }

        return endIdx - 1;
    }


    private static void rotate() {

        int[][] temp = new int[N][N];

        int currIdx;
        for(int i = N - 1; i >= 0; i--) {
            currIdx = N - 1;
            for(int j = N - 1; j >= 0; j--) {
                if(bombs[i][j] != 0)
                    temp[currIdx--][N - i - 1] = bombs[i][j];
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                bombs[i][j] = temp[i][j];


    }
}