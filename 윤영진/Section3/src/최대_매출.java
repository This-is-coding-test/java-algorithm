import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대_매출 {
//    public static void main(String[] args) throws IOException {
//        // TODO 시간초과 날거같은데..
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        int[] arr = new int[N];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i <= N - K; i++) {
//            int sum = 0;
//            for (int j = i; j < i + K; j++) {
//                sum += arr[j];
//            }
//
//            max = Math.max(max, sum);
//        }
//
//        System.out.println(max);
//    }

    // Sliding Window

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        for (int i = K; i < N; i++) {
            sum = sum + arr[i] - arr[i - K];
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);

    }
}
