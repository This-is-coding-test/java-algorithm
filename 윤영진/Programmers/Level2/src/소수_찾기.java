import java.util.*;

class 소수_찾기 {
    static int n;
    static char[] nums;
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;
        n = numbers.length();
        nums = new char[n];

        for (int i = 0; i < n; i++) {
            char c = numbers.charAt(i);
            nums[i] = c;
        }

        for (int i = 1; i <= n; i++) { // 1자리 ~ n자리
            visited = new boolean[n];
            permutate(i, 0, "");
        }
        return set.size();
    }

    public void permutate(int size, int depth, String curr) {
        if (depth == size) {
            int num = Integer.parseInt(curr);
            if (set.contains(num)) return;
            if (isPrime(num)) {
                set.add(num);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    curr += String.valueOf(nums[i]);
                    permutate(size, depth + 1, curr);
                    curr = curr.substring(0, curr.length() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}