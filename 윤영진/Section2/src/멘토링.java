import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 멘토링 {
    //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken()); // 4
//        int M = Integer.parseInt(st.nextToken()); // 3
//        int[][] arr = new int[M][N];
//        int[][] check = new int[N][N];
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (i != j) {
//                    check[i][j] = 1;
//                }
//            }
//        }
//
//
//        int answer = 0;
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                for (int k = j + 1; k < N; k++) {
//                    check[arr[i][k] - 1][arr[i][j] - 1] = 0;
//                }
//            }
//        }
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (check[i][j] == 1) {
//                    answer++;
//                }
//            }
//        }
//
//        System.out.println(answer);
//
//
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 4
        int M = Integer.parseInt(st.nextToken()); // 3
        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int cnt = 0;
                if (i != j) {
                    for (int k = 0; k < M; k++) {
                        int pos1 = 0;
                        int pos2 = 0;
                        for (int l = 0; l < N; l++) {
                            if (i == arr[k][l]) {
                                pos1 = l;
                            }
                            if (j == arr[k][l]) {
                                pos2 = l;
                            }
                        }
                        if (pos1 < pos2) cnt++;
                        else {
                            break;
                        }
                    }
                }
                if (cnt == M) {
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }
}
