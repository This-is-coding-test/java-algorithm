import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.StringTokenizer;

public class 임시반장_정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][6];
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    for (int k = 1; k <= 5; k++) {
                        if (map[i][k] == map[j][k]) {
                            arr[i]++;
                            break;
                        }
                    }
                }
            }
        }


        int idx = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (max < arr[i]) {
                idx = i;
                max = arr[i];
            }
        }
        System.out.println(idx);


    }
}
