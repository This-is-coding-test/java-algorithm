package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼각형_컨베이어_벨트 {

    static int n, t;
    static int[][] belt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        belt = new int[3][n];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                belt[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (t-- > 0) {

            int temp1 = belt[0][n - 1]; // [0][2] -> [1][0]
            int temp2 = belt[1][n - 1]; // [1][2] -> [2][0]
            int temp3 = belt[2][n - 1]; // [2][2] -> [0][0]

            for (int i = n - 1; i >= 1; i--) {
                belt[0][i] = belt[0][i - 1];
                belt[1][i] = belt[1][i - 1];
                belt[2][i] = belt[2][i - 1];
            }

            belt[0][0] = temp3;
            belt[1][0] = temp1;
            belt[2][0] = temp2;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(belt[i][j] + " ");
            }
            System.out.println();
        }


    }
}
