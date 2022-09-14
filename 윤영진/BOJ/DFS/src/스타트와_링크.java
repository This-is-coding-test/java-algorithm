import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 스타트와_링크 {
    static int N;
    static int[][] arr;
    static int[] output;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        output = new int[N / 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 1);
        System.out.println(result);


    }

    private static void comb(int depth, int start) {

        if (depth == N / 2) {
            List<Integer> teamA = new ArrayList<>();
            List<Integer> teamB = new ArrayList<>();


            // (1, 2) -> (3, 4)
            // (1, 4, 6) -> (2, 3, 5)
            for (int i = 1; i <= N; i++) {
                int finalI = i;
                if (Arrays.stream(output).anyMatch(value -> value == finalI)) {
                    teamA.add(i);
                } else {
                    teamB.add(i);
                }
            }

            int a_value = 0;
            int b_value = 0;

            for (int i = 0; i < teamA.size() - 1; i++) {
                for (int j = i + 1; j < teamA.size(); j++) {
                    int ax = teamA.get(i); // 1
                    int ay = teamA.get(j); // 4
                    int bx = teamB.get(i); // 3
                    int by = teamB.get(j); // 4

                    a_value += arr[ax][ay] + arr[ay][ax];
                    b_value += arr[bx][by] + arr[by][bx];

                }

            }
            result = Math.min(result, Math.abs(a_value - b_value));

        } else {

            for (int i = start; i <= N; i++) {

                output[depth] = i;
                comb(depth + 1, i + 1);


            }


        }


    }
}
