import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타_레슨 {
    // 강의 동영상을 블루레이로 만들어 판매
    // 블루레이에는 총 N개의 강의
    // 강의의 순서가 바뀌면 안 된다.
    // 블루레이의 개수를 가급적 줄이려고 한다.
    // M개의 블루레이에 모든 기타 강의 동영상
    // 블루레이의 크기를 최소로 -> 단, 모두 같은 크기
    static int N, M;
    static int[] arr;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        binarySearch(sum, max);
        System.out.println(result);

    }

    private static void binarySearch(int right, int left) {

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
    }

    private static boolean isPossible(int check) {
        int cnt = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum > check) {
                sum = arr[i];
                cnt++;
            }
        }
        return cnt <= M;
    }
}
