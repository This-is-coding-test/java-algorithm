import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 입국심사 {
    // 상근이와 친구들은 오스트레일리아 여행
    // 상근이와 친구들은 총 M명
    // 입국심사대는 총 N개
    // 각 입국심사관이 심사를 하는데 걸리는 시간은 사람모두 다르다.
    // k번 심사대에 앉아있는 심사관이 한 명을 심사를 하는데 드는 시간은 Tk
    // 심사대가 보이면 거기로 가서 심사를 받을 수 있다. 더 빠른 심사대의 심사가 끝나길 기다린 다음에 그 곳으로 가서 심사를 받아도 된다.

    // 어떻게 심사를 받으면 모든 사람이 심사를 받는데 걸리는 시간이 최소?

    static int N, M;
    static int[] arr;
    static long left, right;
    static long result = -1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        left = 0;
        right = max * M;

        binarySearch();
        System.out.println(result);


    }

    private static void binarySearch() {
        while (left <= right) {
            long mid = (left + right) / 2;

            if (check(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    private static boolean check(long mid) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += (mid / arr[i]);
            if (cnt >= M) return true;
        }
        return false;
    }
}
