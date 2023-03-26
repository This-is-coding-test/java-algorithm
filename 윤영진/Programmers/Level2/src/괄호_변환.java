import java.util.*;

class 괄호_변환 {
    // 다른 개발자가 작성한 소스 코드를 분석하여 문제점을 발견하고 수정하라는 업무 과제
    // 소스를 컴파일하여 로그를 보니 대부분 소스 코드 내 작성된 괄호가 개수는 맞지만 짝이 맞지 않는 형태로 작성되어 오류가 나는 것

    static String answer = "";
    public String solution(String p) {
        if(p.equals("")) return p;

        // 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리
        int idx = split(p);
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);
        if(isPossible(u)) {
            answer += u + solution(v);
        }
        else {
            StringBuilder sb = new StringBuilder("(");
            sb.append(solution(v)).append(")");
            u = u.substring(1, u.length());
            u = u.substring(0, u.length() - 1);
            for(int i = 0; i < u.length();i++) {
                char c = u.charAt(i);
                if(c == '(') {
                    sb.append(")");
                }else {
                    sb.append("(");
                }
            }
            return sb.toString();
        }

        return answer;

    }

    public boolean isPossible(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') stack.push('(');
            else if(c ==')') {
                if(stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return false;

        return true;

    }

    public int split(String p) {

        int left = 0;
        int right = 0;

        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if(c == '(') left++;
            else if(c ==')') right++;

            if(left == right) return i;
        }

        return -1;
    }
}