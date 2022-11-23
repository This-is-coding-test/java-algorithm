package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 교차로 {

    // 효율적인 도로 교통 흐름을 위해서는 자동차끼리의 충돌을 방지할 수 있도록 자동차가 적절히 멈춰 있도록 하되, 너무 오래 멈춰 있지 않도록 소프트웨어를 적절하게 작성해야 한다.
    // 각 도로의 맨 앞에 있는 자동차는 자신을 기준으로 오른쪽에 위차한 도로에 차량이 있으면 1초 동안 출발하지 않고, 차량이 없으면 즉시 교차로를 통과한다.
    // A -> D / B -> A / C -> B / D -> C

    // 만약, A, B, C, D 위치에 동시에 차량이 한 대 이상씩 있다면, 교착 상태에 빠져 어떤 차량도 교차로를 통과할 수 없게 된다.
    // 앞으로 N대의 차량이 교차로를 통과하기 위해 A, B, C, D 위치에 진입할 것이다.
    // ti초 때에 wi위치에 진입하여, 해당 차선에 있는 줄 맨 뒤에 있을 예정

    // 매초마다 모든 차량이 진입한 직후, 각 위치의 맨 앞에 있는 차량은 오른쪽 위치에 차량이 없는지 확인한 뒤, 차량이 없다면 교차로를 통과한다.
    // 각 차량이 교차로를 통과하는 시각이 언제인지 계산

    static class Car {
        int idx;
        int time;

        public Car(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }


    }

    static int N;
    static List<Queue<Car>> queues = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        // A, B, C, D 큐 생성
        for (int i = 0; i < 4; i++) {
            queues.add(new LinkedList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char type = st.nextToken().charAt(0);
            queues.get(type - 'A').offer(new Car(i, time));
            // A -> 0, D -> 3, C -> 2, B -> 1
            // (d + 3) % 4
        }

        int currTime = -1; // 현재 시간 -> 0부터 진입 가능능
        int[] answer = new int[N]; // 결과
        int[] isWaiting = new int[4]; // 교차로를 통과하려는 차량의 존재유무

        for (int i = 0; i < N; i++) {
            answer[i] = -1;
        }

        while (check()) { // 큐가 하나라도 안비었으면 반복
            // 큐의 헤드 원소의 시간이 currTime 보다 작거나 같은 경우 현재 시간보다 일찍 들어와서 기다리고 있는 차량이라는 뜻이므로 isWaiting 에 해당 큐 표시
            // 기다리고 있는 차량이 4개이면 교착상태라는 뜻이므로 break
            // 기다리고 있는 차량이 0개이면 현재 시간에 들어온 차량이 아직 없다는 뜻이므로 curr_time을 각 큐에 헤드 원소의 시간들 중 가장 작은 시간으로 업데이트 후 continue
            // break나 continue가 진행되지 않았을 경우, 교차로를 통과할 수 있는 차량들은 통과가 된다. 오른쪽 차선에 차가 없을 경우 queue에서 pop해주고 순서 인덱스에 해당하는 answer 리스트의 값을 curr_time으로 업데이트한다.
            // 다시 isWaiting을 초기화

            int minTime = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                if (!queues.get(i).isEmpty()) {
                    int time = queues.get(i).peek().time;
                    minTime = Math.min(time, minTime);
                    if (time <= currTime) {
                        isWaiting[i] = 1;
                    }
                }
            }
            int sum = Arrays.stream(isWaiting).sum();
            if (sum == 4) { // 교착상태
                break;
            }
            if (sum == 0) {
                currTime = minTime;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                if (isWaiting[i] == 1 && isWaiting[(i + 3) % 4] == 0) {
                    Car car = queues.get(i).poll();
                    answer[car.idx] = currTime;
                }
            }
            isWaiting = new int[4];
            currTime++;
        }

        for (int x : answer) {
            System.out.println(x);
        }


    }

    private static boolean check() {
        return !queues.get(0).isEmpty() || !queues.get(1).isEmpty()
                || !queues.get(2).isEmpty() || !queues.get(3).isEmpty();
    }


}
