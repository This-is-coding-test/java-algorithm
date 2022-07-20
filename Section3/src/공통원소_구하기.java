import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 공통원소_구하기 {
    public static void main(String[] args) throws IOException {
        // TODO Set 함수 공부하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set1.add(Integer.parseInt(st.nextToken()));
        }
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set2.add(Integer.parseInt(st.nextToken()));
        }

        set1.retainAll(set2);

        set1.stream().sorted(Comparator.comparingInt(o -> o)).forEach(integer -> System.out.print(integer+ " "));



    }
}
