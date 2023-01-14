import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팔진수_이진수 {
    // 8진수 -> 10진수 -> 2진수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        String[] nums = {"000", "001", "010", "011", "100", "101", "110", "111"};

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            sb.append(nums[num]);
        }


        if(s.equals("0")) System.out.println(s);
        else{
            while(sb.charAt(0) == '0') sb = new StringBuilder(sb.substring(1));
            System.out.println(sb);
        }

    }
}
