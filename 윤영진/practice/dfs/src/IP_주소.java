import java.util.*;

class IP_주소 {
    String S;
    List<Integer> points;
    List<String> results;

    public String[] solution(String s) {
        String[] answer;
        results = new ArrayList<>();
        points = new ArrayList<>();
        S = s;
        dfs(0, 1);

        answer = new String[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }

    private void dfs(int depth, int start) {
        if (depth == 3) {
            String tmp = "";
            if (!((tmp = isPossible()).equals("noob"))) {
                results.add(tmp);
            }
        } else {

            for (int i = start; i < S.length(); i++) {
                points.add(i);
                dfs(depth + 1, i + 1);
                points.remove(points.size() - 1);
            }

        }
    }

    private String isPossible() {

        String[] st = new String[4];
        st[0] = S.substring(0, points.get(0));
        st[1] = S.substring(points.get(0), points.get(1));
        st[2] = S.substring(points.get(1), points.get(2));
        st[3] = S.substring(points.get(2));
        for (int i = 0; i < 4; i++) {
            String s = st[i];
            if (s.length() > 1 && s.charAt(0) == '0') return "noob";
            if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255 || s.length() > 3) return "noob";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(st[0]).append(".").append(st[1]).append(".").append(st[2]).append(".").append(st[3]);
        return sb.toString();
    }

    public static void main(String[] args) {
        IP_주소 T = new IP_주소();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}