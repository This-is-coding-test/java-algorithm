import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class 뮤직비디오 {

    static int result;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int rt = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            rt += arr[i];
        }
        OptionalInt lt = Arrays.stream(arr).max();
        binarySearch(arr, lt.getAsInt(), rt);


    }

    private static void binarySearch(int[] arr, int lt, int rt) {

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (check(arr, mid)) {
                if (mid == 24) {
                    System.out.println("check");
                }
                result = mid;
                rt = mid - 1;
            }else {
                lt = mid + 1;
            }
        }
        System.out.println(result);
    }

    private static boolean check(int[] arr, int mid) {

        int count = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > mid) {
                sum = arr[i];
                count++;
            }
        }
        return count <= M;
    }
}
