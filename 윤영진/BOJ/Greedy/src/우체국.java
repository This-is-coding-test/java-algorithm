import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 우체국 {
    // 일직선상에 N개의 마을
    // i번째 마을은 X[i]에 위치 -> A[i] 명이 살고 있다.
    // 우체국을 세우려는데 위치가 고민 -> 각 사람들까지의 거리의 합이 최소
    // 마을까지의 거리 합이 아닌 사람까지의 거리 합

    static int N;

    static class Pair {
        int x;
        int a;

        public Pair(int x, int a) {
            this.x = x;
            this.a = a;
        }
    }

    static Pair[] pairs;
    static long[] sum;
    static int result = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        pairs = new Pair[N];
        sum = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(x, a);
        }
        Arrays.sort(pairs, (o1, o2) -> o1.x - o2.x);

        sum[0] = pairs[0].a;
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + pairs[i].a;
        }

        binarySearch();
        System.out.println(result);


    }

    private static void binarySearch() {

        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            long leftSum = sum[mid];
            long rightSum = sum[N - 1] - sum[mid];

            if (leftSum >= rightSum) {
                right = mid - 1;
                result = Math.min(result, pairs[mid].x);
            }else {
                left = mid + 1;
            }
        }

    }
}
