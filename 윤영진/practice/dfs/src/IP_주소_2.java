import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IP_주소_2 {
    String S;
    List<String> points;
    List<String> results;

    public String[] solution(String s) {
        String[] answer;
        results = new ArrayList<>();
        points = new ArrayList<>();
        S = s;
        dfs(0);

        answer = new String[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }

    private void dfs(int start) {
        if (points.size() == 4 && start == S.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(points.get(0)).append(".").append(points.get(1)).append(".").append(points.get(2)).append(".").append(points.get(3));
            results.add(sb.toString());
        } else {
            for (int i = start; i < S.length(); i++) {
                if (S.charAt(start) == '0' && i > start) return;
                String num = S.substring(start, i + 1);
                if (Integer.parseInt(num) > 255) return;
                points.add(num);
                dfs(i + 1);
                points.remove(points.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        IP_주소_2 T = new IP_주소_2();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}