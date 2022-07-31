import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 매출액의_종류 {
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
        int left = 0;
        int right = K - 1; // 3
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < K - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = right; i < N; i++) { // 3,4,5,6
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            System.out.print(map.size() + " ");
            map.put(arr[left], map.get(arr[left]) - 1);
            if (map.get(arr[left]) == 0) {
                map.remove(arr[left]);
            }
            left++;

        }
    }
}
