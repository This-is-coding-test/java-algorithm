import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가위_바위_보 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[N];
        for (int i = 0; i < N; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {

            if (arr1[i] == arr2[i]) {
                System.out.println("D");
            } else if (arr1[i] == 1) { // 가위
                if (arr2[i] == 2) {
                    System.out.println("B");
                } else if (arr2[i] == 3) {
                    System.out.println("A");
                }
            } else if (arr1[i] == 2) { // 바위
                if (arr2[i] == 1) {
                    System.out.println("A");
                } else if (arr2[i] == 3) {
                    System.out.println("B");
                }
            } else { // 보
                if (arr2[i] == 1) {
                    System.out.println("B");
                } else if (arr2[i] == 2) {
                    System.out.println("A");
                }
            }
        }

    }
}
