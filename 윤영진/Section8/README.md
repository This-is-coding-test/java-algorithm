# SECTION 8. DFS, BFS 활용

## 합이 같은 부분집합

DFS를 호출할 때 인자로 레벨 인자를 넣어줌으로써 트리의 레벨과 함수의 인덱스를 일치시킬 수 있다. 

해당 레벨에서는 배열의 레벨에 해당하는 인덱스의 원소가 포함되는지 안되는지를 결정한다. 

![KakaoTalk_20220829_202607430](https://user-images.githubusercontent.com/83503188/187203695-656fabcd-ae58-4196-9f46-a9023e1d397e.jpg)

## 중복순열 구하기 

![KakaoTalk_20220829_210052379](https://user-images.githubusercontent.com/83503188/187203698-8f70f953-bcbb-4bc0-8baf-d331dca31c39.jpg)
## 동전교환

동전교환 문제는 앞 문제인 중복순열 구하기 문제와 비슷했다.

다만, 시간초과를 해결하기 위해서 Array를 역방향으로 정렬하고

```java
Arrays.sort(coins, Collections.reverseOrder());
```

만약 현재까지 구해진 결과보다 깊은 L일 경우 종료시키는 조건을 추가하는 것이 중요했다. 


## 순열 구하기 

위의 중복순열 구하기 문제와 크게 다르지 않았지만 check라는 boolean 배열을 통해 한번 방문한 인덱스를 건너 뛰는 조건을 추가해야했다.

```java
if (!ch[i]) {
    ch[i] = true;
    output[L] = arr[i];
    DFS(L + 1);
    ch[i] = false;
}
```

![KakaoTalk_20220829_213137716](https://user-images.githubusercontent.com/83503188/187203704-2f66621b-40bf-4f2b-a5d5-cede1feb132f.jpg)

## 조합의 경우수(메모리제이션)

![KakaoTalk_20220829_214128263](https://user-images.githubusercontent.com/83503188/187203708-fae2ccef-071d-4e36-b014-0bcc5f77069c.jpg)

## 수열 추측하기 

수열 추측하기 문제는 앞 문제의 조합의 경우수와 순열을 구해서 푸는 문제이다. 

![KakaoTalk_20220829_215114002](https://user-images.githubusercontent.com/83503188/187205202-510b4b4c-38e2-4101-979d-715146508992.jpg)

위 공식을 처리하기 위헤서 먼저 N을 통해 N짜리 크기의 배열을 초기화해준다. 만약 N = 4라면 {3C0, 3C1, 3C2, 3C3}

DFS를 통해 순열을 구하고, 순열과 앞에서 구한 배열을 곱해서 결과값과 비교하는 과정을 거친다. 

## 조합 구하기

![KakaoTalk_20220831_191334821](https://user-images.githubusercontent.com/83503188/187655764-69960154-e1c3-44a1-ae82-7d41614694a2.jpg)

## 피자 배달 거리

순열 문제인 것을 인지하지 못해서 어려웠던 문제였다. 예를 들어 피자집이 6개이고 그 중 4개를 골라야하는 경우 6C4 가지를 확인하며 가장 최소의 피자배달거리를 출력하면 된다.

먼저 입력받을 때 1인 경우는 home 리스트에 2인 경우에는 pizza 리스트에 저장한 뒤 앞 문제에서 순열 구하는 방법을 이용한다. 

원소가 결정된 경우 home 리스트의 원소와 순열의 원소를 이용하여 거리를 계산하면 된다.





 