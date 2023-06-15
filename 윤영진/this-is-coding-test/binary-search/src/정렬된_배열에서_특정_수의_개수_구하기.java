import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정렬된_배열에서_특정_수의_개수_구하기 {
    static int N, x;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 368

        int s = findStart();
        int e = findEnd();
        if (s == -1 || e == -1) System.out.println(s);
        else {
            System.out.println(e - s + 1);
        }


    }

    private static int findStart() {
        int left = 0;
        int right = N - 1;
        int idx = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                idx = mid;
                right = mid - 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }

    private static int findEnd() {
        int left = 0;
        int right = N - 1;
        int idx = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                idx = mid;
                left = mid + 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }
}