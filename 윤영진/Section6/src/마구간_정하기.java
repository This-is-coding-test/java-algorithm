import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 마구간_정하기 {

    static int result;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[N - 1];
        binarySearch(arr, lt, rt);
    }

    private static void binarySearch(int[] arr, int lt, int rt) {

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (check(arr, mid)) {
                result = mid;
                lt = mid + 1;
            }else {
                rt = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean check(int[] arr, int mid) {

        int count = 1;
        int point = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - point >= mid) {
                count++;
                point = arr[i];
            }

        }
        return count >= C;
    }
}
