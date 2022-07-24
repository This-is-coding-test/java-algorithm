import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속_부분수열 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//
//        int[] arr = new int[N];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        int result = 0;
//        for (int i = 0; i < N; i++) {
//            int sum = 0;
//            for (int j = i; j < N; j++) {
//                sum += arr[j];
//                if (sum > M) break;
//                if (sum == M) result++;
//            }
//        }
//        System.out.println(result);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = 1;
        int answer = 0;

        int sum = arr[0];
        if (sum == M) answer ++;

        while (rt < N) {
            sum += arr[rt++];
            if (sum == M) answer++;
            while (sum>=M) {
                sum -= arr[lt++];
                if (sum==M) answer++;
            }
        }
        System.out.println(answer);
    }
}
