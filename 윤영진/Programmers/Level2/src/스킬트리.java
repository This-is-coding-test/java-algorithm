import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스킬트리 {
    static Queue<Character> queue = new LinkedList<>();
    static Set<Character> skillSet = new HashSet<>();

    public static int solution(String skill, String[] skill_trees) {


        int answer = 0;
        for (String skills : skill_trees) {
            init(skill);
            answer++;

            for (char s : skills.toCharArray()) {
                if (skillSet.contains(s)) {
                    if (!queue.poll().equals(s)) { // C
                        answer--;
                        break;
                    }
                }
            }
            queue.clear();
        }


        return answer;
    }

    private static void init(String skill) {
        for (char c : skill.toCharArray()) {
            skillSet.add(c);
            queue.offer(c);
        }
    }

    public static void main(String[] args) throws IOException {
        int cbd = solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        System.out.println(cbd);
    }
}
