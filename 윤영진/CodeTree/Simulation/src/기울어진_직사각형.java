import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기울어진_직사각형 {

    static int n;
    static int[][] map;

    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) { // 최하단 row
            for (int j = 0; j < n; j++) { // 최하단 col
                for (int k = 1; k < n; k++) { // width
                    for (int l = 1; l < n; l++) { // height
                        result = Math.max(result, getScore(i, j, k, l));
                    }
                }
            }
        }

        System.out.println(result);
        
        
    }

    private static int getScore(int row, int col, int w, int h) {

        int[] moveNum = {w, h, w, h};
        int score = 0;

        for (int d = 0; d < 4; d++) { // 4 방향 탐색
            for (int i = 0; i < moveNum[d]; i++) { // 경계까지 확인
                row += dx[d];
                col += dy[d];


                if (row >= n || col >= n || row < 0 || col < 0) {
                    return 0;
                }
                score += map[row][col];
            }
        }

        return score;
    }
}
