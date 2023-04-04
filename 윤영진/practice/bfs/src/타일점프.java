import java.util.*;

class 타일점프 {
    int[] Nums;
    boolean[] visited;
    int answer;

    public int solution(int[] nums) {
        answer = 0;
        Nums = nums;
        visited = new boolean[nums.length];

        if(!bfS()) {
            answer = -1;
        }
        return answer;
    }

    private boolean bfS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len ; i++) {
                Integer curr = queue.poll();
                if(curr == Nums.length - 1) return true;
                for (int j = 1; j <= Nums[curr]; j++) {
                    int next = curr + j;
                    if(next < Nums.length && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            answer++;
        }
        return false;


    }

    public static void main(String[] args) {
        타일점프 T = new 타일점프();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}