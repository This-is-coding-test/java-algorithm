import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

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
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    list.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        List<Integer> collect = list.stream().distinct().sorted(Comparator.comparingInt(o -> -o)).collect(Collectors.toList());
        if (K > collect.size()) {
            System.out.println(-1);
            return;
        }
        System.out.println(collect.get(K - 1));


    }
}
