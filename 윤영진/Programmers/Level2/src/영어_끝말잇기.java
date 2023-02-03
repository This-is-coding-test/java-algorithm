import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 영어_끝말잇기 {

    public static int[]  solution(int n, String[] words) {
        int[] answer = {};
        Set<String> wordSet = new HashSet<>();
        int time = 1;
        int p = 0;
        String prev = words[0];
        boolean flag = false;
        wordSet.add(prev);

        for (int i = 1; i < words.length; i++) {



            p = ((p + 1) % (n));
            if(p == 0) time++;
            if(words[i].length()<=1){ //글자 수가 1이하일때 탈락
                flag = true;
                break;
            }

            if (wordSet.contains(words[i]) || !(prev.substring(prev.length() - 1).equals(words[i].substring(0, 1)))) {
                flag = true;
                break;
            }
            prev = words[i];

        }
        if(flag) {
            answer = new int[] {p+1, time};
        } else {
            answer = new int[] {0,0};
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] solution = solution(2, new String[]{"ac", "ca", "ac", "ac"});
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }
}
