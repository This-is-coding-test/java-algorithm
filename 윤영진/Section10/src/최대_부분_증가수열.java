import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최대_부분_증가수열 {
    static int N;
    static int[] arr;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dy = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dy[0] = 1;
        int result = 0;

        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dy[i] = Math.max(dy[i], dy[j] + 1);
                }
            }
            if (dy[i] == 0) {
                dy[i] = 1;
            }
            result = Math.max(result, dy[i]);
        }

        System.out.println(result);
    }
}
