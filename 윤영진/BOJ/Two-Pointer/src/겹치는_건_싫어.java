import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 겹치는_건_싫어 {

    static int N, K;
    static int[] arr;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int cnt = 0;

        for (int right = 0; right < N; right++) {
            int curr = arr[right];
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while (map.get(curr) > K) {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }

            cnt = Math.max(cnt, right - left + 1);
        }
        System.out.println(cnt);

    }
}
