import java.util.*;

class 알파코드 {
    // A - 1, B - 2, ... Z - 26
    // DFS(i) : i번째 인덱스부터 문자열을 알파벳으로 복원하는 경우의 수
    // -> 메모리제이션

    int[] dp;
    String S;
    int answer;

    public int solution(String s) {
        answer = 0;
        dp = new int[51];
        S = s;
        return dfs(0);
    }

    private int dfs(int start) {
        if (dp[start] > 0) return dp[start];
        if (start < S.length() && S.charAt(start) == '0') return 0;
        if (start == S.length() - 1 || start == S.length()) return 1;
        else {
            int res = dfs(start + 1);
            // 2번째 자리까지는 가능성 존재
            int num = Integer.parseInt(S.substring(start, start + 2));
            if (num < 26) res += dfs(start + 2);
            return dp[start] = res;
        }
    }

    public static void main(String[] args) {
        알파코드 T = new 알파코드();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}