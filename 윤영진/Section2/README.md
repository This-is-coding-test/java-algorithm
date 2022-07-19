# SECTION 2. Array(1, 2차원 배열)

1000MS = 1초

O(N^2) -> N 최대 100,000 -> 100,000 * 100,000 = 1억을 넘는다.

N으로 구성된 O()를 계산했을 때의 값이 1억 정도면 1초 정도의 시간이 걸린다.

## 보이는 학생

시간 제한: 1000MS = 1S

N -> 5 <= N <= 100,000: 2중 for문으로 구현할 경우 Timeout 발생되는 N범위

![image](https://user-images.githubusercontent.com/83503188/178539361-73346f7d-c5c3-454a-ac4c-d548713d891f.png)

거의 차이가 없다

![image](https://user-images.githubusercontent.com/83503188/178539463-97bf075a-555f-4901-9067-3a4e9d7779f4.png)

N = 100,000이고 학생의 키가 1 ~ 100,000으로 입력된 예제가 있었다면 아마 timeout이 발생했을 것 같다.

## 소수(에라토스테네스 체)

기존 소수를 구하는 방법이 아닌 i = 2부터 for문을 돌아서 해당 i에 배수에 해당하는 수는 소수가 될 수 없으므로 소거하는 방법

## 뒤집은 소수

StringBuilder를 통해 해당 수를 reverse() 시킨 뒤 다시 Integer로 변환하였다.

강사님은 따로 라이브러리를 사용하지 않고 연산을 통해 수를 뒤집었는데 연산은 아래와 같다.

```java
int num = 0;
while (tmp > 0) {
     int t = tmp % 10; 
     num = num * 10 + t;
     tmp = tmp / 10;
}
```

## 격자판 최대합

행과 열을 서로 다른 2중 for문에서 연산을 해야한다고 착각했다. i와 j만 바꾼다면 쉽게 처리 가능하다.

```java
// 행,열 계산
        for (int i = 0; i < N; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < N; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            result = Math.max(result, sum1);
            result = Math.max(result, sum2);

        }
```

또한 대각선 연산을 2중 for문을 통해 구현하였는데, N * N 격자판이므로 단일 for문으로도 해결 가능하다.

```java
for (int i = 0; i < N; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][(N - i) - 1];
}
```

## 봉우리

DFS, BFS 문제에서 항상 등장하던 dx, dy를 사용하면 코드를 보기좋게 짤 수 있다.

```java
static int[] dx = {-1, 0, 1, 0};
static int[] dy = {0, 1, 0, -1};
```

## 임시반장 정하기

가장 필요했던 문제이다. 2중 for문을 돌며 탐색할 때 해당 i가 의미하는 것과 j가 의미하는 것을 정하고 풀어야 된다.

```java
for (int i = 1; i <= N; i++) {
            int cnt = 0; // i번 학생의 cnt
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    for (int k = 1; k <= 5; k++) {
                        if (map[i][k] == map[j][k]) {
                            cnt++;
                            break;
                        }
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }
```

여기서 i는 기준이 되는 학생이고, j는 비교가 되는 학생이다. 

단, 1번 학생이 2번 학생과 2학년, 3학년 때 같은 반 이였다고 두번으로 치지 않으므로 break문을 걸어줘야 한다.

## 멘토링

강사님과 문제풀이가 달랐던 문제이다. 테스트에는 모두 통과했지만 이 방식이 맞는지 정확히 모르겟다.

강사님은 4중 for문을 통해 문제를 해결하셨다.

가장 바깥의 i for문은 멘토 학생, 다음 j for문은 멘티 학생, 다음 k for문은 test 열, 다음 l for문은 test 행이다.

나는 2중 for문을 통해 문제를 해결하였다. 

N = 4, M = 3인 경우 멘토, 멘티가 될 수 있는 경우는 총 16가지이다. 4 * 4 배열을 만들고 테스트 배열(3 * 4)을 탐색한다.

![image](https://user-images.githubusercontent.com/83503188/179787423-bff88a0a-3a45-4d46-ad59-9e0fdd6312b2.png)

