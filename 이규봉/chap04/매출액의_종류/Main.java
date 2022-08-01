package 매출액의_종류;

import java.util.*;

public class Main {

    public List<Integer> solution(int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        /* 투 포인터 알고리즘 */
        int lt = 0;

        for (int rt = k - 1; rt < arr.length; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());

            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Main main = new Main();
        List<Integer> answer = main.solution(k, arr);
        for (int e : answer) {
            System.out.print(e + " ");
        }

        // foreach 메서드로 제출하니까 시간초과
//        answer.forEach(e -> System.out.print(e + " "));
    }

}
