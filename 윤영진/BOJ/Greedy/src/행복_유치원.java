import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행복_유치원 {

    // N명의 원생들을 키 순서대로 세우고, 총 K개의 조로 나눈다.
    static int N, K;
    static int[] arr;
    static int[] diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        diff = new int[N - 1]; // 0, 1, 2, 3
        arr = new int[N]; // 0, 1, 2, 3
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(diff);

        int sum = 0;
        for (int i = 0; i < N - K; i++) {
            sum += diff[i];
        }
        System.out.println(sum);


    }
}