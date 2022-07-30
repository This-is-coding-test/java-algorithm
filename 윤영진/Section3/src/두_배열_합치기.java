import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 두_배열_합치기 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int N = Integer.parseInt(br.readLine());
//        List<Integer> list1 = new ArrayList<>();
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            list1.add(Integer.parseInt(st.nextToken()));
//        }
//        N = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            list1.add(Integer.parseInt(st.nextToken()));
//        }
//
//        list1.stream().sorted(Comparator.comparingInt(o -> o)).forEach(integer -> System.out.print(integer+ " "));
//
//    }

    // two pointers algorithm
    // 정렬 -> O(NlogN) -> N = 60000이라면 60000 * log(2^16) = 60000 * 16 = 960000
    // O(n)으로 구해보자!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Integer> answer = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[M];

        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0;
        int p2 = 0;

        while (p1 < N && p2 < M) {
            if (arr1[p1] <= arr2[p2]) {
                answer.add(arr1[p1++]);
            } else {
                answer.add(arr2[p2++]);
            }
        }
        if (p1 < N) {
            for (int i = p1; i < N; i++) {
                answer.add(arr1[i]);
            }
        }

        if (p2 < M) {
            for (int i = p2; i < M; i++) {
                answer.add(arr2[i]);
            }
        }

        answer.forEach(result -> System.out.print(result + " "));


    }

}
