# SECTION 6. Sorting and Searching(정렬, 이분검색과 결정알고리즘)

## 선택정렬

![KakaoTalk_20220815_180424028](https://user-images.githubusercontent.com/83503188/184611253-ae5eb9f1-82c8-42d5-a270-b4d5728f0970.jpg)



## 버블정렬

![KakaoTalk_20220815_181112455](https://user-images.githubusercontent.com/83503188/184611286-6b9aec36-0818-4a22-bfc7-8363a3115a8a.jpg)

## 삽입정렬

![KakaoTalk_20220815_182609368](https://user-images.githubusercontent.com/83503188/184611290-cad4aa7e-eb08-49b4-8424-21e2bad29794.jpg)


## Last Recently Used

캐시가 Hit된 경우 Miss된 경우를 나눠서 푸는 문제다. 

캐시가 Hit된 경우 Hit된 위치(=pos)부터 1번 인덱스까지 오른쪽으로 하나씩 밀어넣고 Miss된 경우 캐시 사이즈 마지막부터 1번 인덱스까지 오른쪽으로 하나씩 밀어넣으면 된다.

캐시가 Hit, Miss 두 경우 모두 현재 값은 인덱스 0번에 넣는다.

## 이분 검색

![KakaoTalk_20220815_185520048](https://user-images.githubusercontent.com/83503188/184615389-5c90ae57-dfc4-4470-8e77-515f6399ac72.jpg)


## 뮤직비디오(결정알고리즘)

결정알고리즘은 이분검색을 기반으로 푸는 문제이다. 

결정알고리즘이 적합한지 확인하기 위해서는 정답값이 해당 범위안에 존재하는 문제인지 확인해야한다.

해당 문제는 전체 곡을 해당 용량 안에 나눠서 넣을 수 있는지 판단하는 문제이다.

따라서 정답이 가능한 최소 용량은 해당 곡중 가장 길이가 긴 곡으로 선정하고, 최대 용량은 모든 곡의 길이를 합한 값이 된다.


