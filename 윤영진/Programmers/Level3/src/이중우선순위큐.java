import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    static
    public int[] solution(String[] operations) {

        for (String operation : operations) {
            String[] s = operation.split(" ");
            if (s[0].equals("I")) {
                minHeap.offer(Integer.parseInt(s[1]));
                maxHeap.offer(Integer.parseInt(s[1]));
            } else {
                if (!minHeap.isEmpty()) {
                    if (s[1].equals("1")) {
                        int max = maxHeap.poll();
                        minHeap.remove(max);
                    } else {
                        int min = minHeap.poll();
                        maxHeap.remove(min);
                    }
                }
            }
        }

        if (minHeap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{minHeap.poll(), maxHeap.poll()};
        }
    }
}
