import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 랜선_자르기 {
    // 캠프 때 쓸 N개의 랜선을 만들기 위해 영식이에게 도움
    // 이미 영식이는 K개의 ㅐㄴ선
    // 하지만 K개의 랜선은 길이가 제각각
    // 성원은 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다.
    // 만들 수 있는 최대 랜선 길이

    static int K, N;
    static long[] arr;
    static long result = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[N];
        long max = Long.MIN_VALUE;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        binarySearch(max);
        System.out.println(result);

    }

    private static void binarySearch(long max) {
        long left = 1;
        long right = max;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

    }


    private static boolean check(long mid) {
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            cnt += arr[i] / mid;
        }
        return cnt >= N;
    }


}
