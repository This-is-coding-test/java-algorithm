import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선택_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int least;
        for (int i = 0; i < N - 1; i++) {
            least = i;
            for (int j = i + 1; j < N; j++) {

                if (arr[j] < arr[least]) {
                    least = j;
                }
            }
            if (least != i) swap(arr, least, i);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }


    }

    private static void swap(int[] arr, int least, int i) {

        int temp = arr[i];
        arr[i] = arr[least];
        arr[least] = temp;

    }
}
