public class N으로_표현 {

    static int answer = -1;

    public static int solution(int N, int number) {

        dfs(N, 0, 0, number);

        return answer;
    }

    public static void dfs(int n, int pos, int num, int number) {
        if (pos > 8) return;
        if (num == number) {
            if (pos < answer || answer == -1) {
                answer = pos;
            }
            return;
        }

        int tmpN = 0;
        for (int i = 1; i < 9; i++) {
            tmpN = tmpN * 10 + n;
            dfs(n, pos + i, num + tmpN, number);
            dfs(n, pos + i, num - tmpN, number);
            dfs(n, pos + i, num * tmpN, number);
            dfs(n, pos + i, num / tmpN, number);
        }
    }

    public static void main(String[] args) {
        int solution = solution(11, 3);
        System.out.println(solution);

    }
}
