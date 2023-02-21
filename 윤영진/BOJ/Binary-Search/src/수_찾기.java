import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수_찾기 {
    static int N, M;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int f = Integer.parseInt(st.nextToken());
//            if (max < f) {
//                sb.append(0).append("\n");
//                continue;
//            }
            if (binarySearch(f)) {
                sb.append(1).append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(int f) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == f) {
                return true;
            } else if (arr[mid] > f) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}