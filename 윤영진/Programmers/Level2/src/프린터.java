import java.util.*;

class 프린터 {
    // 인쇄 요청이 들어온 순서대로 인쇄 -> 중요한 문서가 나중에 인쇄될 수 있다.
    // 이러한 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발
    static class Pair {
        int num;
        int priority;

        public Pair(int num, int priority) {
            this.priority = priority;
            this.num = num;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Pair(i, priorities[i]));
        }

        int count = 0;
        while (!queue.isEmpty()) {
            boolean check = true;
            Pair p = queue.poll();

            for (Pair pair : queue) {
                if (pair.priority > p.priority) {
                    queue.offer(p);
                    check = false;
                    break;
                }
            }

            if (check) {
                count++;
                if (p.num == location) return count;
            }

        }


        return answer;
    }
}