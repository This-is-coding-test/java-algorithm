import java.util.*;

class 최대_인원수 {
    // 1번 역부터 n번 역 사이를 운행하는 어린이용 기차
    // 모든 기차는 각각 수용인원이 정해져 있다. -> s번 역부터 e번 역까지 운행
    // 모든 기차는 한 번만 운행, 현수는 최대한 많은 어린이가 기차를 이용할 수 있도록 예약


    public int solution(int n, int[][] trans, int[][] bookings) {
        int answer = 0;
        // sum[i] : i 번역에서 탈 수 있는 최대 인원수
        int[] sums = new int[n + 1];
        for (int[] tran : trans) {
            sums[tran[0]] += tran[2];
            sums[tran[1]] -= tran[2];
        }
        for (int i = 1; i <= n; i++) {
            sums[i] += sums[i - 1];
        }

        Arrays.sort(bookings, (o1, o2) -> o1[0] - o2[0]);
        LinkedList<Integer> nums = new LinkedList<>();
        int idx = 0;
        int bN = bookings.length;
        for (int i = 1; i <= n; i++) {
            // 1. 해당 역에서 내리는 어린이 out
            while (!nums.isEmpty() && nums.peek() == i) {
                nums.pollFirst();
                answer++;
            }
            // 2. 해당 역에서 타는 어린이 in
            while (idx < bN && bookings[idx][0] == i) {
                nums.add(bookings[idx++][1]);
            }
            Collections.sort(nums);
            // 3. 해당 역에서 탈 수 있는 인원 확인
            while (nums.size() > sums[i]) {
                nums.pollLast();
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        최대_인원수 T = new 최대_인원수();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}