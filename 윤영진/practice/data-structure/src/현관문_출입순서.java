import java.util.*;

class 현관문_출입순서 {
    // 현관문은 동시에 2명이상 출입이 불가능
    // 1초에 한명씩만 출입
    // 0번부터 n - 1번의 사원번호를 갖고 있는 사원이 현관문을 출입 하는데 규칙

    // 1. 1초 전에 현관문을 사용한 적이 없으면 나가는 사원이 먼저 현관문을 이용합니다.
    // 2. 1초 전에 나가는 사원이 현관문을 이용햇다면 나가는


    public int[] solution(int[] arrival, int[] state) {
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n = arrival.length;
        int t = 0;
        int cnt = 0;
        int[] answer = new int[n];
        int prev = 1; // 0 - 1초전에 들어온 사원 사용, 1 - 1초전에 나가는 사원 사용

        for (int i = 0; ; t++) {
            if (enter.isEmpty() && exit.isEmpty() && i < n) { // 건너뛰기
                if (t < arrival[i]) {
                    t = arrival[i];
                    prev = 1;
                }
            }

            while (i < n && arrival[i] <= t) {
                if (state[i] == 0) {
                    enter.offer(i);
                } else {
                    exit.offer(i);
                }
                i++;

            }
            if (prev == 1) {
                if (!exit.isEmpty()) {
                    answer[exit.poll()] = t;
                } else {
                    answer[enter.poll()] = t;
                    prev = 0;
                }
            } else {
                if (!enter.isEmpty()) {
                    answer[enter.poll()] = t;
                } else {
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }
            cnt++;
            if (cnt == n) break;

        }

        return answer;
    }

    public static void main(String[] args) {
        현관문_출입순서 T = new 현관문_출입순서();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}