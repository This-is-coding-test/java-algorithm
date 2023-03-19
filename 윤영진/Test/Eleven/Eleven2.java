package Test.Eleven;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Eleven2 {
    static int n;
    static List<Integer> idxList = new ArrayList<>();
    static boolean[] visited;
    static int answer = Integer.MIN_VALUE;

    public static int solution(String S) {
        n = S.length();
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '?') idxList.add(i);
        }
        visited = new boolean[idxList.size()];

        backtracking(0, 0, S);
        return answer;

    }

    private static void backtracking(int depth, int start, String s) {
        if (depth == idxList.size()) {
            calc(s);
        } else {
            for (int i = start; i < idxList.size(); i++) {
                backtracking(depth + 1, i + 1, s.substring(0, idxList.get(i)) + "<" + s.substring(idxList.get(i) + 1));
                backtracking(depth + 1, i + 1, s.substring(0, idxList.get(i)) + ">" + s.substring(idxList.get(i) + 1));
            }
        }
    }

    private static void calc(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '<') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int start = stack.pop();
                    int len = i - start + 1;
                    if (len % 2 == 0) {
                        int mid = start + len / 2 - 1;
                        boolean isPossible = true;
                        for (int j = start; j <= mid; j++) {
                            char left = s.charAt(j);
                            char right = s.charAt(i - (j - start));
                            if (left != '<' || right != '>') {
                                isPossible = false;
                                break;
                            }
                        }
                        if (isPossible) {
                            maxLength = Math.max(maxLength, len);
                        }
                    }
                }
            }
        }
        answer = Math.max(answer, maxLength);
    }

    public static void main(String[] args) {
        int solution = solution("<><??>>");
        System.out.println(solution);
    }

}
