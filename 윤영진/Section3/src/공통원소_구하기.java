import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 공통원소_구하기 {
//    public static void main(String[] args) throws IOException {
//        // TODO Set 함수 공부하기
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int N = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        Set<Integer> set1 = new HashSet<>();
//        Set<Integer> set2 = new HashSet<>();
//
//        for (int i = 0; i < N; i++) {
//            set1.add(Integer.parseInt(st.nextToken()));
//        }
//        N = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            set2.add(Integer.parseInt(st.nextToken()));
//        }
//
//        set1.retainAll(set2);
//
//        set1.stream().sorted(Comparator.comparingInt(o -> o)).forEach(integer -> System.out.print(integer + " "));
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Integer[] arr1 = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Integer[] arr2 = new Integer[M];

        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr2);

        int p1 = 0;
        int p2 = 0;

        List<Integer> answer = new ArrayList<>();

        while (p1 < N && p2 < M) {
            if (arr1[p1] < arr2[p2]) {
                p1++;
            } else if (arr1[p1] > arr2[p2]) {
                p2++;
            }else {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            }
        }

        answer.forEach(result -> System.out.print(result + " "));
    }
}
