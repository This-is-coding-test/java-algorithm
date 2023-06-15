import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기_설치 {
    // C개의 공유기를 N개의 집에 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램
    static int N, C;
    static int[] house;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);


        // 거리를 기준으로 이분 탐색
        binarySearch();
        System.out.println(answer);

    }

    private static void binarySearch() {
        int left = 1; // 가능한 가장 짧은 거리
        int right = house[N - 1] - house[0]; // 가능한 가장 긴 거리

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

    }
    // 1
    // 1 2 4 8 9
    //
    private static boolean isPossible(int mid) {
        int cnt = 1;
        int prev = house[0];

        for (int i = 1; i < N; i++) {
            if (house[i] - prev >= mid) {
                cnt++;
                prev = house[i];
            }
        }
        return cnt >= C;
    }
}
