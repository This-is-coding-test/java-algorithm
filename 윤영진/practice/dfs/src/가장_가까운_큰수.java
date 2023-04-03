import java.util.*;

class 가장_가까운_큰수 {
    static char[] nums;
    static boolean[] visited;
    int N;
    int size;
    int answer;
    boolean flag;

    public int solution(int n) {
        flag = false;
        answer = Integer.MAX_VALUE;
        N = n;
        String s = String.valueOf(n);
        size = s.length();
        nums = new char[size];
        visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            nums[i] = s.charAt(i);
        }
        Arrays.sort(nums);
        dfs(0, "");
        if(!flag) answer = -1;
        return answer;
    }

    private void dfs(int depth, String st) {
        if(flag) return;
        if (depth == size) {
            if (Integer.parseInt(st) > N) {
                answer = Integer.parseInt(st);
                flag = true;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(depth + 1, st + nums[i]);
                    visited[i] = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        가장_가까운_큰수 T = new 가장_가까운_큰수();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}