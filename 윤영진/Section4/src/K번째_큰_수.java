import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class K번째_큰_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // TreeSet은 중복 제거, 자동 정렬
        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());

        // TreeSet에서 해당 숫자 제거
        // ts.remove("143");

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    ts.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }
        if (ts.size() < K) {
            System.out.println(-1);
            return;
        }

        int cnt = 0;
        for (int x : ts) {
            cnt++;
            if (cnt == K) {
                System.out.println(x);
            }
        }


    }
}
