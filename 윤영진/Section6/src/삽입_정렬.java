import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삽입_정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }

        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }


    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;

    }
}
