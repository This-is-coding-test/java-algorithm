import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_붙이기 {
    // 스티커를 붙이는 방법
    // 1. 스티커를 회전시키지 않고 모눈종이에서 떼어낸다.
    // 2. 다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾는다.
    // 3. 선택한 위치에 스티커를 붙인다. 만약 스티커를 붙일 수 있는 위치가 전혀 없어서 스티커를 붙이지 못했다면, 스티커를 시계 방향으로 90도 회전한 뒤 2번 과정을 반복
    // 4. 위의 과정을 네 번 반보개서 스키커를 0도, 90도, 180도, 270도 회전시켜 봤음에도 스티커를 붙이지 못했다면 스티커를 버린다.

    static int N, M; // 세로, 가로
    static int R, C;
    static int K;
    static int[][] map; // 노트북
    static int[][] sticker;
    static int result = 0;
    static int cnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            sticker = new int[R][C];
            int cnt = 0;

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                    if (sticker[i][j] == 1) cnt++;
                }
            }
            findLocation();
        }

        System.out.println(result);


    }

    private static void findLocation() {
        cnt = 0;
        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i + R > N || j + C > M) {
                        break;
                    }
                    if (findAndAttach(i, j)) {
                        result += cnt;
                        return;
                    }
                }
            }
            sticker = rotate();
            R = sticker.length;
            C = sticker[0].length;
        }
    }

    private static int[][] rotate() {
        int[][] newSticker = new int[C][R];

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                newSticker[j][R - i - 1] = sticker[i][j];
        return newSticker;
    }

    private static boolean findAndAttach(int x, int y) {
        for (int i = x; i < x + R; i++) { // 3
            for (int j = y; j < y + C; j++) { // 3
                if (map[i][j] == 1 && sticker[i - x][j - y] == 1) return false;
            }
        }

        for (int i = x; i < x + R; i++) { // 3
            for (int j = y; j < y + C; j++) { // 3
                if (sticker[i - x][j - y] == 1) {
                    cnt++;
                    map[i][j] = 1;
                }
            }
        }
        return true;
    }
}
