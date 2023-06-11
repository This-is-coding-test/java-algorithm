import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능_개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();


        for (int i = 0; i < progresses.length; i++) {
            int time = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) time++;
            queue.offer(time);
            // [5, 10, 1, 1, 20, 1]
        }

        int prev = queue.poll(); // 5
        int count = 1;
        while (!queue.isEmpty()) {
            int next = queue.poll();
            if (prev < next) {
                prev = next;
                result.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        result.add(count);

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
