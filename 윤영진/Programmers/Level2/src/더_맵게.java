import java.util.PriorityQueue;

public class 더_맵게 {
    static PriorityQueue<Integer> pQ = new PriorityQueue<>();
    static int k;
    static boolean flag = false;

    public int solution(int[] scoville, int K) {
        int answer = -1;
        k = K;

        for (int s : scoville) {
            pQ.offer(s);
        }

        while (pQ.peek() < k && pQ.size() != 1) {
            answer++;
            int n1 = pQ.poll();
            int n2 = pQ.poll();

            int nS = n1 + (n2 * 2);
            pQ.offer(nS);
        }

        if (pQ.size() == 1 && pQ.peek() < k) {
            return -1;
        }

        return answer + 1;
    }

    public boolean check() {
        return pQ.peek() < k;
    }
}
