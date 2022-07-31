package 응급실;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Main {

    public int solution(int n, int m, int[] arr) {
        int answer = 1;
        Queue<Person> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(new Person(i, arr[i]));
        }

        while (!q.isEmpty()) {
            Person tmp = q.poll();

            // 뒤에 우선순위가 높은 환자가 있으면 마지막으로
            for (Person x : q) {
                if (x.priority > tmp.priority) {
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }

            // 뒤에 우선순위가 높은 환자가 더 이상 없으면
            if (tmp != null) {
                if (tmp.id == m) {
                    // m 이면 answer 반환
                    return answer;
                } else {
                    // m 이 아니면 poll 하고 카운팅만
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Main main = new Main();
        int answer = main.solution(n, m, arr);
        System.out.println(answer);
    }

}
