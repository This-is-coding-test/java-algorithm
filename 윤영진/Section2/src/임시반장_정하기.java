import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 임시반장_정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][6];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = Integer.MIN_VALUE;
        int answer = 0;


        for (int i = 1; i <= N; i++) {
            int cnt = 0; // i번 학생의 cnt
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    for (int k = 1; k <= 5; k++) {
                        if (map[i][k] == map[j][k]) {
                            cnt++;
                            break;
                        }
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        System.out.println(answer);


    }
}
